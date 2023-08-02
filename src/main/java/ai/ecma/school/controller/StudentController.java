package ai.ecma.school.controller;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.utils.AppConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping(StudentController.STUDENT_CONTROLLER_PATH)
public interface StudentController {

    String STUDENT_CONTROLLER_PATH = AppConstant.BASE_PATH + "/student";

    String STUDENT_GET_BY_ID = "/get";
    String STUDENT_LIST = "/list";
    String STUDENT_ADD = "/add";
    String STUDENT_EDIT = "/edit";
    String STUDENT_DELETE = "/delete";

    @GetMapping(STUDENT_GET_BY_ID)
    ApiResult<?> getStudentById(UUID id);

    @GetMapping(STUDENT_LIST)
    ApiResult<?> getStudents();

    @GetMapping(STUDENT_ADD)
    ApiResult<?> addStudent();

    @GetMapping(STUDENT_EDIT)
    ApiResult<?> editStudent();

    @GetMapping(STUDENT_DELETE)
    ApiResult<?> deleteStudent(UUID id);

}
