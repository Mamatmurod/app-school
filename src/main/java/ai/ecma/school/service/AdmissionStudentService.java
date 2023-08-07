package ai.ecma.school.service;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AddStudentDTO;
import ai.ecma.school.payload.StudentDTO;

import java.util.UUID;

public interface AdmissionStudentService {

    ApiResult<?> creatAdmissionStudent(UUID admissionId, AddStudentDTO studentDTO);

    ApiResult<?> deleteAdmissionStudent(UUID id);

    ApiResult<?> getStudentAdmission(UUID id);

    ApiResult<?> editStudentAdmission(StudentDTO studentDTO);
}
