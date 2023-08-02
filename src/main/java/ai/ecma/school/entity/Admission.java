package ai.ecma.school.entity;

import ai.ecma.school.entity.template.AbsUUIDUserAuditEntity;
import ai.ecma.school.enums.WeekdayEnum;
import ai.ecma.school.utils.ColumnKey;
import ai.ecma.school.utils.TableNameConstant;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

/**
 * @author Muhammad Mo'minov 08.11.2021
 * @apiNote GURUH UCUN QABUL
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "set")
@SQLDelete(sql = ("update " + TableNameConstant.ADMISSION + " set deleted=true where id=?"))
@Where(clause = "deleted=false")
@Entity(name = TableNameConstant.ADMISSION)
public class Admission extends AbsUUIDUserAuditEntity {
    /**
     * GROUP TYPE VA SPECIALIZATION ORQALI GENERATE QILINGAN NOM. BUNI CLIENT KIRITMAYDI
     */
    @Column(name = "name")
    private String name;

    @Column(name = ColumnKey.POSITION)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long position;


    /**
     * GURUHNING TURI
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnKey.GROUP_TYPE_ID)
    private GroupType groupType;

    /**
     * GURUHNING QAYSI MUTAXASISLIKKA TEGISHLI EKANLIGI
     */
    @Column(name = ColumnKey.SPECIALIZATION_ID, nullable = false)
    private Long specializationId;

    /**
     * TANLAGAN MUTAXASSISLIGINING NARXI. MUTAXASSISLIKNI TANLAB NARXINI O'ZI O'ZGARTIRIB OLISHI HAM MUMKIN.
     */
    @Column(name = ColumnKey.PRICE, nullable = false)
    private Double price;

    /**
     * QAYSI FILLIALGA TEGISHLI EKANLIGI
     */
    @Column(name = ColumnKey.BRANCH_ID, nullable = false)
    private Long branchId;

    /**
     * GURUH HAFTANING QAYSI KUNLARIDA O'QISHI
     */


    @ElementCollection(targetClass = WeekdayEnum.class)
    @CollectionTable(
            name = TableNameConstant.ADMISSION_WEEK_DAYS,
            joinColumns = {@JoinColumn(name = ColumnKey.ADMISSION_ID)},
            uniqueConstraints = @UniqueConstraint(columnNames = {ColumnKey.ADMISSION_ID, ColumnKey.WEEKDAYS})
    )
    @Enumerated(EnumType.STRING)
    @Column(name = ColumnKey.WEEKDAYS)
    private Collection<WeekdayEnum> weekdays;

    /**
     * DARSLARNING BOSHLANISH SOATI (09:00)
     */
    @Column(name = ColumnKey.LESSON_START_TIME, nullable = false)
    private Time lessonStartTime;

    /**
     * DARSLARNING TUGASH SOATI (13:00)
     */
    @Column(name = ColumnKey.LESSON_END_TIME, nullable = false)
    private Time lessonEndTime;

    /**
     * GURUHNING OCHILISHI UCHUN PUL TO'LASHI KERAK BO'LGAN TALABALARNING MAXIMAL SONI
     */
    @Column(name = ColumnKey.MAXIMUM_NUMBER_OF_PAID_STUDENTS)
    private Integer maximumNumberOfPaidStudents;

    /**
     * QABULNING BOSHLANISH VAQTI
     */
    @Column(name = ColumnKey.START_DATE, nullable = false)
    private Date startDate;

    /**
     * QABULNING TUGASH VAQTIw
     */
    @Column(name = ColumnKey.END_DATE, nullable = false)
    private Date endDate;

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

    @Column(name = ColumnKey.HAS_SCORE)
    private Boolean hasScore;

    public Boolean getHasScore() {
        return hasScore != null && hasScore;
    }
}
