package ai.ecma.school.payload;

import ai.ecma.school.enums.MonthEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceDTO {

    private UUID admissionId;

    private Double price;

    @NotEmpty
    private List<UUID> studentIdList;

    @NotEmpty
    private List<MonthEnum> monthEnums;
}
