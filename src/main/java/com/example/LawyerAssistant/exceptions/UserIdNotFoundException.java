package com.example.LawyerAssistant.exceptions;

public class UserIdNotFoundException extends IllegalArgumentException{
    public UserIdNotFoundException(String s) {
        super(s);
    }
}
