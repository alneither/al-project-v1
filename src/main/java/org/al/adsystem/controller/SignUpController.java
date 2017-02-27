package org.al.adsystem.controller;

import org.al.adsystem.model.domain.bean.User;
import org.al.adsystem.service.iface.UserService;
import org.al.adsystem.util.UserDataValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/add-user")
    public String signUpNewUser(final HttpServletRequest request) {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String passwordRepeat = request.getParameter(PASSWORD_REPEAT);

        if (UserDataValidator.validateUserData(login, password, passwordRepeat)) {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            service.signUpUser(user);
            return "index";
        } else {
            request.setAttribute(ERROR_MESSAGE_NAME, INCORRECT_REGISTRATION_DATA_MESSAGE);
            return "registration";
        }
    }

    public void setService(final UserService service) {
        this.service = service;
    }

}
