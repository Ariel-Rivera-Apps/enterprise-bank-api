package com.enterprisebank.banking.domain.exception;

import org.springframework.http.HttpStatus;

public class BusinessRuleException extends BankingException {
    public BusinessRuleException(String message) {
        super(message, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
