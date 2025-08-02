package lk.ijse.mushroom.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EmployeeDTO {
    private int Employee_id;
    private String First_name;
    private String Last_name;
    private double salary;
    private String Contact;
    private String Email;

}