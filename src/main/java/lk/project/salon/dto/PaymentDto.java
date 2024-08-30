package lk.project.salon.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private int paymentId;
    private double amount;
    private String date;

}
