package com.gla.exception;

// Custom exception class
public class InsufficientBalance extends Exception {

    // Constructor
    public InsufficientBalance(String message) {
        super(message); // passes message to Exception class
    }
}