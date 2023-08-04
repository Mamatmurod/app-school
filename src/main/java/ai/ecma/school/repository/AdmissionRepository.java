package ai.ecma.school.repository;

import ai.ecma.school.entity.Admission;
import ai.ecma.school.enums.GroupLevelEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, UUID> {
    Boolean existsAdmissionByLevel_LevelEnum(GroupLevelEnum level_levelEnum);

    List<Admission> findAllByIsDeleted(boolean isDeleted);
}
