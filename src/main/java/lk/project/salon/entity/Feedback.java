package lk.project.salon.entity;

import jakarta.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;
    @Column(nullable = false)
    int rating;
    @Column(nullable = false)
    private String comment;
    @Column(nullable = false)
    private String date;

}
