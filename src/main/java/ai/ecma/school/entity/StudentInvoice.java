package ai.ecma.school.entity;

import ai.ecma.school.entity.template.AbsUUIDUserAuditEntity;
import ai.ecma.school.enums.MonthEnum;
import ai.ecma.school.enums.PaymentStatusEnum;
import ai.ecma.school.enums.PaymentTypeEnum;
import ai.ecma.school.utils.ColumnKey;
import ai.ecma.school.utils.TableNameConstant;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = TableNameConstant.STUDENT_INVOICE)
@Getter
@Setter
@Builder(setterPrefix = "set")
@SQLDelete(sql = ("update " + TableNameConstant.STUDENT_INVOICE + " set deleted=true where id=?"))
@Where(clause = "deleted=false")
public class StudentInvoice extends AbsUUIDUserAuditEntity {

    @ManyToOne
    @JoinColumn(name = ColumnKey.GROUPS_STUDENT_ID)
    private GroupStudent groupStudent;

    @Column(name = ColumnKey.INVOICE_ID)
    private String invoiceId;

    @Column(name = ColumnKey.YEAR)
    private Integer year;

    @Enumerated(EnumType.STRING)
    @Column(name = ColumnKey.MONTH)
    private List<MonthEnum> monthEnum;

    @Column(name = ColumnKey.AMOUNT)
    private Double amount;

    @Column(name = ColumnKey.PAYMENT_DATE)
    private Date paymentDate;

    @Column(name = ColumnKey.PAYMENT_TYPE_ENUM)
    @Enumerated(EnumType.STRING)
    private PaymentTypeEnum paymentTypeEnum;

    @Column(name = ColumnKey.PAYMENT_STATUS_ENUM)
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatusEnum;

    @Column(name = ColumnKey.PAYMENT_STATUS_DATE)
    private Date paymentStatusDate;
}
