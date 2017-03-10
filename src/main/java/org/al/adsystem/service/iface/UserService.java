package org.al.adsystem.service.iface;

import org.al.adsystem.model.domain.bean.User;

import javax.transaction.Transactional;

public interface UserService {

    void signUpUser(String login, String password);

    boolean isLoginAllowed(String login, String password);

    boolean isSuchLoginPresent(String login);

    @Transactional
    int getUserIdByLogin(String login);

    void removeUser(User user);

}
