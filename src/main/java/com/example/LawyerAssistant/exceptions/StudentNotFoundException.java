package com.example.LawyerAssistant.exceptions;

public class StudentNotFoundException extends IllegalArgumentException{
    public StudentNotFoundException(String s) {
        super(s);
    }
}
