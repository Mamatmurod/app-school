package ai.ecma.school.service;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.request.GroupCreateRequest;
import ai.ecma.school.payload.request.GroupUpdateRequest;

public interface GroupService {
    ApiResult<?> addGroup(GroupCreateRequest groupCreateRequest);
    ApiResult<?> getGroupById(long id);
    ApiResult<?> getGroupList();
    ApiResult<?> editGroupById(long id, GroupUpdateRequest groupUpdateRequest);
    ApiResult<?> editGroup(long id);
}
