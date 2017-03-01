package org.al.adsystem.controller;

import org.al.adsystem.model.domain.bean.User;
import org.al.adsystem.service.iface.UserService;
import org.al.adsystem.util.UserDataValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import static org.al.adsystem.util.Constant.*;

@Controller
public class SignUpController {

    private static final String PASSWORD_REPEAT = "password-repeat";

    private UserService service;

    @RequestMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String signUpNewUser(final HttpServletRequest request) {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String passwordRepeat = request.getParameter(PASSWORD_REPEAT);

        if (UserDataValidator.validateUserData(login, password, passwordRepeat)) {
            User user = new User(login, password);
            service.signUpUser(user);
            return "index";
        } else {
            request.setAttribute(ERROR_MESSAGE_NAME, INCORRECT_DATA_ENTERED_MESSAGE);
            return "registration";
        }
    }

    public void setService(final UserService service) {
        this.service = service;
    }

}
