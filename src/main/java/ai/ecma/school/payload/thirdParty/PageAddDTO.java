package ai.ecma.school.payload.thirdParty;


import ai.ecma.school.enums.authEnums.DepartmentEnum;
import ai.ecma.school.enums.authEnums.PageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * BOSHQA MICROSERVICE LAR TOMONIDAN QO'SHILADIGAN PAGELAR UCHUN
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageAddDTO implements Serializable {

    //QO'SHILADIGAN PAGE NING ADMIN TOMONGA KO'RINADIGAN QISMI(Kurslar, Modullar, Xodimlar...)
    private String title;

    //PAGE NING SISTEMADA FOYDALANADIGAN NOMI (COURSE, EMPLOYEE ...)
    private PageEnum name;

    //QO'SHAYOTGAN PAGE QAYSI MODULE ICHIDA EKANLIGI
    private String moduleName;

    //QO'SHAYOTGAN PAGE QAYSI DEPARTMENT ICHIDA EKANLIGI
    private DepartmentEnum departmentName;

    //QO'SHAYOTGAN PAGE NING AVVALGI MODULE QAYSI BO'LGANLIGI
    private String beforeModuleName;

    //QO'SHAYOTGAN PAGE NING AVVALGI DEPARTMENT QAYSI BO'LGANLIGI
    private DepartmentEnum beforeDepartmentName;

    //QO'SHAYOTGAN PAGE TAHRIRLANAYOTGAN BO'LSA, AVVAL QAYSI NOMDA EDI
    //AGAR BEFORE NULL BO'LSA YANGI QO'SHILAYOTGAN BO'LADI
    private PageEnum beforeName;

    //QO'SHAYOTGAN PAGE O'CHIRILISHI KERAK BO'LSA TRUE BERILADI
    private boolean deleted;
}


