package com.internet_pharmacy.validators;

import com.internet_pharmacy.exceptions.ExpectAuthenticateValidator;

public class ValidatLog {
    public static void validateLogin(String login) {
        if(login == null || login.length() <= 1) {
            throw new ExpectAuthenticateValidator("Incorrect login");
        }
    }

    public static void validatePass(String password) {
        if(password == null || password.length() <= 1) {
            throw new ExpectAuthenticateValidator("Incorrect passwords");
        }
    }
}