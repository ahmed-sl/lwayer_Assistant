package com.example.LawyerAssistant.exceptions;

public class YoureNotOwnerOfThisNoteException extends IllegalArgumentException{
    public YoureNotOwnerOfThisNoteException(String s) {
        super(s);
    }
}
