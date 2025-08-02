package lk.ijse.mushroom.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
    private int product_id;
    private String product_name;
    private String quantity;
}
