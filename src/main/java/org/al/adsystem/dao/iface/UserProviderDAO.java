package org.al.adsystem.dao.iface;

import org.al.adsystem.model.domain.bean.User;

import javax.transaction.Transactional;

public interface UserProviderDAO {

    void addUser(User user);

    User getUserByLoginAndPassword(String login, String password);

    User getUserByLogin(String login);

    void removeUser(User user);

}
