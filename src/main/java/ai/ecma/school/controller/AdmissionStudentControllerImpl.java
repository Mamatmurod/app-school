package ai.ecma.school.controller;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AddStudentDTO;
import ai.ecma.school.service.AdmissionStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;



@RestController
@RequiredArgsConstructor
public class AdmissionStudentControllerImpl implements AdmissionStudentController{
    private final AdmissionStudentService admissionStudentService;

    @Override
    public ApiResult<?> addStudent(UUID admissionId, AddStudentDTO studentDTO) {
        return admissionStudentService.creatAdmissionStudent(admissionId,studentDTO);
    }

    @Override
    public ApiResult<?> deleteStudentAdmission(UUID id) {
        return admissionStudentService.deleteAdmissionStudent(id);
    }
}
