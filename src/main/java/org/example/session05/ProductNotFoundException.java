package org.example.session05;

public class ProductNotFoundException extends Exception {


    public ProductNotFoundException(String message) {
        super(message); // Gọi constructor của lớp Exception
    }
}