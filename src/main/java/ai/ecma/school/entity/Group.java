package ai.ecma.school.entity;

import ai.ecma.school.entity.template.AbsUUIDUserAuditEntity;
import ai.ecma.school.enums.GroupLevelEnum;
import ai.ecma.school.enums.GroupStatusEnum;
import ai.ecma.school.enums.GroupTypeEnum;
import ai.ecma.school.utils.ColumnKey;
import ai.ecma.school.utils.TableNameConstant;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * @author Komronbek Bozorov 02.08.2023
 * @apiNote SINF
 */
@Setter
@Getter
@Where(clause = "deleted=false")
@Entity(name = TableNameConstant.GROUP)
@Builder(setterPrefix = "set")
@SQLDelete(sql = ("update " + TableNameConstant.GROUP + " set deleted=true where id=?"))
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class Group extends AbsUUIDUserAuditEntity {


    @Column(name = ColumnKey.GROUP_TYPE)
    @Enumerated(EnumType.STRING)
    private GroupTypeEnum groupType;


    @Enumerated(EnumType.STRING)
    @Column(name = ColumnKey.GROUP_LEVEL)
    private GroupLevelEnum groupLevelEnum;
    /**
     * AGAR GURUH QABUL UCHUN OCHILAYOTGAN BO'LSA O'CHA QABUL
     */
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnKey.ADMISSION_ID)
    private Admission admission;

    @Column(name = ColumnKey.PRICE)
    private Double price;

    @Column(name = ColumnKey.DISCOUNT_PRICE_PERCENTAGE)
    private Integer discountPricePercentage;
    /**
     * GURUH QAYSI FILIALGA TEGISHLI EKANLIGI
     */
    @Column(name = ColumnKey.BRANCH_ID, nullable = false)
    private Long branchId;

    /**
     * GURUHNING HOLATI. (CREATED, STARTED, COMPLETE)
     */
    @Enumerated(EnumType.STRING)
    @Column(name = ColumnKey.STATUS, nullable = false)
    private GroupStatusEnum status;


    /**
     * GURUHNING MAXIMUM TALABALAR SONI
     */
    @Column(name = ColumnKey.MAXIMUM_NUMBER_OF_STUDENTS)
    private Integer maximumNumberOfStudents;

}
