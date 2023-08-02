package ai.ecma.school.mapper;

import ai.ecma.school.entity.Student;
import ai.ecma.school.payload.AddStudentDTO;
import ai.ecma.school.payload.StudentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student fromAddStudentDTO(AddStudentDTO addStudentDTO);

}
