package com.example.LawyerAssistant.exceptions;

public class YoureNotOwnerOfThisUserException extends IllegalArgumentException{
    public YoureNotOwnerOfThisUserException(String s) {
        super(s);
    }
}
