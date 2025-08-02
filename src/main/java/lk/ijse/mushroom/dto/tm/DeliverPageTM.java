package lk.ijse.mushroom.dto.tm;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliverPageTM {
    private int deliverId;
    private int orderId;
    private int customerId;
    private String OrderAmount;
}
