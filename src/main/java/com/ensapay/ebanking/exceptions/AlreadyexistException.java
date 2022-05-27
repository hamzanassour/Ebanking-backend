package com.ensapay.ebanking.exceptions;

public class AlreadyexistException extends RuntimeException{

    public AlreadyexistException(String message)
    {
        super(message);
    }
}
