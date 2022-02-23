package com.internet_pharmacy.validators;

import com.internet_pharmacy.exceptions.ExceptRegisterValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatReg {
    public static void validateName(String name) {
        validateBasics(name);
    }

    public static void validateSurname(String surname) {
        validateBasics(surname);
    }

    private static void validateBasics(String value) {
        if(value == null) {
            throw new ExceptRegisterValidator();
        }

        Pattern pattern = Pattern.compile("[A-Z][a-z]+");
        Matcher matcher = pattern.matcher(value);

        if(!matcher.matches()) {
            throw new ExceptRegisterValidator();
        }
    }
}
