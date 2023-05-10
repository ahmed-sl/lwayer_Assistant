package com.example.LawyerAssistant.exceptions;

public class MyClassNotFoundException extends IllegalArgumentException{
    public MyClassNotFoundException(String s) {
        super(s);
    }
}
