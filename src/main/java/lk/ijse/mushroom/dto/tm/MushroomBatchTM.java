package lk.ijse.mushroom.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MushroomBatchTM {
    private int batchID;
    private int farmId;
    private int customerId;
    private String mushroomType;
    private String quantity;
    private String quantityStatus;
}
