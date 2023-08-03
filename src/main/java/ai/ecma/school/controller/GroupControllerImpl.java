package ai.ecma.school.controller;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.request.GroupCreateRequest;
import ai.ecma.school.payload.request.GroupUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GroupControllerImpl implements GroupController{
    @Override
    public ApiResult<?> addGroup(GroupCreateRequest groupCreateRequest) {
        return null;
    }

    @Override
    public ApiResult<?> getGroupById(long id) {
        return null;
    }

    @Override
    public ApiResult<?> getGroupList() {
        return null;
    }

    @Override
    public ApiResult<?> editGroupById(long id, GroupUpdateRequest groupUpdateRequest) {
        return null;
    }

    @Override
    public ApiResult<?> editGroup(long id) {
        return null;
    }
}
