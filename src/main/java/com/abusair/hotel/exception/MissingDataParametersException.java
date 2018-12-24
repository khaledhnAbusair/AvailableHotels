package com.abusair.hotel.exception;

public class MissingDataParametersException extends RuntimeException {
    public MissingDataParametersException() {
    }

    public MissingDataParametersException(String message) {
        super(message);
    }

    public MissingDataParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingDataParametersException(Throwable cause) {
        super(cause);
    }

    public MissingDataParametersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
