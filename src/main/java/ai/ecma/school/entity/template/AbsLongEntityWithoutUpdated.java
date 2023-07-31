package ai.ecma.school.entity.template;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class AbsLongEntityWithoutUpdated extends AbsUserAuditWithoutUpdated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
