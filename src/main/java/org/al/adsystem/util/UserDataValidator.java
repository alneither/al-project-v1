package org.al.adsystem.util;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UserDataValidator {

    private static final String LOGIN_PATTERN = "[a-zA-Z0-9]{2,20}";
    private static final String PASSWORD_PATTERN = "[a-zA-Z0-9\\D]{3,20}";
    private static final String HEADER_PATTERN = "[a-zA-Z\\w\\W]{2,100}";
    private static final String BODY_PATTERN = "[a-zA-Z\\w\\W]{0,255}";
    private static final String CONTACT_PATTERN = "[a-zA-Z\\w\\W]{0,100}";

    public static boolean validateUserData(final String login, final String password, final String passwordRepeat) {
        if (!password.equals(passwordRepeat)) {
            return false;
        }
        return validateSignInData(login, password);
    }

    public static boolean validateSignInData(final String login, final String password) {
        boolean result = (login.matches(LOGIN_PATTERN)) && (password.matches(PASSWORD_PATTERN));
        return result;
    }

    public static boolean validateAdData(final String header, final String body, final String contact) {
        boolean result = (header.matches(HEADER_PATTERN)) && (body.matches(BODY_PATTERN)
                && (contact.matches(CONTACT_PATTERN)));
        return result;
    }
}
