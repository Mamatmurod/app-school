package ai.ecma.school.controller;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AddStudentDTO;
import ai.ecma.school.payload.StudentDTO;
import ai.ecma.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController {

    private final StudentService studentService;

    @Override
    public ApiResult<?> getStudentById(UUID id) {
        return studentService.getStudentById(id);
    }

    @Override
    public ApiResult<?> getStudents() {
        return studentService.getStudents();
    }

    @Override
    public ApiResult<?> addStudent(AddStudentDTO addStudentDTO) {
        return studentService.createStudent(addStudentDTO);
    }

    @Override
    public ApiResult<?> editStudent(StudentDTO studentDTO) {
        return studentService.updateStudent(studentDTO);
    }

    @Override
    public ApiResult<?> deleteStudent(UUID id) {
        return studentService.deleteStudentById(id);
    }

    @Override
    public ApiResult<?> deleteStudents() {
        return studentService.deleteStudents();
    }
}
