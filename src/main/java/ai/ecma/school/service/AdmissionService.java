package ai.ecma.school.service;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AdmissionDTO;

import java.util.UUID;

public interface AdmissionService {
    ApiResult<?> getAdmissionList();

    ApiResult<?> addAdmission(AdmissionDTO admissionDTO);

    ApiResult<?> editAdmission(AdmissionDTO admissionDTO);

    ApiResult<?> deleteAdmission(UUID id);
}
