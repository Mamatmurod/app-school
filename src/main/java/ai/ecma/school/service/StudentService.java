package ai.ecma.school.service;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AddStudentDTO;
import ai.ecma.school.payload.StudentDTO;

import java.util.UUID;

public interface StudentService {

    ApiResult<?> getStudentById(UUID studentId);

    ApiResult<?> getStudents();

    ApiResult<?> createStudent(AddStudentDTO addStudentDTO);

    ApiResult<?> updateStudent(StudentDTO studentDTO);

    ApiResult<?> deleteStudents();

    ApiResult<?> deleteStudentById(UUID studentId);

}
