package ai.ecma.school.controller;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AdmissionDTO;
import ai.ecma.school.payload.CreateInvoiceDTO;
import ai.ecma.school.service.AdmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AdmissionControllerImpl implements AdmissionController{
    private final AdmissionService admissionService;

    @Override
    public ApiResult<?> getAdmissionList() {
        return admissionService.getAdmissionList();
    }

    @Override
    public ApiResult<?> addAdmission(AdmissionDTO admissionDTO) {
        return admissionService.addAdmission(admissionDTO);
    }

    @Override
    public ApiResult<?> editAdmission(AdmissionDTO admissionDTO) {
        return admissionService.editAdmission(admissionDTO);
    }

    @Override
    public ApiResult<?> deleteAdmission(UUID id) {
        return admissionService.deleteAdmission(id);
    }

    @Override
    public ApiResult<?> generateInvoice(CreateInvoiceDTO createInvoiceDTO) {
        return admissionService.generateInvoice(createInvoiceDTO);
    }
}
