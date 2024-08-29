package lk.project.salon.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AdminDto {

    private int adminId;
    private String adminName;
    private String password;
}
