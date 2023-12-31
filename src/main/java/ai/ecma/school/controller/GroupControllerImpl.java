package ai.ecma.school.controller;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.request.GroupCreateRequest;
import ai.ecma.school.payload.request.GroupUpdateRequest;
import ai.ecma.school.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class GroupControllerImpl implements GroupController{
    private final GroupService groupService;
    @Override
    public ApiResult<?> addGroup(GroupCreateRequest groupCreateRequest) {
        return groupService.addGroup(groupCreateRequest);
    }

    @Override
    public ApiResult<?> getGroupById(UUID id) {
        return groupService.getGroupById(id);
    }

    @Override
    public ApiResult<?> getGroupList() {
        return groupService.getGroupList();
    }

    @Override
    public ApiResult<?> editGroupById(UUID id, GroupUpdateRequest groupUpdateRequest) {
        return groupService.editGroupById(id, groupUpdateRequest);
    }

    @Override
    public ApiResult<?> deleteGroupById(UUID id) {
        return groupService.deleteGroup(id);
    }


}
