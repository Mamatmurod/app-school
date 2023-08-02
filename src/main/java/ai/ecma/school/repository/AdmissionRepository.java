package ai.ecma.school.repository;

import ai.ecma.school.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, UUID> {
    Boolean findByGroupLevelEnum(String groupLevelEnum);
}