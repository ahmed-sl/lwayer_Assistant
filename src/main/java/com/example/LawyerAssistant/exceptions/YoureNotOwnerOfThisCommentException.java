package com.example.LawyerAssistant.exceptions;

public class YoureNotOwnerOfThisCommentException extends IllegalArgumentException{
    public YoureNotOwnerOfThisCommentException(String s) {
        super(s);
    }
}
