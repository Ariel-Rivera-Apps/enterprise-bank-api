package com.enterprisebank.banking.domain.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends BankingException {
    public ConflictException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
