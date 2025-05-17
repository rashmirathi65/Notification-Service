package com.example.service;
import com.example.DAO.NotificationDAO;
import com.example.NotificationSender;
import com.example.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NotificationService
{
    @Autowired
    private NotificationDAO notificationDAO;
    @Autowired
    private NotificationSender notificationSender;

    //function to get notification based on id
    public ResponseEntity<Optional<Notification>> getNotification(int id)
    {
        if (notificationDAO.existsById(id))
        {
            Optional<Notification> notification = notificationDAO.findById(id);
            return new ResponseEntity<>(notification, HttpStatus.FOUND);
        }
        else
        {
            return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
        }
    }
    //function to add a new notification
    public ResponseEntity<String> addNotifcation(Notification notification)
    {
        notificationSender.send(notification);//retrying
        if(notificationSender.getValue()!=-1)
        {
            notificationDAO.save(notification);
            return new ResponseEntity<>("Notification Sent", HttpStatus.OK);
        }
        return new ResponseEntity<>("Notification Not Sent", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}