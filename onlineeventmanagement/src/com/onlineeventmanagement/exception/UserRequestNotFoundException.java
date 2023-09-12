package com.onlineeventmanagement.exception;

//Throws exception if the user request or plan request is not found
public class UserRequestNotFoundException extends Exception {
    public UserRequestNotFoundException(String message) {
        super(message);
    }


}
