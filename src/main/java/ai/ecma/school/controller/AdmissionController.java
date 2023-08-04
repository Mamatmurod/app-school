package ai.ecma.school.controller;


import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AdmissionDTO;
import ai.ecma.school.payload.CreateInvoiceDTO;
import ai.ecma.school.utils.AppConstant;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping(AdmissionController.ADMISSION_CONTROLLER_PATH)
public interface AdmissionController {
    String ADMISSION_CONTROLLER_PATH = AppConstant.BASE_PATH + "/admission";

    String GET_ADMISSION_LIST = "/list";
    String ADD_ADMISSION = "/add";
    String EDIT_ADMISSION = "/edit";
    String DELETE_ADMISSION = "/delete/{id}";
    String GENERATE_INVOICE = "/generate-invoice";

    @GetMapping(GET_ADMISSION_LIST)
    ApiResult<?> getAdmissionList();

    @PostMapping(ADD_ADMISSION)
    ApiResult<?> addAdmission(@RequestBody AdmissionDTO admissionDTO);

    @PutMapping(EDIT_ADMISSION)
    ApiResult<?> editAdmission(@RequestBody AdmissionDTO admissionDTO);

    @DeleteMapping(DELETE_ADMISSION)
    ApiResult<?> deleteAdmission(@PathVariable UUID id);

    @PostMapping(GENERATE_INVOICE)
    ApiResult<?> generateInvoice(@RequestBody CreateInvoiceDTO createInvoiceDTO);
}
