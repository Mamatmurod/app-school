package ai.ecma.school.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * JINS UCHUN ENUM
 */
@Getter
@AllArgsConstructor
public enum GenderEnum {
    MALE("Male"),
    FEMALE("Female");

    private final String value;
}
