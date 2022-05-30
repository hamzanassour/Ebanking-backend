package com.ensapay.ebanking.exceptions;

public class AlreadyexistException extends RuntimeException{

    public AlreadyexistException(String message, String cin, String all_ready_exist)
    {
        super(message);
    }

    public AlreadyexistException(String this_agent_with_the_id_, Long id, String all_ready_exist) {
    }
}
