package ai.ecma.school.entity;

import ai.ecma.school.entity.template.AbsUUIDUserAuditEntity;
import ai.ecma.school.utils.ColumnKey;
import ai.ecma.school.utils.TableNameConstant;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Date;

/**
 * @author Komronbek Bozorov 02.08.2023
 * @apiNote QABUL
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

    @Column(name = ColumnKey.POSITION)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long position;

    @Column(name = ColumnKey.LEVEL)
    @ManyToOne
    private Level level;

    @Column(name = ColumnKey.TOTAL_PRICE)
    private double totalPrice = 0.0;

    @Column(name = ColumnKey.DISCOUNT_PRICE)
    private double discountPrice = 0.0;

    @Column(name = ColumnKey.DISCOUNT_PRICE_PERCENTAGE)
    private byte discountPricePercentage = 0;

    /**
     * QAYSI FILLIALGA TEGISHLI EKANLIGI
     */
    @Column(name = ColumnKey.BRANCH_ID, nullable = false)
    private Long branchId;


    /**
     * QABULNING BOSHLANISH VAQTI
     */
    @Column(name = ColumnKey.START_DATE)
    private Date startDate;

    /**
     * QABULNING TUGASH VAQTIw
     */
    @Column(name = ColumnKey.END_DATE)
    private Date endDate;

    /**
     * QABULNING O'CHIRILGANMI YO'QMI?
     */
    @Column(name = ColumnKey.IS_DELETED)
    private Boolean isDeleted = false;


}
