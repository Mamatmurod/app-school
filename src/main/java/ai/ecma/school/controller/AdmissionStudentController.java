package ai.ecma.school.controller;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AddStudentDTO;
import ai.ecma.school.payload.StudentDTO;
import ai.ecma.school.utils.AppConstant;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping(AdmissionStudentController.ADMISSION_STUDENT_CONTROLLER)
public interface  AdmissionStudentController {

    String ADMISSION_STUDENT_CONTROLLER = AppConstant.BASE_PATH + "/admission";

    String ADD_STUDENT = "/add-student";
    String DELETE_STUDENT_ID = "/delete-student/{id}";
    String GET_STUDENT_ID = "/get-student/{id}";
    String EDIT_STUDENT = "/edit-student";

    @PostMapping(ADD_STUDENT)
    ApiResult<?> addStudent(
            @RequestParam UUID admissionId,
            @RequestBody AddStudentDTO studentDTO);

    @DeleteMapping(DELETE_STUDENT_ID)
    ApiResult<?> deleteStudentAdmission( @PathVariable UUID id);
    @GetMapping(GET_STUDENT_ID)
    ApiResult<?> getStudentAdmission(@PathVariable UUID id);
    @PutMapping(EDIT_STUDENT)
    ApiResult<?> editStudentAdmission(@RequestBody StudentDTO studentDTO);

}
