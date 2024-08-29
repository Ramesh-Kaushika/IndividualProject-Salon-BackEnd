package lk.project.salon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    private int adminId;
    @Column(nullable = false)
    private String adminName;
    @Column(nullable = false)
    private String password;

}
