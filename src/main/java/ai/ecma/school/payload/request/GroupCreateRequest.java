package ai.ecma.school.payload.request;

import ai.ecma.school.entity.Admission;
import ai.ecma.school.enums.GroupLevelEnum;
import ai.ecma.school.enums.GroupStatusEnum;
import ai.ecma.school.enums.GroupTypeEnum;
import ai.ecma.school.enums.WeekdayEnum;
import ai.ecma.school.utils.ColumnKey;
import ai.ecma.school.utils.TableNameConstant;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Time;
import java.util.Collection;
@Getter
public class GroupCreateRequest {
    private GroupTypeEnum groupType;
    private GroupLevelEnum groupLevelEnum;
    private Long admissionId;
    private Double price;
    private Integer discountPricePercentage;
    private Long branchId;
    private GroupStatusEnum status;
    private Integer maximumNumberOfStudents;
    private Collection<WeekdayEnum> weekdays;
    private Time lessonStartTime;
    private Time lessonEndTime;
}
