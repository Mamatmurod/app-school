package ai.ecma.school.enums.authEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;

//ERP PROJECTIDA MAVJUD BO'LGAN MODULE LAR RO'YXATI (ACADEMY,ACCOUN VA H.K)
@AllArgsConstructor
@Getter
public enum ModuleEnum {
    LMS("LMS", null, false);

    private final String title;

    private final ModuleEnum before;

    //O'CHIRILGANMI
    private final boolean deleted;

}
