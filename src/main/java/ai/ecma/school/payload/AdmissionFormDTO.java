package ai.ecma.school.payload;

import ai.ecma.education.entity.Admission;
import ai.ecma.education.enums.WeekdayEnum;
import ai.ecma.education.payload.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * YANGI {@link Admission} QO'SHISH UCHUN FORMA VA EDIT QILISH UCHUN BITTA ADMISSION QAYTARADI
 *
 * @author Muhammad Mo'minov
 * @since 10.01.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdmissionFormDTO {
    private UUID id;

    /**
     * QABUL QAYSI FILLIALGA TEGISHLI EKANLIGI
     */
    private DropDown<BranchDTO> branch = new DropDown<>();

    /**
     * GURUHNING TURI
     */
    private DropDown<GroupTypeDTO> groupType = new DropDown<>();

    /**
     * GURUHNING QAYSI MUTAXASISLIKKA TEGISHLI EKANLIGI
     */
    private DropDown<SpecializationDTO> specialization = new DropDown<>();

    /**
     * TANLAGAN MUTAXASSISLIGINING NARXI. MUTAXASSISLIKNI TANLAB NARXINI O'ZI O'ZGARTIRIB OLISHI HAM MUMKIN.
     */
    private Double price;

    /**
     * GURUH HAFTANING QAYSI KUNLARIDA O'QISHI
     */
    private Label<WeekdayEnum> weekdays = new Label<>();

    /**
     * GURUHDA DASNING BOSHLANISH SOATI (09:00)
     */
    private Long lessonStartTime;

    /**
     * GURUHDA DASNING TUGASH SOATI (13:00)
     */
    private Long lessonEndTime;

    /**
     * GURUHNING OCHILISHI UCHUN PUL TO'LASHI KERAK BO'LGAN TALABALARNING MAKSIMAL SONI
     */
    private Integer maximumNumberOfPaidStudents;

    /**
     * QABULNING BOSHLANISH VAQTI
     */
    private Long startDate;

    /**
     * QABULNING TUGASH VAQTI
     */
    private Long endDate;

    private String name;

    private Boolean hasScore;

    public Boolean getHasScore() {
        return hasScore != null && hasScore;
    }
}
