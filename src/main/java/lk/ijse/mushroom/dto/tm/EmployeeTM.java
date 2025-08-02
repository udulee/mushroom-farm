package lk.ijse.mushroom.dto.tm;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTM {
    private int Employee_id;
    private String First_name;
    private String Last_name;
    private Double salary;
    private String Contact;
    private String Email;

}
