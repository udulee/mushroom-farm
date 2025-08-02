package lk.ijse.mushroom.dto;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class MushroomBatchDTO {
    private int batchID;
    private int farmId;
    private int customerId;
    private String mushroomType;
    private String quantity;
    private String quantityStatus;

}

