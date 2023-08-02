package ai.ecma.school.repository;

import ai.ecma.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

}
