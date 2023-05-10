package com.example.LawyerAssistant.exceptions;

public class SessionIdNotFoundException extends IllegalArgumentException{
    public SessionIdNotFoundException(String s) {
        super(s);
    }
}
