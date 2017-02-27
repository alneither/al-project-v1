package org.al.adsystem.service.impl;

import org.al.adsystem.dao.iface.UserProviderDAO;
import org.al.adsystem.model.domain.bean.User;
import org.al.adsystem.service.iface.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Qualifier("userService")
public class UserServiceImpl implements UserService {

    private UserProviderDAO dao;

    @Transactional
    @Override
    public void signUpUser(User user) {
        String login = user.getLogin();

        if (dao.getUserByLogin(login) == null) {
            dao.addUser(user);
        }
    }

    @Transactional
    @Override
    public boolean isSuchUserExists(String login, String password) {
        User result = dao.getUserByLoginAndPassword(login, password);
        return !(null == result);
    }

    @Transactional
    @Override
    public void removeUser(User user) {
        dao.removeUser(user);
    }

    public void setDao(UserProviderDAO dao) {
        this.dao = dao;
    }
}
