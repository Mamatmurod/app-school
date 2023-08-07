package ai.ecma.school.controller;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AddStudentDTO;
import ai.ecma.school.payload.AdmissionStudentDTO;
import ai.ecma.school.payload.StudentDTO;
import ai.ecma.school.utils.AppConstant;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@RequestMapping(AdmissionStudentController.ADMISSION_STUDENT_CONTROLLER)
public interface  AdmissionStudentController {

    String ADMISSION_STUDENT_CONTROLLER = AppConstant.BASE_PATH + "/admission";

    String ADD_STUDENT = "/add";

    String GET_STUDENT_BY_ID = "/delete-student/{id}";

    @GetMapping(ADD_STUDENT)
    ApiResult<?> addStudent(
            @RequestParam UUID admissionId,
            @RequestBody AddStudentDTO studentDTO);

    @GetMapping(GET_STUDENT_BY_ID)
    ApiResult<?> deleteStudentAdmission( @PathVariable UUID id);

}
