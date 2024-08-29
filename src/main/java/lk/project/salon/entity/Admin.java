package lk.project.salon.entity;

import jakarta.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
    @Column(nullable = false)
    private String adminName;
    @Column(nullable = false)
    private String password;

}
