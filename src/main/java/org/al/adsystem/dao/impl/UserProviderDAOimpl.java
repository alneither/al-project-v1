package org.al.adsystem.dao.impl;

import org.al.adsystem.dao.iface.UserProviderDAO;
import org.al.adsystem.exception.UserAuthenticationException;
import org.al.adsystem.model.domain.bean.User;
import org.al.adsystem.util.UserHashHandleUtility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import static org.al.adsystem.util.Constant.*;


@Repository
public class UserProviderDAOimpl implements UserProviderDAO {

    private static final String INCORRECT_LOGIN_ATTEMPT_BY_USERNAME = "Incorrect attempt of login by username: ";
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Transactional
    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        User trueUser = getUserByLogin(login);
        String salt = trueUser.getSalt();
        String hash = trueUser.getHash();

        String controlHash = UserHashHandleUtility.getHash(password, salt);

        if (controlHash.equals(hash)) {
            return trueUser;
        } else {
            throw new UserAuthenticationException(INCORRECT_LOGIN_ATTEMPT_BY_USERNAME + login);
        }
    }

    @Transactional
    @Override
    public User getUserByLogin(String login) {
        String hq1 = "from User where login=:login";
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(hq1);
        query.setParameter(LOGIN, login);
        User user = (User) query.uniqueResult();
        return user;
    }

    @Transactional
    @Override
    public void removeUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(user);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
