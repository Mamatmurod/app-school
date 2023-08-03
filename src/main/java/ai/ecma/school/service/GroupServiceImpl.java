package ai.ecma.school.service;

import ai.ecma.school.mapper.GroupMapper;
import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.request.GroupCreateRequest;
import ai.ecma.school.payload.request.GroupUpdateRequest;
import ai.ecma.school.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
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
    public ApiResult<?> deleteGroup(long id) {
        return null;
    }
}
