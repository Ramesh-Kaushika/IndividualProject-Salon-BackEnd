package lk.project.salon.service;

import lk.project.salon.dto.NotificationDto;
import lk.project.salon.entity.Notification;

import java.util.List;

public interface NotificationService {
    Object saveNotification(NotificationDto notificationDto);

    List<Notification> getAllNotification();

    String deleteNotification(Integer id);
}
