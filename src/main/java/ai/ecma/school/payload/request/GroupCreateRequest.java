package ai.ecma.school.payload.request;

import ai.ecma.school.entity.Admission;
import ai.ecma.school.entity.Level;
import ai.ecma.school.enums.GroupLevelEnum;
import ai.ecma.school.enums.GroupStatusEnum;
import ai.ecma.school.enums.GroupTypeEnum;
import ai.ecma.school.enums.WeekdayEnum;
import lombok.Getter;

import java.sql.Time;
import java.util.Collection;
import java.util.UUID;

@Getter
public class GroupCreateRequest {
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
