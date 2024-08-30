package lk.project.salon.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PromotionDto {

    private int promotionId;
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private float discount;
}
