package lk.ijse.mushroom.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PayTM {
    private int PaymentId;
    private int OrderId;
    private String PaymentMethod;
    private String paymentDate;
    private String Amount;
}
