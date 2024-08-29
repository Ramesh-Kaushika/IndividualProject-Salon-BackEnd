package lk.project.salon.entity;

import jakarta.persistence.*;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;
    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private String date;
}
