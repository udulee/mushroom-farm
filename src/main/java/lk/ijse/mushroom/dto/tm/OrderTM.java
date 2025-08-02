package lk.ijse.mushroom.dto.tm;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderTM {
    private int OrderId;
    private int CustomerId;
    private String PaymentStatus;
    private String OrderDate;
    private String TotalAmount;
}
