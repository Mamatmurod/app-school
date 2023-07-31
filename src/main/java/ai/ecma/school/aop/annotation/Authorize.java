package ai.ecma.school.aop.annotation;


import ai.ecma.school.enums.authEnums.PermissionEnum;

import java.lang.annotation.*;


@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface Authorize {
    PermissionEnum[] permission() default {};
}
