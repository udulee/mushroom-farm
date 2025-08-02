package lk.ijse.mushroom.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerTM {
    public int id;
    public String name;
    public String email;
    public String phone;
    public String address;

    public CustomerTM(int deliverId, int orderId, int customerId, String orderAmount) {
    }
}
