package ai.ecma.school.payload;

import ai.ecma.school.entity.Admission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AdmissionStudentDTO {
    private Admission admission;
    private AddStudentDTO student;
}
