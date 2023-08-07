package ai.ecma.school.entity;

import ai.ecma.school.entity.template.AbsUUIDUserAuditEntity;
import ai.ecma.school.utils.ColumnKey;
import ai.ecma.school.utils.TableNameConstant;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.UUID;

/**
 * @author Muhammad Mo'minov
 * @apiNote STUDENTLARNI QABULGA QO'SHISH UCHUN. BUNDA STUDENT ALLAQACHON GURUXGA BIRIKTIRILGAN BO'LISHI HAM MUMKIN
 * @since 17.11.2021
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = ("update " + TableNameConstant.ADMISSION_STUDENT + " set deleted=true where id=?"))
@Where(clause = "deleted=false")
@Entity(name = TableNameConstant.ADMISSION_STUDENT)
public class AdmissionStudent extends AbsUUIDUserAuditEntity {

    /**
     * QABULGA YOZILGAN STUDENT
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnKey.STUDENT_ID)
    private Student student;

    /**
     * QAYSI QABULGA BIRIKTIRILGANLIGI
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = ColumnKey.ADMISSION_ID)
    private Admission admission;



    public AdmissionStudent(Student student, Admission admission) {
        this.student = student;
        this.admission = admission;
    }
}
