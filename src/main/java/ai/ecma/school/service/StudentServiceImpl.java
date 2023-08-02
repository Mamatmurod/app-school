package ai.ecma.school.service;

import ai.ecma.school.entity.Student;
import ai.ecma.school.exception.RestException;
import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AddStudentDTO;
import ai.ecma.school.repository.StudentRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public ApiResult<?> getStudentById(UUID studentId) {

        Student student = studentRepository.findById(studentId).orElseThrow(() -> RestException.notFound("STUDENT"));

        return ApiResult.successResponse(student);
    }

    @Override
    public ApiResult<?> getStudents() {
        List<Student> studentList = studentRepository.findAll();

        return ApiResult.successResponse(studentList);
    }

    @Override
    public ApiResult<?> createStudent(AddStudentDTO addStudentDTO) {

        return null;

    }

    @Override
    public ApiResult<?> updateStudent() {
        return null;
    }

    @Override
    public ApiResult<?> deleteStudent() {
        return null;
    }

    @Override
    public ApiResult<?> deleteStudentById(UUID studentId) {
        return null;
    }
}
