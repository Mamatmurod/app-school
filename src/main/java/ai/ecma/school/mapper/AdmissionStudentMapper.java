package ai.ecma.school.mapper;

import ai.ecma.school.entity.AdmissionStudent;
import ai.ecma.school.payload.AdmissionStudentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdmissionStudentMapper {

AdmissionStudent fromAdmissionStudentDTO(AdmissionStudentDTO admissionStudent);

}


