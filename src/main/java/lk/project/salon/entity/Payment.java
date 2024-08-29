package lk.project.salon.entity;

import jakarta.persistence.*;


@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private String date;


}
