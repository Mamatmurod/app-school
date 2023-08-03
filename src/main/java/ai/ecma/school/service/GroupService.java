package ai.ecma.school.service;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.request.GroupCreateRequest;
import ai.ecma.school.payload.request.GroupUpdateRequest;

import java.util.UUID;

public interface GroupService {
    ApiResult<?> addGroup(GroupCreateRequest groupCreateRequest);
    ApiResult<?> getGroupById(UUID id);
    ApiResult<?> getGroupList();
    ApiResult<?> editGroupById(UUID id, GroupUpdateRequest groupUpdateRequest);
    ApiResult<?> deleteGroup(UUID id);
}
