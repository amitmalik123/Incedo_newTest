package com.amk.cucumber.exceptions;

public class DefaultException extends RuntimeException {

    public DefaultException(String error_logging_to_system) {
        super(error_logging_to_system);
    }

}
