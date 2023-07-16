package com.example.demo.exception;

public class UserAlreadyExistsException extends RuntimeException{

    /**
     * Exception for already existing user
     */
    public UserAlreadyExistsException(String message){
        super(message);
    }
}
