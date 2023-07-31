package ai.ecma.school.utils;

import ai.ecma.school.entity.template.AbsLongEntity;
import ai.ecma.school.entity.template.AbsUUIDUserAuditEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * This interface is not documented :(
 *
 * @author Muhammad Muminov
 * @since 5/24/2023
 */

public class ListUtils {

    /**
     * UUID ID'GA EGA ENTITYLARDAN ID'LARINI YIG'IB QAYTARADI
     */
    public static List<UUID> reduceUUID(List<? extends AbsUUIDUserAuditEntity> entities) {
        return entities.stream().map(AbsUUIDUserAuditEntity::getId).collect(Collectors.toList());
    }

    /**
     * UUID Long ID'GA EGA ENTITYLARDAN ID'LARINI YIG'IB QAYTARADI
     */
    public static List<Long> reduceLongID(List<? extends AbsLongEntity> entities) {
        return entities.stream().map(AbsLongEntity::getId).collect(Collectors.toList());
    }
}
