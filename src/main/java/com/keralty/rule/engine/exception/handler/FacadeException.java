package com.keralty.rule.engine.exception.handler;

public class FacadeException extends Exception {

    private static final long serialVersionUID = 1L;

    public FacadeException(String msg, Exception cause) {
        super(msg, cause);
    }
}
