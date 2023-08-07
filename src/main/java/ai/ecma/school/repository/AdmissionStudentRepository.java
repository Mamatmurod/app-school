package ai.ecma.school.repository;

import ai.ecma.school.entity.AdmissionStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdmissionStudentRepository extends JpaRepository<AdmissionStudent, UUID> {
    Boolean deleteAdmissionByStudentId(UUID studentId);
    Boolean existsAdmissionStudentByStudent_PhoneNumber(String phoneNumber);
}
