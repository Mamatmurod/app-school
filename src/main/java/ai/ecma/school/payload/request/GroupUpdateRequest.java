package ai.ecma.school.payload.request;

import ai.ecma.school.enums.GroupLevelEnum;
import ai.ecma.school.enums.GroupStatusEnum;
import ai.ecma.school.enums.GroupTypeEnum;
import ai.ecma.school.enums.WeekdayEnum;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Collection;
import java.util.UUID;
@Getter
@Setter
public class GroupUpdateRequest {
    private GroupTypeEnum groupType;
    private GroupLevelEnum groupLevel;
    private UUID admissionId;
    private Double price;
    private Integer discountPricePercentage;
    private Long branchId;
    private GroupStatusEnum status;
    private Integer maximumNumberOfStudents;
    private Collection<WeekdayEnum> weekdays;
    private Long lessonStartTime;
    private Long lessonEndTime;
}
