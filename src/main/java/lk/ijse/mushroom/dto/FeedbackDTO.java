package lk.ijse.mushroom.dto;

import lombok.*;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class FeedbackDTO {
    private int feedbackId;
    private int customerId;
    private String rating;
    private String comment;

}
