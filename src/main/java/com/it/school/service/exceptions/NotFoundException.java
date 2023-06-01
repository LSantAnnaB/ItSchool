package com.it.school.service.exceptions;

public class NotFoundException extends RuntimeException implements Runnable {

    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException() {

    }

    @Override
    public void run() {

    }
}
