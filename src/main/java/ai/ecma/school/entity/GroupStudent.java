package ai.ecma.school.entity;

import ai.ecma.school.entity.template.AbsUUIDUserAuditEntity;
import ai.ecma.school.utils.ColumnKey;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import static ai.ecma.school.utils.TableNameConstant.GROUP_STUDENT;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SQLDelete(sql = ("update " + GROUP_STUDENT + " set deleted=true where id=?"))
@Where(clause = "deleted=false")
@Entity(name = GROUP_STUDENT)
@FieldNameConstants
public class GroupStudent extends AbsUUIDUserAuditEntity {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnKey.GROUP_ID)
    private Group group;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnKey.STUDENT_ID)
    private Student student;

    @Column(name = ColumnKey.DISCOUNT_PRICE_PERCENTAGE)
    private Integer discountPricePercentage = 0;

    @Column(name = ColumnKey.DISCOUNT_PRICE)
    private Double discountPrice = 0D;
}
