package lk.project.salon.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto {

    private int feedbackId;
    private int rating;
    private String comment;
    private String date;
}
