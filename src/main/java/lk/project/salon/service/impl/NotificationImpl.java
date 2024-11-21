package lk.project.salon.service.impl;

import lk.project.salon.dto.NotificationDto;
import lk.project.salon.entity.Notification;
import lk.project.salon.repo.NotificationRepo;
import lk.project.salon.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationImpl implements NotificationService {

    @Autowired
    NotificationRepo notificationRepo;

    @Override
    public Object saveNotification(NotificationDto notificationDto) {
        Notification notification = new Notification(
                notificationDto.getNotificationId(),
                notificationDto.getMessage(),
                notificationDto.getDate()
        );
    return notificationRepo.save(notification);
    }

    @Override
    public List<Notification> getAllNotification() {
        return notificationRepo.findAll();
    }

    @Override
    public String deleteNotification(Integer id) {
       if (notificationRepo.existsById(id)){
           notificationRepo.deleteById(id);
           return "Notification Deleted";
       }
       return "Notification not found";
    }
}
