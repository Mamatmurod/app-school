package ai.ecma.school.entity;

import ai.ecma.school.entity.template.AbsUUIDUserAuditEntity;
import ai.ecma.school.enums.GroupLevelEnum;
import ai.ecma.school.enums.GroupStatusEnum;
import ai.ecma.school.enums.WeekdayEnum;
import ai.ecma.school.utils.ColumnKey;
import ai.ecma.school.utils.TableNameConstant;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.UUID;

/**
 * @author Muhammad Mo'minov 08.11.2021
 * @apiNote GURUHLAR
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
    /**
     * GURUHNING NOMI. SPECIALIZATION BILAN QUSHILIB TAKRORLANMAS BO'LADI!
     */
    @Column(name = ColumnKey.NAME)
    private String name;

    /**
     * AGAR GURUH QABUL UCHUN OCHILAYOTGAN BO'LSA O'CHA QABUL
     */
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnKey.ADMISSION_ID)
    private Admission admission;

    @Column(name = ColumnKey.PRICE)
    private Double price;

    /**
     * GURUH QAYSI FILIALGA TEGISHLI EKANLIGI
     */
    @Column(name = ColumnKey.BRANCH_ID, nullable = false)
    private Long branchId;

    /**
     * GURUHNING TURI
     */
    @Enumerated(EnumType.STRING)
    @Column(name = ColumnKey.TYPE)
    private GroupTypeEnum groupTypeEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = ColumnKey.LEVEL)
    private GroupLevelEnum groupLevelEnum;

    /**
     * GURUHNING HOLATI. (CREATED, STARTED, COMPLETE)
     */
    @Enumerated(EnumType.STRING)
    @Column(name = ColumnKey.STATUS, nullable = false)
    private GroupStatusEnum status;

    /**
     * GURUHNING QAYSI MUTAXASISLIKKA TEGISHLI EKANLIGI
     */
    @Column(name = ColumnKey.SPECIALIZATION_ID, nullable = false)
    private Long specializationId;

    /**
     * GURUHNING MENTORI (UserID) AUTHDAN OLAMIZ
     */
    @Column(name = ColumnKey.MENTOR_ID, nullable = true)
    private UUID mentorId;

    /**
     * GURUH HAFTANING QAYSI KUNLARIDA O'QISHI
     */
    @ElementCollection(targetClass = WeekdayEnum.class, fetch = FetchType.LAZY)
    @CollectionTable(
            name = TableNameConstant.GROUP_WEEK_DAYS,
            joinColumns = {@JoinColumn(name = ColumnKey.GROUP_ID)},
            uniqueConstraints = @UniqueConstraint(columnNames = {ColumnKey.GROUP_ID, ColumnKey.WEEKDAYS})
    )
    @Enumerated(EnumType.STRING)
    @Column(name = ColumnKey.WEEKDAYS)
    private Collection<WeekdayEnum> weekdays;

    /**
     * GURUHDA DASNING BOSHLANISH SOATI (09:00)
     */
    @Column(name = ColumnKey.LESSON_START_TIME, nullable = false)
    private Time lessonStartTime;

    /**
     * GURUHDA DASNING TUGASH SOATI (13:00)
     */
    @Column(name = ColumnKey.LESSON_END_TIME, nullable = false)
    private Time lessonEndTime;

    /**
     * GURUH A'ZOLAR O'QISHNI BITIRGANDAN KEYIN HAM DARS VIDEO'LARNI KO'RSINMI
     */
    @Column(name = ColumnKey.INFINITE_VIDEO_WATCHING)
    private boolean infiniteVideoWatching;

    /**
     * GURUHNING DARSLARI QAYSI XONADA BO'LISHI
     */
    @Column(name = ColumnKey.ROOM_ID)
    private Long roomId;

    /**
     * GURUH DARSLARINING TAHMINIY BOSHLANISH VAQTI (2022-11-22)
     */
    @Column(name = ColumnKey.ESTIMATED_START_TIME, nullable = false)
    private Date estimatedStartTime;

    /**
     * GURUHNING MAXIMUM TALABALAR SONI
     */
    @Column(name = ColumnKey.MAXIMUM_NUMBER_OF_STUDENTS)
    private Integer maximumNumberOfStudents;

    /*========================NOILOJ FIELDLAR========================*/

    /**
     * GURUH O'TADIGAN DARSLARNING SONI
     */
    @Column(name = ColumnKey.LESSON_COUNT)
    private Integer lessonCount;

    /**
     * GURUHNING DARSLARI NECHI OY DAVOM ETISHI
     */
    @Column(name = ColumnKey.LESSON_DURATION_IN_MONTH)
    private Integer lessonDurationInMonth;

    public Double getPrice() {
        return price;
    }
}
