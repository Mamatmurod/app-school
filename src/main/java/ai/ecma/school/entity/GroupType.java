package ai.ecma.school.entity;


import ai.ecma.school.entity.template.AbsLongEntity;
import ai.ecma.school.utils.ColumnKey;
import ai.ecma.school.utils.TableNameConstant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * @author Muhammad Mo'minov
 * 08.11.2021
 * @apiNote GURUHLARNING TURINI SAQLAYDI (Online Bootcamp | Unicorn)
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = ("update " + TableNameConstant.GROUP_TYPE + " set deleted=true where id=?"))
@Where(clause = "deleted=false")
@Entity(name = TableNameConstant.GROUP_TYPE)
public class GroupType extends AbsLongEntity {
    /**
     * CLASS TURINING NOMI | (A & B $ D)
     */
    @Column(name = ColumnKey.NAME, nullable = false)
    private String name;

    /**
     * CLASS O'QUVCHILARI BINOGA KELISH KELMASLIGI | AGAR true BO'LSA KELADI
     */
    @Column(name = "coming_to_branch")
    private boolean comingToBranch;

    /**
     * CLASS O'QUVCHILARI VIDEO KO'RIB O'RGANADIMI | AGAR true BO'LSA VIDEO KO'RADI
     */
    @Column(name = "watch_video_content")
    private boolean watchVideoContent;

    /**
     * CLASS O'QUVCHILARI SUPPORT JAMOASI TARAFDAN QO'LLAB QUVVATLANADIMI | AGAR true BO'LSA SUPPORT QILINADI
     */
    @Column(name = "supported")
    private boolean supported;

    /**
     * CLASS O'QUVCHILARI MAXSUS VAZIFA BAJARADIMI | AGAR true BO'LSA BAJARADI
     */
    @Column(name = "does_special_task")
    private boolean doesSpecialTask;

    /**
     * BU CLASS TURI HALI AKTIVMI
     */
    @Column(name = "active", nullable = false)
    private boolean active;
}
