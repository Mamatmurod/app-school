package ai.ecma.school.payload.thirdParty;

import ai.ecma.school.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MQStudentDTO implements Serializable {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String patron;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private String nationality;
    private GenderEnum gender;
    private String address;
    private String photoId;
    private String passportNumber;
}
