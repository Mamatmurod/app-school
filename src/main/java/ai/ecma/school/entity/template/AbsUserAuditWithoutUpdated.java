package ai.ecma.school.entity.template;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

/**
 * OBJECTNI OCHGAN YOKI UNI
 * O'ZGARTIRGAN USERNI OLIB BERISH UCHUN XIZMAT QILADI
 */
@Getter
@Setter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)//2-ishimiz
@EqualsAndHashCode(callSuper = true)
public abstract class AbsUserAuditWithoutUpdated extends AbsDateAuditWithoutUpdateAt {

    @CreatedBy
    @Column(name = "created_by_id", updatable = false)
    private UUID createdById;
    //OBJECTNI KIM OCHGANI.
    // AGAR U SECURITYCONTEXTDA BO'LSA YOZILADI AKS HOLDA NULL
}
