package org.al.adsystem.controller;

import org.al.adsystem.service.iface.UserService;
import org.al.adsystem.util.UserDataValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.al.adsystem.util.Constant.*;

@Controller
public class LoginController {

    private UserService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.OK)
    public String doLogin(final HttpServletRequest request, final HttpSession session) {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        if (!UserDataValidator.validateSignInData(login, password)) {
            request.setAttribute(ERROR_MESSAGE_ATTR_NAME, INCORRECT_LOGIN_OR_PASSWORD_MESSAGE);
            return "index";
        }

        if (service.isLoginAllowed(login, password)) {
            session.setAttribute(USERNAME_ATTR_NAME, login);

            int userId = service.getUserIdByLogin(login);
            session.setAttribute(USER_ID_ATTR_NAME, userId);
        }
        return "index";
    }

    public void setService(final UserService service) {
        this.service = service;
    }
}
