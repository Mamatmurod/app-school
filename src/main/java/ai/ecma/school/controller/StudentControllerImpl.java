package ai.ecma.school.controller;

import ai.ecma.school.service.StudentService;
import ai.ecma.school.net.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController{

    private final StudentService studentService;

    @Override
    public ApiResult<?> getStudentById(UUID id) {
        return studentService.getStudentById(id);
    }

    @Override
    public ApiResult<?> getStudents() {
        return null;
    }

    @Override
    public ApiResult<?> addStudent() {
        return null;
    }

    @Override
    public ApiResult<?> editStudent() {
        return null;
    }

    @Override
    public ApiResult<?> deleteStudent(UUID id) {
        return null;
    }

}
