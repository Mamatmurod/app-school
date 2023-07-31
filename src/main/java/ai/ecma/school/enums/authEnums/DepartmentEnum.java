package ai.ecma.school.enums.authEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;

//ERP NING SALES MODULE DA MAVJUD BO'LGAN DEPARTMENTLAR
@Getter
@AllArgsConstructor
public enum DepartmentEnum {
    UNIVERSITY_NEW_LMS("UNIVERSITY_NEW_LMS", ModuleEnum.LMS, null, false),
    ;
    private final String title;

    private final ModuleEnum moduleEnum;

    private final DepartmentEnum before;

    private final boolean deleted;


}

