package ai.ecma.school.repository;

import ai.ecma.school.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {
    boolean existsByGroupTypeAndLevel_Id(String groupType, UUID levelId);
    boolean existsByGroupTypeAndLevel_IdAndIdNot(String groupType, UUID levelId, UUID groupId);
}
