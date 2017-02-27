package org.al.adsystem.util;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UserDataValidator {

    private static final String LOGIN_PATTERN = "[a-zA-Z0-9]{2,20}";
    private static final String PASSWORD_PATTERN = "[a-zA-Z0-9\\D]{3,20}";

    public static boolean validateUserData(final String login, final String password, final String passwordRepeat) {

        if (login.equals(EMPTY) || password.equals(EMPTY) || passwordRepeat.equals(EMPTY)) {
            return false;
        }

        if (!password.equals(passwordRepeat)) {
            return false;
        }

        return validateLoginData(login, password);
    }

    public static boolean validateLoginData(final String login, final String password) {
        if (login.equals(EMPTY) || password.equals(EMPTY)) {
            return false;
        }

        boolean result = (login.matches(LOGIN_PATTERN)) && (password.matches(PASSWORD_PATTERN));
        return result;
    }
}
