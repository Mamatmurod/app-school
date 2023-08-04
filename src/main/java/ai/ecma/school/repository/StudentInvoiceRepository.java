package ai.ecma.school.repository;

import ai.ecma.school.entity.StudentInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface StudentInvoiceRepository extends JpaRepository<StudentInvoice, UUID> {

    @Query(value = "SELECT * FROM student_invoice WHERE student_id IN (:studentIdList)", nativeQuery = true)
    List<StudentInvoice> findByIdList(Collection<UUID> studentIdList);
}
