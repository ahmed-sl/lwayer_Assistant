package com.example.LawyerAssistant.exceptions;

public class ClassAlreadyRegisteredException extends IllegalArgumentException{
    public ClassAlreadyRegisteredException(String s) {
        super(s);
    }
}
