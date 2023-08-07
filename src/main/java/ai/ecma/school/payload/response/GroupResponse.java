package ai.ecma.school.payload.response;

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
public class GroupResponse {
    private UUID id;
    private GroupTypeEnum groupType;
    private UUID levelId;
    private UUID admissionId;
    private Long branchId;
    private GroupStatusEnum status;
    private Integer maximumNumberOfStudents;
    private Collection<WeekdayEnum> weekdays;
    private Long lessonStartTime;
    private Long lessonEndTime;
}
