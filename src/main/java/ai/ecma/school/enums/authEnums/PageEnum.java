package ai.ecma.school.enums.authEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;

//ERP NING SALES MODULEDA MAVJUD BO'LGAN PAGELAR
@Getter
@AllArgsConstructor
public enum PageEnum {

//    for admins
//    ADMIN_SEMESTERS(DepartmentEnum.UNIVERSITY_NEW_LMS, null, null, false, "ADMIN_SEMESTERS"),
//    ADMIN_COURSES(DepartmentEnum.UNIVERSITY_NEW_LMS, null, null, false, "ADMIN_COURSES"),
//    ADMIN_DASHBOARD(DepartmentEnum.UNIVERSITY_NEW_LMS, null, null, false, "ADMIN_DASHBOARD"),
//    ADMIN_GROUP(DepartmentEnum.UNIVERSITY_NEW_LMS, null, null, false, "ADMIN_GROUP"),
//    ADMIN_MENTOR(DepartmentEnum.UNIVERSITY_NEW_LMS, null, null, false, "ADMIN_MENTOR"),
//    ADMIN_STUDENT(DepartmentEnum.UNIVERSITY_NEW_LMS, null, null, false, "ADMIN_STUDENT"),
//    ADMIN_CALENDAR(DepartmentEnum.UNIVERSITY_NEW_LMS, null, null, false, "ADMIN_CALENDAR"),
//    ADMIN_MC(DepartmentEnum.UNIVERSITY_NEW_LMS, null, null, false, "ADMIN_MC"),
//    ADMIN_SEND_MESSAGE(DepartmentEnum.UNIVERSITY_NEW_LMS, null, null, false, "ADMIN_SEND_MESSAGE"),

    ;

    private final DepartmentEnum department;

    private final DepartmentEnum beforeDepartment;

    private final PageEnum before;

    private final boolean deleted;
    private final String title;
}
