package ai.ecma.school.payload;

import ai.ecma.school.enums.GenderEnum;
import ai.ecma.school.enums.GroupLevelEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private String patron;
    private String phoneNumber;
    private String parentPhoneNumber;
    private GenderEnum gender;
    private Date birthDate;
    private GroupLevelEnum level;
}
