package ai.ecma.school.enums;

import lombok.Getter;

@Getter
public enum StudentStatusEnum {
    //    LEAD("Lead"),
    STUDENT("Student"),
    GRADUATE("Graduate"),
    ;

    private final String capitalize;


    StudentStatusEnum(String capitalize) {
        this.capitalize = capitalize;
    }
}
