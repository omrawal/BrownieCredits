package com.example.demo.exception;

public class InvalidUserException extends RuntimeException{

    /**
     * Exception for invalid user
     */
    public InvalidUserException(String message){
        super(message);
    }
}
