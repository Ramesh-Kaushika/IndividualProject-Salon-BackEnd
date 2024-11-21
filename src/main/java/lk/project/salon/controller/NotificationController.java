package lk.project.salon.controller;


import lk.project.salon.dto.NotificationDto;
import lk.project.salon.entity.Notification;
import lk.project.salon.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Object> saveNotifications(@RequestBody NotificationDto notificationDto){
        Object newNotification = notificationService.saveNotification(notificationDto);
        return new ResponseEntity<>(newNotification, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllNotification(){
        List<Notification> allNotification = notificationService.getAllNotification();
        return new ResponseEntity<>(allNotification, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Integer id){
        String deletedNotification = notificationService.deleteNotification(id);
        return new ResponseEntity<>(deletedNotification, HttpStatus.CREATED);
    }

}
