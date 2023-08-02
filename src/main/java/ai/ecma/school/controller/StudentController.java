package ai.ecma.school.controller;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AddStudentDTO;
import ai.ecma.school.payload.StudentDTO;
import ai.ecma.school.utils.AppConstant;
import org.springframework.web.bind.annotation.*;

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
    ApiResult<?> getStudentById(@RequestParam UUID id);

    @GetMapping(STUDENT_LIST)
    ApiResult<?> getStudents();

    @PostMapping(STUDENT_ADD)
    ApiResult<?> addStudent(@RequestBody AddStudentDTO addStudentDTO);

    @PutMapping(STUDENT_EDIT)
    ApiResult<?> editStudent(@RequestBody StudentDTO studentDTO);

    @DeleteMapping(STUDENT_DELETE)
    ApiResult<?> deleteStudentById(@RequestParam UUID id);

    @DeleteMapping(STUDENT_DELETE)
    ApiResult<?> deleteStudents();
}
