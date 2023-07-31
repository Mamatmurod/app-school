package ai.ecma.school.entity.template;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * OBJECTLAR DB GA QO'SHILGANDA YOKI O'ZGARTIRILGANDA
 * AVTOMAT RAVISHDA O'SHA VAQTNI OLISHI UCHUN
 */
@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class AbsDateAuditWithoutUpdateAt implements Serializable {
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Timestamp createdAt;//OBJECT YANGI OCHIGANDA ISHLATILADI

    private Boolean deleted = false;

}
