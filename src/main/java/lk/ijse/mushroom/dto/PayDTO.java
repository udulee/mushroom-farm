package lk.ijse.mushroom.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PayDTO {
    private int PaymentId;
    private int OrderId;
    private String PaymentMethod;
    private String paymentDate;
    private String Amount;

}
