package lk.project.salon.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false)
    private String gender;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(unique = true,nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String role;
    @Column(unique = true,nullable = false)
    private String password;



}
