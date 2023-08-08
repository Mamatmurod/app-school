package ai.ecma.school.service;

import ai.ecma.school.entity.Admission;
import ai.ecma.school.entity.AdmissionStudent;
import ai.ecma.school.exception.RestException;
import ai.ecma.school.mapper.AdmissionStudentMapper;
import ai.ecma.school.mapper.StudentMapper;
import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AddStudentDTO;
import ai.ecma.school.payload.AdmissionStudentDTO;
import ai.ecma.school.payload.StudentDTO;
import ai.ecma.school.repository.AdmissionRepository;
import ai.ecma.school.repository.AdmissionStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdmissionStudentServiceImpl implements AdmissionStudentService
{
    private final AdmissionRepository admissionRepository;
    private final AdmissionStudentMapper admissionStudentMapper;
    private final AdmissionStudentRepository admissionStudentRepository;
    private final StudentService studentService;
    private final StudentMapper studentMapper;


    private Admission getAdmission(UUID admissionId) {
      return   admissionRepository.findById(admissionId).orElseThrow(() -> RestException.notFound("Admission not founded!"));
    }

    @Override
    public ApiResult<?> creatAdmissionStudent(UUID admissionId, AddStudentDTO studentDTO) {
        if (admissionStudentRepository.existsAdmissionStudentByStudent_PhoneNumber(studentDTO.getPhoneNumber())) {
            return ApiResult.errorResponse("Student already exists!",409);
        }
        studentService.createStudent(studentDTO);
        AdmissionStudentDTO admissionStudentDTO = new AdmissionStudentDTO(getAdmission(admissionId),studentMapper.fromAddStudentDTO(studentDTO));
        AdmissionStudent admissionStudent = getAdmissionStudent(admissionStudentDTO);
        admissionStudentRepository.save(admissionStudent);
        return ApiResult.successResponse("Student added successfully!");
    }

    @Override
    public ApiResult<?> deleteAdmissionStudent(UUID id) {
        if (admissionStudentRepository.deleteAdmissionByStudentId(id)) {
            return ApiResult.successResponse("Student deleted successfully!");
        }
        return ApiResult.errorResponse("Student not deleted!",409);
    }

    @Override
    public ApiResult<?> getStudentAdmission(UUID id) {
        return studentService.getStudentById(id);
    }

    @Override
    public ApiResult<?> editStudentAdmission(StudentDTO studentDTO) {
        return studentService.updateStudent(studentDTO);
    }

    private AdmissionStudent getAdmissionStudent(AdmissionStudentDTO admissionStudentDTO) {
        return  admissionStudentMapper.fromAdmissionStudentDTO(admissionStudentDTO);
    }


}
