package ai.ecma.school.controller;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.utils.AppConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(AdmissionStudentController.ADMISSION_STUDENT_CONTROLLER)
public interface  AdmissionStudentController {

    String ADMISSION_STUDENT_CONTROLLER = AppConstant.BASE_PATH + "admission";

    String ADD_STUDENT = "/add";

    String GET_STUDENT_BY_ID = "/get/{id}";

    @GetMapping(ADD_STUDENT)
    ApiResult<?> addStudent();


}
