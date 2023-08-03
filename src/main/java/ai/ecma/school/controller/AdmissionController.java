package ai.ecma.school.controller;


import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AdmissionDTO;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequestMapping(AdmissionController.BASE_URL)
public interface AdmissionController {
    String BASE_URL = "/api/school/admission";
    String GET_ADMISSION_LIST = "/list";
    String ADD_ADMISSION = "/add";
    String EDIT_ADMISSION = "/edit";
    String DELETE_ADMISSION = "/delete/{id}";

    @GetMapping(GET_ADMISSION_LIST)
    ApiResult<?> getAdmissionList();

    @PostMapping(ADD_ADMISSION)
    ApiResult<?> addAdmission(@RequestBody AdmissionDTO admissionDTO);

    @PutMapping(EDIT_ADMISSION)
    ApiResult<?> editAdmission(@RequestBody AdmissionDTO admissionDTO);

    @DeleteMapping(DELETE_ADMISSION)
    ApiResult<?> deleteAdmission(@PathVariable UUID id);

}
