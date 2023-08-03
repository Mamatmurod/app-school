package ai.ecma.school.payload;

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
    private String groupLevel;
    private Long starDate;
    private Long endDate;

}
