package ai.ecma.school.service;

import ai.ecma.school.entity.Admission;
import ai.ecma.school.entity.Group;
import ai.ecma.school.entity.Level;
import ai.ecma.school.exception.RestException;
import ai.ecma.school.mapper.GroupMapper;
import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.request.GroupCreateRequest;
import ai.ecma.school.payload.request.GroupUpdateRequest;
import ai.ecma.school.payload.response.GroupResponse;
import ai.ecma.school.repository.AdmissionRepository;
import ai.ecma.school.repository.GroupRepository;
import ai.ecma.school.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final LevelRepository levelRepository;
    private final AdmissionRepository admissionRepository;
    @Override
    public ApiResult<?> addGroup(GroupCreateRequest groupCreateRequest) {
        Boolean isGroupExist = groupRepository.existsByGroupTypeAndLevel_Id(groupCreateRequest.getGroupType().name(), groupCreateRequest.getLevelId());
        if (isGroupExist){
            throw RestException.alreadyExists("group");
        }
        Admission admission = admissionRepository.findById(groupCreateRequest.getAdmissionId()).orElseThrow(() -> RestException.notFound("admission"));
        Level level = levelRepository.findById(groupCreateRequest.getLevelId()).orElseThrow(() -> RestException.notFound("level"));
        Group group = groupMapper.groupFromCreateRequest(groupCreateRequest, admission, level);
        group=groupRepository.saveAndFlush(group);
        GroupResponse groupResponse = groupMapper.groupToGroupResponse(group);
        return ApiResult.successResponse(groupResponse);
    }

    @Override
    public ApiResult<?> getGroupById(UUID id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> RestException.notFound("group"));
        GroupResponse groupResponse = groupMapper.groupToGroupResponse(group);
        return ApiResult.successResponse(groupResponse);
    }

    @Override
    public ApiResult<?> getGroupList() {
        List<Group> groups = groupRepository.findAll();
        List<GroupResponse> groupResponses = groupMapper.groupsToGroupResponses(groups);
        return ApiResult.successResponse(groupResponses);
    }

    @Override
    public ApiResult<?> editGroupById(UUID id, GroupUpdateRequest groupUpdateRequest) {
        boolean exists = groupRepository.existsByGroupTypeAndLevel_IdAndIdNot(groupUpdateRequest.getGroupType().name(), groupUpdateRequest.getLevelId(), id);
        boolean isGroupExists = groupRepository.existsById(id);
        if (exists||!isGroupExists){
            throw RestException.alreadyExists("group");
        }
        Admission admission = admissionRepository.findById(groupUpdateRequest.getAdmissionId()).orElseThrow(() -> RestException.notFound("admission"));
        Level level = levelRepository.findById(groupUpdateRequest.getLevelId()).orElseThrow(() -> RestException.notFound("level"));
        Group group = groupMapper.groupFromUpdateRequest(groupUpdateRequest,admission,level);
        group.setId(id);
        Group save = groupRepository.save(group);
        GroupResponse groupResponse = groupMapper.groupToGroupResponse(group);
        return ApiResult.successResponse(groupResponse);

    }

    @Override
    public ApiResult<?> deleteGroup(UUID id) {
        groupRepository.deleteById(id);
        return ApiResult.successResponse();
    }
}
