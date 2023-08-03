package ai.ecma.school.service;

import ai.ecma.school.entity.Admission;
import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AdmissionDTO;
import ai.ecma.school.repository.AdmissionRepository;
import ai.ecma.school.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdmissionServiceImpl implements AdmissionService {
    private final AdmissionRepository admissionRepository;

    @Override
    public ApiResult<?> getAdmissionList() {
        return ApiResult.successResponse(admissionRepository.findAll());
    }

    @Override
    public ApiResult<?> addAdmission(AdmissionDTO admissionDTO) {
        if (admissionRepository.findByGroupLevelEnum(admissionDTO.getGroupLevel()))
            return ApiResult.errorResponse("Group Already Exist", 409);

        Admission admission = new Admission();

        admission.setBranchId(CommonUtils.getCurrentUser().getActiveCompany());

        admissionRepository.save(admission);

        return ApiResult.successResponse("Admission Added Successfully");
    }

    @Override
    public ApiResult<?> editAdmission(AdmissionDTO admissionDTO) {
        return null;
    }

    @Override
    public ApiResult<?> deleteAdmission(UUID id) {
        return null;
    }
}
