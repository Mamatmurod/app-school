package ai.ecma.school.controller;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.request.GroupCreateRequest;
import ai.ecma.school.payload.request.GroupUpdateRequest;
import ai.ecma.school.utils.AppConstant;
import org.springframework.web.bind.annotation.*;

@RequestMapping(GroupController.GROUP_CONTROLLER_PATH)
public interface GroupController {
    String GROUP_CONTROLLER_PATH = AppConstant.BASE_PATH+"/group";
    String GET_GROUP_BY_ID = "/get/{id}";
    String GET_GROUP_LIST = "/list";
    String ADD_GROUP = "/add";
    String EDIT_GROUP = "/edit/{id}";
    String DELETE_GROUP = "/delete/{id}";
    @PostMapping(ADD_GROUP)
    ApiResult<?> addGroup(@RequestBody GroupCreateRequest groupCreateRequest);
    @GetMapping(GET_GROUP_BY_ID)
    ApiResult<?> getGroupById(@PathVariable long id);
    @GetMapping(GET_GROUP_LIST)
    ApiResult<?> getGroupList();
    @PutMapping(EDIT_GROUP)
    ApiResult<?> editGroupById(@PathVariable long id, @RequestBody GroupUpdateRequest groupUpdateRequest);
    @DeleteMapping(DELETE_GROUP)
    ApiResult<?> deleteGroupById(@PathVariable long id);
}
