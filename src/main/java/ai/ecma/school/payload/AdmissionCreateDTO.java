package ai.ecma.school.payload;

import ai.ecma.education.enums.WeekdayEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * @author Muhammad Mo'minov
 * @apiNote ...
 * @since 24.11.2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdmissionCreateDTO {
    /**
     * GURUHNING TURI
     */
    @NotNull(message = "{GROUP_TYPE_REQUIRED}")
    private Long groupTypeId;

    /**
     * GURUHNING QAYSI MUTAXASISLIKKA TEGISHLI EKANLIGI
     */
    @NotNull(message = "{SPECIALIZATION_REQUIRED}")
    private Long specializationId;


    @NotNull(message = "{BRANCH_REQUIRED}")
    private Long branchId;

    /**
     * GURUH HAFTANING QAYSI KUNLARIDA O'QISHI
     */
    @NotEmpty(message = "{WEEKDAYS_REQUIRED}")
    private Collection<WeekdayEnum> weekdays;

    /**
     * GURUHDA DASNING BOSHLANISH SOATI (09:00)
     */
    @NotNull(message = "{LESSON_START_TIME_REQUIRED}") // HH:mm
//    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$", message = "{LESSON_START_TIME_WRONG_FORMAT}")
    private Long lessonStartTime;

    /**
     * GURUHDA DASNING TUGASH SOATI (13:00)
     */
    @NotNull(message = "{LESSON_END_TIME_REQUIRED}") // HH:mm
//    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$", message = "{LESSON_END_TIME_WRONG_FORMAT}")
    private Long lessonEndTime;

    /**
     * GURUHNING OCHILISHI UCHUN PUL TO'LASHI KERAK BO'LGAN TALABALARNING MAKSIMAL SONI
     */
    @NotNull(message = "{MAXIMUM_NUMBER_OF_PAID_STUDENTS_REQUIRED}")
    private Integer maximumNumberOfPaidStudents;

    /**
     * QABULNING BOSHLANISH VAQTI
     */
    @NotNull(message = "{START_TIME_ADMISSION_REQUIRED}")
    private Long startDate;

    /**
     * QABULNING TUGASH VAQTI
     */
    @NotNull(message = "{END_TIME_ADMISSION_REQUIRED}")
    private Long endDate;

    @NotBlank(message = "{NAME_REQUIRED}")
    private String name;

    private Boolean hasScore;

    public Boolean getHasScore() {
        return hasScore != null && hasScore;
    }
}
