package ai.ecma.school.service;

import ai.ecma.school.entity.Student;
import ai.ecma.school.exception.RestException;
import ai.ecma.school.mapper.StudentMapper;
import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AddStudentDTO;
import ai.ecma.school.payload.StudentDTO;
import ai.ecma.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

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

        Student student = studentMapper.fromAddStudentDTO(addStudentDTO);

        studentRepository.save(student);

        return ApiResult.successResponse(student);
    }

    @Override
    public ApiResult<?> updateStudent(StudentDTO studentDTO) {
        Student student = studentRepository.findById(studentDTO.getId()).orElseThrow(() -> RestException.notFound("STUDENT"));

        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setPatron(studentDTO.getParentPhoneNumber());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setGender(studentDTO.getGender());
        student.setBirthDate(studentDTO.getBirthDate());

        studentRepository.save(student);

        return ApiResult.successResponse(student);
    }

    @Override
    public ApiResult<?> deleteStudents() {
        studentRepository.deleteAll();
        return ApiResult.successResponse(true);
    }

    @Override
    public ApiResult<?> deleteStudentById(UUID studentId) {
        studentRepository.deleteById(studentId);
        return ApiResult.successResponse(true);
    }
}
