package ai.ecma.school.service;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AddStudentDTO;

import java.util.UUID;

public interface AdmissionStudentService {

    ApiResult<?> creatAdmissionStudent(UUID admissionId, AddStudentDTO studentDTO);

    ApiResult<?> deleteAdmissionStudent(UUID id);
}
