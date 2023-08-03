package ai.ecma.school.payload;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdmissionDTO {


    private String groupLevel;
    private Long starDate;
    private Long endDate;

}
