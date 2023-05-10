package com.example.LawyerAssistant.exceptions;

public class UserNameFoundException extends IllegalArgumentException{
    public UserNameFoundException(String s) {
        super(s);
    }
}
