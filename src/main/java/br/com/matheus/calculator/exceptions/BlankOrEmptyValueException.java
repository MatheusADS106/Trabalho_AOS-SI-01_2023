package br.com.matheus.calculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BlankOrEmptyValueException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BlankOrEmptyValueException(String exception) {
        super(exception);
    }
}