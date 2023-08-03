package ai.ecma.school.repository;

import ai.ecma.school.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, UUID> {
    Boolean findByLevel_LevelEnum(String groupLevelEnum);

    List<Admission> findAllByIsDeleted(boolean isDeleted);
}
