package ai.ecma.school.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GroupLevelEnum {
    V("5"),
    VI("6"),
    VII("7"),
    VIII("8"),
    IX("9"),
    X("10"),
    XI("11");

    private final String level;
}
