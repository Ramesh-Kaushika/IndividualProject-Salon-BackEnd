package lk.project.salon.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Integer customerId;
    private String customerName;
    private String gender;
    private String email;
    private String phoneNumber;
    private String role;
    private String password;
}
