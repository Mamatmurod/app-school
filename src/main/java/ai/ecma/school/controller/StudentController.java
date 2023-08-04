package ai.ecma.school.controller;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AddStudentDTO;
import ai.ecma.school.payload.StudentDTO;
import ai.ecma.school.utils.AppConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@RequestMapping(StudentController.STUDENT_CONTROLLER_PATH)
public interface StudentController {

    String STUDENT_CONTROLLER_PATH = AppConstant.BASE_PATH + "/student";

    String STUDENT_GET_BY_ID = "/get";
    String STUDENT_LIST = "/list";
    String STUDENT_ADD = "/add";
    String STUDENT_EDIT = "/edit";
    String STUDENT_DELETE = "/delete";
    String STUDENT_DELETE_All = "/delete/all";

    @GetMapping(STUDENT_GET_BY_ID)
    ApiResult<?> getStudentById(UUID id);

    @GetMapping(STUDENT_LIST)
    ApiResult<?> getStudents();

    @GetMapping(STUDENT_ADD)
    ApiResult<?> addStudent(@RequestBody AddStudentDTO addStudentDTO);

    @GetMapping(STUDENT_EDIT)
    ApiResult<?> editStudent(@RequestBody StudentDTO studentDTO);

    @GetMapping(STUDENT_DELETE)
    ApiResult<?> deleteStudent(@RequestParam UUID id);

    @GetMapping(STUDENT_DELETE_All)
    ApiResult<?> deleteStudents();

}
