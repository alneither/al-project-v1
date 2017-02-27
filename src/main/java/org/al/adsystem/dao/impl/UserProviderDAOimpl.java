package org.al.adsystem.dao.impl;

import org.al.adsystem.dao.iface.UserProviderDAO;
import org.al.adsystem.model.domain.bean.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import java.util.List;

import static org.al.adsystem.util.Constant.LOGIN;
import static org.al.adsystem.util.Constant.PASSWORD;

@Repository
public class UserProviderDAOimpl implements UserProviderDAO {

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
        String hql = "from User where login=:login and password=:password";

        Query query = makeQuery(hql);
        query.setParameter(LOGIN, login);
        query.setParameter(PASSWORD, password);
        User user = (User)query.uniqueResult();
        return user;
    }

    @Transactional
    @Override
    public User getUserByLogin(String login) {
        String hq1 = "from User where login=:login";
        Query query = makeQuery(hq1);
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

    private Query makeQuery(String hql) {
        Session session = this.sessionFactory.getCurrentSession();
        Query result = session.createQuery(hql);
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
