package org.al.adsystem.service.iface;

import org.al.adsystem.model.domain.bean.User;

import javax.transaction.Transactional;

public interface UserService {

    void signUpUser(String login, String password);

    boolean isSuchUserExists(String login, String password);

    void removeUser(User user);

}
