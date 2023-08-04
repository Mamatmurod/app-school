package ai.ecma.school.repository;

import ai.ecma.school.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    @Query(value = "SELECT * FROM student WHERE id IN (:studentIdList)", nativeQuery = true)
    List<Student> findByIdList(Collection<UUID> studentIdList);

}
