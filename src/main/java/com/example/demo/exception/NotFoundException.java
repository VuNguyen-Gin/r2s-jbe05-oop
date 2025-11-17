package com.example.demo.exception;

public class NotFoundException extends RuntimeException {


    public NotFoundException(Integer id) {
        super("Not found with id: " + id);
    }


    public NotFoundException(String message) {
        super(message);
    }
}