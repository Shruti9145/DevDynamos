package com.onlineeventmanagement.exception;

//Handles exception if there's one while creating a quotation as per user request
public class CreateQuotationException extends Exception {
    public CreateQuotationException(String message) {
        super(message);
    }

}
