package ai.ecma.school.service;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AddStudentDTO;

import java.util.UUID;

public interface StudentService {

    ApiResult<?> getStudentById(UUID studentId);

    ApiResult<?> getStudents();

    ApiResult<?> createStudent(AddStudentDTO addStudentDTO);

    ApiResult<?> updateStudent();

    ApiResult<?> deleteStudent();

    ApiResult<?> deleteStudentById(UUID studentId);

}
