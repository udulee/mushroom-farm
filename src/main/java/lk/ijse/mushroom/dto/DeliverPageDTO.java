package lk.ijse.mushroom.dto;

import lombok.*;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DeliverPageDTO {
    private int deliverId;
    private int orderId;
    private int customerId;
    private String OrderAmount;

}
