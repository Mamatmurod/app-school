package ai.ecma.school.payload;

import ai.ecma.education.enums.WeekdayEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

/**
 * @author Muhammad Mo'minov
 * @apiNote ASOSAN QABULNI QAYTARISH (RESPONSE) UCHUN MO'LJALLANGAN DTO
 * @since 12.11.2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdmissionDTO {
    /**
     * ID
     */
    private UUID id;

    /**
     * NOMI
     */
    private String name;

    /**
     * QABUL QAYSI FILLIALGA TEGISHLI EKANLIGI
     */
    private BranchDTO branch;

    /**
     * GURUHNING TURI
     */
    private GroupTypeDTO groupType;

    /**
     * GURUHNING QAYSI MUTAXASISLIKKA TEGISHLI EKANLIGI
     */
    private SpecializationDTO specialization;

    /**
     * TANLAGAN MUTAXASSISLIGINING NARXI. MUTAXASSISLIKNI TANLAB NARXINI O'ZI O'ZGARTIRIB OLISHI HAM MUMKIN.
     */
    private Double price;

    /**
     * GURUH HAFTANING QAYSI KUNLARIDA O'QISHI
     */
    private Collection<WeekdayEnum> weekdays;

    /**
     * DARSLAR NECHCHI OY DAVOM ETISHI
     */
    private Integer lessonDurationInMonth;

    /**
     * DARSLAR SONI
     */
    private Integer lessonCount;

    /**
     * RO'YHATDAN O'TGAN TALABALAR SONI
     */
    private Integer registeredStudentCount;

    /**
     * PUL TO'LAGAN TALABALARNING SONI
     */
    private Integer numberOfPaidStudents;

    /**
     * GURUHNING OCHILISHI UCHUN PUL TO'LASHI KERAK BO'LGAN TALABALARNING MAKSIMAL SONI
     */
    private Integer maximumNumberOfPaidStudents;

    /**
     * GURUHDA DASNING BOSHLANISH SOATI (09:00)
     */
    private Long lessonStartTime;

    /**
     * GURUHDA DASNING TUGASH SOATI (13:00)
     */
    private Long lessonEndTime;

    /**
     * QABULNING BOSHLANISH VAQTI
     */
    private Long startDate;

    /**
     * QABULNING TUGASH VAQTI
     */
    private Long endDate;

    private Boolean hasScore;

    public Boolean getHasScore() {
        return hasScore != null && hasScore;
    }


}
