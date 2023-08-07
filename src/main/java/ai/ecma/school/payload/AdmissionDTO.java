package ai.ecma.school.payload;

import ai.ecma.school.enums.GroupLevelEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AdmissionDTO {

    private UUID id;
    private Double totalPrice;
    private Double discountPrice;
    private Byte discountPricePercentage;
    private GroupLevelEnum groupLevel;
    private Long starDate;
    private Long endDate;

}
