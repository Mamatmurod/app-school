package ai.ecma.school.payload;

import ai.ecma.education.enums.ImportTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdmissionStudentDTO {
    private UUID id;
    private UUID userId;
    @NotBlank
    private String firstName;
    private String lastName;
    private String patron;
    private String fullName;
    @NotBlank
    private String phoneNumber;
    private String photoId;

    private Long amocrmId;
    private Long leadId;


    @NotNull(message = "REQUIRED_TYPE")
    private ImportTypeEnum type;
}
