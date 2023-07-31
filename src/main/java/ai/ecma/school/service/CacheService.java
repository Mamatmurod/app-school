package ai.ecma.school.service;

import ai.ecma.school.feign.AuthFeign;
import ai.ecma.school.payload.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CacheService {

    private final AuthFeign authFeign;

//    @Cacheable(key = "#token", value = "users_for_school", sync = true, cacheManager = "userCacheManager")
    public UserDTO getUserDTOFromAuthByToken(String token) {
        return authFeign.checkPermission(token).getData();
    }
}
