package com.enterprisebank.banking.domain.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends BankingException {
    public AuthenticationException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
