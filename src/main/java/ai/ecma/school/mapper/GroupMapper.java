package ai.ecma.school.mapper;

import ai.ecma.school.entity.Admission;
import ai.ecma.school.entity.Group;
import ai.ecma.school.payload.request.GroupCreateRequest;
import ai.ecma.school.payload.response.GroupResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    @Mapping(target = "admission", source = "admission")
    @Mapping(target = "lessonStartTime", expression = "java(new java.sql.Time(request.getLessonStartTime()))")
    @Mapping(target = "lessonEndTime", expression = "java(new java.sql.Time(request.getLessonEndTime()))")
    Group groupFromCreateRequest(GroupCreateRequest request, Admission admission);

    @Mapping(source = "admission.id", target = "admissionId")
    @Mapping(source = "lessonStartTime.time", target = "lessonStartTime")
    @Mapping(source = "lessonEndTime.time", target = "lessonEndTime")
    GroupResponse groupToGroupResponse(Group group);
}
