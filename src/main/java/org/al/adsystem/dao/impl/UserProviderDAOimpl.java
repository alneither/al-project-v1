package org.al.adsystem.dao.impl;

import org.al.adsystem.dao.iface.UserProviderDAO;
import org.al.adsystem.model.domain.bean.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import static org.al.adsystem.util.Constant.*;


@Repository
public class UserProviderDAOimpl implements UserProviderDAO {

    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void addUser(final User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Transactional
    @Override
    public User getUserByLoginAndPassword(final String login, final String password) {
        User resultUser = new User();
        User existentUser = getUserByLogin(login);
        if (existentUser == null) {
            return resultUser;
        }
        return existentUser;
    }

    @Transactional
    @Override
    public User getUserByLogin(final String login) {
        User resultUser = new User();
        String hq1 = "from User where login=:login";
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(hq1);
        query.setParameter(LOGIN, login);

        User existentUser = (User) query.uniqueResult();
        if (existentUser == null) {
            return resultUser;
        }
        return existentUser;
    }

    @Transactional
    @Override
    public void removeUser(final User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(user);
    }

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
