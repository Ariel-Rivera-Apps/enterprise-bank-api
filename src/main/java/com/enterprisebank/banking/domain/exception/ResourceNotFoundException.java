package com.enterprisebank.banking.domain.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BankingException {
    public ResourceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
