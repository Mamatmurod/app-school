package ai.ecma.school.test;

import ai.ecma.school.feign.AuthFeign;
import ai.ecma.school.net.ApiResult;
import ai.ecma.school.utils.AppConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 02.04.2022
 */
@RequestMapping(AppConstant.BASE_PATH_V1 + "/test")
@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {
    private final AuthFeign authFeign;

    @PostMapping()
    public ApiResult<?> test() {
        return ApiResult.successResponse("Hello");
    }


}
