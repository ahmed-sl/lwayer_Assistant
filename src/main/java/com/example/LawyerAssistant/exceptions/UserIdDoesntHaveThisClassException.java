package com.example.LawyerAssistant.exceptions;

public class UserIdDoesntHaveThisClassException extends IllegalArgumentException{
    public UserIdDoesntHaveThisClassException(String s) {
        super(s);
    }
}
