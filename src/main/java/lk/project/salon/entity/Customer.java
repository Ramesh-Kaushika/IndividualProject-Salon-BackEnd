package lk.project.salon.entity;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private String password;
}
