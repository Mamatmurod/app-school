package ai.ecma.school.repository;

import ai.ecma.school.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {
    Optional<Group> findByGroupTypeAndGroupLevel(String groupType, String groupLevel);
    boolean existByGroupTypeAndGroupLevel(String groupType, String groupLevel);
}
