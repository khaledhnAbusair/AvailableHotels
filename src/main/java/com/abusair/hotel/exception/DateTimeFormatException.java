package com.abusair.hotel.exception;

public class DateTimeFormatException extends RuntimeException {
    public DateTimeFormatException() {
    }

    public DateTimeFormatException(String message) {
        super(message);
    }

    public DateTimeFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateTimeFormatException(Throwable cause) {
        super(cause);
    }

    public DateTimeFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
