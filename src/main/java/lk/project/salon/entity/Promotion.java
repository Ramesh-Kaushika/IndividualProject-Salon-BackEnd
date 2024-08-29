package lk.project.salon.entity;

import jakarta.persistence.*;

@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promotionId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String startDate;
    @Column(nullable = false)
    private String endDate;
    @Column(nullable = false)
    private float discount;
}
