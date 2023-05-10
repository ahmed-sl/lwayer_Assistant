package com.example.LawyerAssistant.exceptions;

public class NoteIdNotFoundException extends IllegalArgumentException{
    public NoteIdNotFoundException(String s) {
        super(s);
    }
}
