package ai.ecma.school.service;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.request.GroupCreateRequest;
import ai.ecma.school.payload.request.GroupUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
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
