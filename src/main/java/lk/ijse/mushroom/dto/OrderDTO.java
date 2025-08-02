package lk.ijse.mushroom.dto;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderDTO {
    private int OrderId;
    private int CustomerId;
    private String PaymentStatus;
    private String OrderDate;
    private String TotalAmount;
}
