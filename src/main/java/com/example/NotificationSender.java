package com.example;
import com.example.entity.Notification;
import org.springframework.retry.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class NotificationSender
{
    public int value;

    @Retryable(value=NotificationSendException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    //function to send notification to the users
    public void send(Notification notification) throws NotificationSendException
    {
        try
        {
            String type=notification.getType();
            String message=notification.getMessage();
            String time=notification.getTime();
            if(message.length()>70)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            throw new NotificationSendException("Simulated send failure for type: " +notification.getType());
        }
        System.out.println("Notification sent: " +notification.getMessage());
    }
    //recover function to run only after all the retry attempts is completed
    @Recover
    public void recover(NotificationSendException e, Notification notification)
    {
        this.value=-1;
        System.err.println("Failed to send notification after retries: " + e.getMessage());
    }
    //function to get the value of the instance variable
    public int getValue()
    {
        return value;
    }
}