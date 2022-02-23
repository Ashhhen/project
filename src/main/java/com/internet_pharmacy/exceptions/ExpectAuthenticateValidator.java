package com.internet_pharmacy.exceptions;

public class ExpectAuthenticateValidator extends RuntimeException {
    private String info;

    public ExpectAuthenticateValidator(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
