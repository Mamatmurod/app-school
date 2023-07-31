package ai.ecma.school.enums.authEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Muhammad Mo'minov
 * 06.11.2021
 */
@AllArgsConstructor
@Getter
@Slf4j
public enum PermissionEnum {

//    MENAGE_SENDER_MESSAGE(PageEnum.ADMIN_SEND_MESSAGE, null, "", false),

    ;

    private final PageEnum page;

    private final PermissionEnum before;

    private final String tableName;

    private final boolean deleted;


}
