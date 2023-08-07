package ai.ecma.school.entity;

import ai.ecma.school.entity.template.AbsUUIDUserAuditEntity;
import ai.ecma.school.enums.GroupStatusEnum;
import ai.ecma.school.enums.GroupTypeEnum;
import ai.ecma.school.enums.WeekdayEnum;
import ai.ecma.school.utils.ColumnKey;
import ai.ecma.school.utils.TableNameConstant;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Time;
import java.util.Collection;

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

    @ManyToOne
    @JoinColumn(name = ColumnKey.LEVEL)
    private Level level;
    /**
     * AGAR GURUH QABUL UCHUN OCHILAYOTGAN BO'LSA O'CHA QABUL
     */
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnKey.ADMISSION_ID)
    private Admission admission;

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

    @ElementCollection(targetClass = WeekdayEnum.class)
    @CollectionTable(
            name = TableNameConstant.GROUP_WEEK_DAYS,
            joinColumns = {@JoinColumn(name = ColumnKey.GROUP_ID)},
            uniqueConstraints = @UniqueConstraint(columnNames = {ColumnKey.GROUP_ID, ColumnKey.WEEKDAYS})
    )
    @Enumerated(EnumType.STRING)
    @Column(name = ColumnKey.WEEKDAYS)
    private Collection<WeekdayEnum> weekdays;

    /*
       DARSLARNING BOSHLANISH SOATI (09:00)
     */
    @Column(name = ColumnKey.LESSON_START_TIME, nullable = false)
    private Time lessonStartTime;

    /*
     DARSLARNING TUGASH SOATI (13:00)
     */
    @Column(name = ColumnKey.LESSON_END_TIME, nullable = false)
    private Time lessonEndTime;

}
