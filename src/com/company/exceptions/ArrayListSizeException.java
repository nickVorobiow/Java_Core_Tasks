package com.company.exceptions;

public class ArrayListSizeException extends Exception {
    public ArrayListSizeException() {
    }

    public ArrayListSizeException(String message) {
        super(message);
    }

    public ArrayListSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayListSizeException(Throwable cause) {
        super(cause);
    }

    public ArrayListSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
