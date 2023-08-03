package ai.ecma.school.mapper;

import ai.ecma.school.entity.Admission;
import ai.ecma.school.entity.Group;
import ai.ecma.school.payload.request.GroupCreateRequest;
import ai.ecma.school.payload.response.GroupResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    @Mapping(target = "admission", source = "admission")
    @Mapping(target = "lessonStartTime", expression = "java(new java.sql.Time(request.getLessonStartTime()))")
    @Mapping(target = "lessonEndTime", expression = "java(new java.sql.Time(request.getLessonEndTime()))")
    @Mapping(target = "discountPricePercentage", source = "request.discountPricePercentage")
    @Mapping(target = "branchId", source = "request.branchId")
    Group groupFromCreateRequest(GroupCreateRequest request, Admission admission);

    @Mapping(target = "admissionId", source = "group.admission.id")
    @Mapping(target = "lessonStartTime", expression = "java(group.getLessonStartTime().getTime())")
    @Mapping(target = "lessonEndTime", expression = "java(group.getLessonEndTime().getTime())")
    GroupResponse groupToGroupResponse(Group group);

    List<GroupResponse> groupsToGroupResponses(List<Group> groups);
}
