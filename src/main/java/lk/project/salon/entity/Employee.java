package lk.project.salon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private int employeeID;
    @Column(nullable = false)
    private String employeeName;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private double employeeSalary;

}
