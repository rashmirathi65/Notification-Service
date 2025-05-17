package com.example;

public class NotificationSendException extends RuntimeException
{
    //parameterized constructor
    public NotificationSendException(String message)
    {
        super(message);
    }
}