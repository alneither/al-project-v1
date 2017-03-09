package org.al.adsystem.service.impl;

import org.al.adsystem.dao.iface.UserProviderDAO;
import org.al.adsystem.model.domain.bean.User;
import org.al.adsystem.service.iface.UserService;
import org.al.adsystem.util.UserHashHandleUtility;

import static org.apache.commons.lang3.ObjectUtils.NULL;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Qualifier("userService")
public class UserServiceImpl implements UserService {

    private static final int INDEX_0 = 0;
    private UserProviderDAO dao;

    @Transactional
    @Override
    public void signUpUser(final String login, final String password) {
        User testUser = dao.getUserByLogin(login);
        if (testUser.getId() != INDEX_0) {
            return;
        }
        String salt = UserHashHandleUtility.generateSalt();
        String hash = UserHashHandleUtility.getHash(password, salt);
        User user = new User(login, salt, hash);
        dao.addUser(user);
    }

    @Transactional
    @Override
    public boolean isLoginAllowed(final String login, final String password) {
        User user = dao.getUserByLogin(login);

        if (user.getId() == (INDEX_0)) {
            return false;
        }

        String salt = user.getSalt();
        String hash = user.getHash();
        String controlHash = UserHashHandleUtility.getHash(password, salt);

        return (controlHash.equals(hash));

//        if (controlHash.equals(hash)) {
//            return true;
//        } else {
//            throw new UserAuthenticationException(INCORRECT_LOGIN_ATTEMPT_BY_USERNAME + login);
//        }
    }

    @Transactional
    @Override
    public boolean isSuchLoginPresent(final String login) {
        User user = dao.getUserByLogin(login);
        return (user.getId() == INDEX_0);
    }

    @Transactional
    @Override
    public void removeUser(final User user) {
        dao.removeUser(user);
    }

    public void setDao(final UserProviderDAO dao) {
        this.dao = dao;
    }
}
