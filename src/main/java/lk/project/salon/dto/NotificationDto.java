package lk.project.salon.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {

    private int notificationId;
    private String message;
    private String date;
}
