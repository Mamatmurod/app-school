package ai.ecma.school.feign;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.UserDTO;
import ai.ecma.school.payload.thirdParty.PageAddDTO;
import ai.ecma.school.payload.thirdParty.PermissionAddDTO;
import ai.ecma.school.utils.AppConstant;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@FeignClient(name = AuthFeign.AUTH_SERVICE_BASE_PATH, configuration = FeignConfig.class)
public interface AuthFeign {
    String BASE_PATH = "/api/auth/v1";
    String AUTH_SERVICE_BASE_PATH = AppConstant.AUTH_SERVICE + BASE_PATH;
    String PAGE_PATH = "/for-microservice/other-microservice/page";
    String PERMISSION_PATH = "/for-microservice/other-microservice/permission";
    String GET_USER_OR_CREATE_BY_PHONE_NUMBER = "/for-microservice/user/get_or_create-phone-number";
    String GET_USERS_OR_CREATE_BY_PHONE_NUMBERS = "/for-microservice/user/get_or_create-phone-numbers";
    String REMOVE_OLD_USER_STUDENT_ROLE = "/for-microservice/user/remove-old-user-student-role/{id}";

    @GetMapping("/for-microservice/user/simple-user-map")
    ApiResult<HashMap<UUID, String>> getUserMap(@RequestBody Collection<UUID> userIdList);

    @GetMapping("/for-microservice/user/user-by-token-for-application-university")
    ApiResult<UserDTO> checkPermission(@RequestHeader("Authorization") String token);

    @GetMapping("/for-microservice/user/user-by-token-for-application-university")
    ApiResult<UserDTO> checkPermission();

    @GetMapping("/for-microservice/user/university/mentor-list")
    ApiResult<List<UserDTO>> getAllMentors();

    @GetMapping("/for-microservice/user/university/mentor-map")
    ApiResult<Map<UUID, UserDTO>> getMentorMap();

    @GetMapping("/for-microservice/user/user-by-id/{userId}")
    ApiResult<UserDTO> getUserDTOById(@PathVariable String userId);

    @GetMapping("/for-microservice/user/user-by-id/{userId}")
    ApiResult<UserDTO> getUserDTOByIdForBased(@PathVariable String userId);

    @GetMapping("/for-microservice/user/admin-list")
    ApiResult<List<UserDTO>> getAllViewMemberFromAuthService();

    // VERIFIED
    @PostMapping("/for-microservice/user/add-user-list")
    ApiResult<List<UserDTO>> syncStudentsByExcelFile(@RequestBody List<UserDTO> userList);

    // VERIFIED
    @PostMapping("/for-microservice/user/users-by-id-list")
    ApiResult<List<UserDTO>> fetchUsersById(@RequestBody Collection<UUID> idList);

    /**
     * USHBU YO'L ORQALI BERILGAN LISTDAGI BARCHA HUQUQLARI BOR USER LAR LISTINI
     * AUTH SERVICE DAN QAYTARILADI.
     * v1/for-microservice/user/users-by-permission
     */
    @PostMapping("/for-microservice/user/users-by-permission")
    ApiResult<List<UserDTO>> getUserListHavePermissionListForViewService(
            @RequestHeader(AppConstant.REQUEST_ATTRIBUTE_CURRENT_USER_ID) String userId,
            @RequestHeader(AppConstant.REQUEST_ATTRIBUTE_CURRENT_USER_PERMISSIONS) String permissions,
            @RequestBody List<String> permissionEnums
    );

    @PostMapping(value = PAGE_PATH)
    ApiResult<Boolean> addPageToAuth(
            @RequestBody List<PageAddDTO> pageAddDTOList
    );

    @PostMapping(value = PERMISSION_PATH)
    ApiResult<Boolean> addPermissionToAuth(
            @RequestBody List<PermissionAddDTO> permissionAddDTOList
    );

    @PutMapping("/user/edit-self")
    ApiResult<?> editUser(@RequestBody UserDTO userDTO);


    @DeleteMapping(REMOVE_OLD_USER_STUDENT_ROLE)
    ApiResult<?> removeOldUserStudentRole(
            @PathVariable UUID id
    );
}
