package com.example.LawyerAssistant.exceptions;

public class CommentIdNotFoundException extends IllegalArgumentException{
    public CommentIdNotFoundException(String s) {
        super(s);
    }
}
