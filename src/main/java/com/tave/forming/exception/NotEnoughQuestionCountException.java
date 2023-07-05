package com.tave.forming.exception;

public class NotEnoughQuestionCountException extends RuntimeException{
    public NotEnoughQuestionCountException() {
        super();
    }

    public NotEnoughQuestionCountException(String message) {
        super(message);
    }

    public NotEnoughQuestionCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughQuestionCountException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughQuestionCountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

