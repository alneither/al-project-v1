package org.al.adsystem.service.iface;

import org.al.adsystem.model.domain.bean.User;

public interface UserService {

    void signUpUser(User user);

    boolean isSuchUserExists(String login, String password);

    void removeUser(User user);

}
