package lk.project.salon.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class AppointmentDto {

    private int appointmentId;
    private String date;
    private String time;
    private String status;
    private String expert;
    private String name;
    private String gender;
    private String phone;

}
