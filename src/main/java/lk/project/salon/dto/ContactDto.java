package lk.project.salon.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ContactDto {
    private int contactId;
    private String name;
    private String email;
    private String phone;
    private String subject;

}
