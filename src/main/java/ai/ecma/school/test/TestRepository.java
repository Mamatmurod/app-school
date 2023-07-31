package ai.ecma.school.test;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * This interface not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 6/30/2022
 */
public interface TestRepository extends JpaRepository<Test, UUID> {
}
