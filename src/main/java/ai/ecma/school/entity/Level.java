package ai.ecma.school.entity;

import ai.ecma.school.entity.template.AbsUUIDUserAuditEntity;
import ai.ecma.school.enums.GroupLevelEnum;
import ai.ecma.school.utils.ColumnKey;
import ai.ecma.school.utils.TableNameConstant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Setter
@Getter
@Where(clause = "deleted=false")
@Entity(name = TableNameConstant.LEVEL)
@Builder(setterPrefix = "set")
@SQLDelete(sql = ("update " + TableNameConstant.LEVEL + " set deleted=true where id=?"))
@NoArgsConstructor
@AllArgsConstructor
public class Level extends AbsUUIDUserAuditEntity {
    @Column(name = ColumnKey.LEVEL)
    @Enumerated(value = EnumType.STRING)
    private GroupLevelEnum levelEnum;

    @Column(name = ColumnKey.PRICE)
    private double mainPrice;

    @Column(name = ColumnKey.DISCOUNT_PRICE)
    private double discountPrice;

}
