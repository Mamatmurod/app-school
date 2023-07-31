package ai.ecma.school.entity.template;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@ToString
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class AbsUUIDUserAuditEntityWithoutUpdated extends AbsUserAuditWithoutUpdated {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;
}
