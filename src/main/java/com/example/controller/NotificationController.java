package com.example.controller;
import com.example.service.NotificationService;
import com.example.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class NotificationController
{
    @Autowired
    private NotificationService notificationService;
    @GetMapping("/users/{id}/notifications")
    //function to get a notification based on id
    public ResponseEntity<Optional<Notification>> getNotification(@PathVariable int id)
    {
        return notificationService.getNotification(id);
    }
    @PostMapping("/notifications")
    public ResponseEntity<String> addNotification(@RequestBody Notification notification)
    {
        return notificationService.addNotifcation(notification);
    }
}