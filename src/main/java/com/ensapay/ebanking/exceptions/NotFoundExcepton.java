package com.ensapay.ebanking.exceptions;

import java.util.function.Supplier;

public class NotFoundExcepton extends RuntimeException  {
    public NotFoundExcepton(String message)
    {
        super(message);
    }


}
