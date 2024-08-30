package lk.project.salon.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private int employeeId;
    private String employeeName;
    private String position;
    private String email;
    private String phoneNumber;
    private double employeeSalary;
}
