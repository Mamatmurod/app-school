package ai.ecma.school.aop.executor;

import ai.ecma.school.aop.annotation.Authorize;
import ai.ecma.school.component.MessageService;
import ai.ecma.school.enums.authEnums.PermissionEnum;
import ai.ecma.school.exception.RestException;
import ai.ecma.school.payload.UserDTO;
import ai.ecma.school.service.CacheService;
import ai.ecma.school.utils.AppConstant;
import ai.ecma.school.utils.CommonUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static ai.ecma.school.utils.CommonUtils.currentRequest;


/**
 * @author Muhammad Mo'minov
 * 06.11.2021
 */
@Slf4j
@Order(value = 1)
@Aspect
@Component
@RequiredArgsConstructor
@CacheConfig(cacheManager = "userCacheManager")
public class CheckAuthAspect {

    private final CacheService cacheService;

    @Before(value = "@annotation(authorize)")
    public void checkAuthExecutor(Authorize authorize) {
        check(authorize);
    }

    private String getTokenFromRequest(HttpServletRequest httpServletRequest) {
        try {
            return httpServletRequest.getHeader(AppConstant.AUTHORIZATION_HEADER);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    public void check(Authorize authorize) {

        HttpServletRequest httpServletRequest = currentRequest();

        String token = getTokenFromRequest(httpServletRequest);
        if (token == null) {
            throw RestException.restThrow("FORBIDDEN", HttpStatus.FORBIDDEN);
        }

        String userIdFromRequest = CommonUtils.getUserIdFromRequest(httpServletRequest);

        if (userIdFromRequest == null || userIdFromRequest.isEmpty()) {
            UserDTO userDTO = cacheService.getUserDTOFromAuthByToken(token);
            PermissionEnum[] permission = authorize.permission();
            if (permission.length > 0 && notPermission(userDTO.getPermissions(), permission)) {
                throw RestException.restThrow(MessageService.getMessage("YOU_ARE_NOT_ALLOWED_TO_PERFORM_THIS_ACTION"), HttpStatus.FORBIDDEN);
            }
            httpServletRequest.setAttribute(AppConstant.REQUEST_ATTRIBUTE_CURRENT_USER, userDTO);
        } else {
            if (authorize.permission().length > 0 && notPermission(CommonUtils.getUserPermissionsFromRequest(httpServletRequest), authorize.permission()))
                throw RestException.restThrow(MessageService.getMessage("YOU_ARE_NOT_ALLOWED_TO_PERFORM_THIS_ACTION"), HttpStatus.FORBIDDEN);

            setUserIdAndPermissionFromRequest(httpServletRequest);
        }
    }

    private boolean notPermission(List<String> hasPermission, PermissionEnum[] mustPermission) {
        if (hasPermission == null)
            return true;
        for (PermissionEnum permissionEnum : mustPermission) {
            if (hasPermission.contains(permissionEnum.name()))
                return false;
        }
        return true;
    }

    private boolean notPermission(String permission, PermissionEnum[] mustPermission) {
        if (permission == null || permission.isEmpty())
            return true;
        for (PermissionEnum permissionEnum : mustPermission) {
            if (permission.contains(permissionEnum.name()))
                return false;
        }
        return true;
    }

    private void setUserIdAndPermissionFromRequest(HttpServletRequest httpServletRequest) {
        String userId = CommonUtils.getUserIdFromRequest(httpServletRequest);
        String permissions = CommonUtils.getUserPermissionsFromRequest(httpServletRequest);

        httpServletRequest.setAttribute(AppConstant.REQUEST_ATTRIBUTE_CURRENT_USER_ID, userId);
        httpServletRequest.setAttribute(AppConstant.REQUEST_ATTRIBUTE_CURRENT_USER_PERMISSIONS, permissions);
    }

}
