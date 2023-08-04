package ai.ecma.school.service;

import ai.ecma.school.entity.Admission;
import ai.ecma.school.entity.Level;
import ai.ecma.school.enums.GroupLevelEnum;
import ai.ecma.school.exception.RestException;
import ai.ecma.school.net.ApiResult;
import ai.ecma.school.payload.AdmissionDTO;
import ai.ecma.school.repository.AdmissionRepository;
import ai.ecma.school.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdmissionServiceImpl implements AdmissionService {
    private final AdmissionRepository admissionRepository;

    @Override
    public ApiResult<?> getAdmissionList() {
        return ApiResult.successResponse(admissionRepository.findAllByIsDeleted(false));
    }

    @Override
    public ApiResult<?> addAdmission(AdmissionDTO admissionDTO) {
        if (admissionRepository.existsAdmissionByLevel_LevelEnum(admissionDTO.getGroupLevel())) {
            return ApiResult.errorResponse("Admission Already Exist", 409);
        }
        Admission admission = new Admission();
        admission.setBranchId(CommonUtils.getCurrentUser().getActiveCompany());
        admission.setEndDate(new Date(admissionDTO.getEndDate()));
        admission.setStartDate(new Date(admissionDTO.getStarDate()));
        admissionSave(admissionDTO, admission);
        return ApiResult.successResponse("Admission Added Successfully");
    }

    private double getTotalPriceToDiscountPrice(Admission admission) {
        if (admission.getDiscountPricePercentage()==0) return admission.getMainPrice();
        return admission.getMainPrice()-(admission.getMainPrice() / 100) * admission.getDiscountPricePercentage();
    }

    @Override
    public ApiResult<?> editAdmission(AdmissionDTO admissionDTO) {
        Admission admission = admissionRepository.findById(admissionDTO.getId())
                .orElseThrow(() -> RestException.notFound("Admission not founded!"));
        if (admissionDTO.getEndDate() != null) admission.setEndDate(new Date(admissionDTO.getEndDate()));
        if (admissionDTO.getStarDate() != null) admission.setStartDate(new Date(admissionDTO.getStarDate()));
        admissionSave(admissionDTO, admission);
        return ApiResult.successResponse("Admission edited!");
    }

    private void admissionSave(AdmissionDTO admissionDTO, Admission admission) {
        if (admissionDTO.getTotalPrice() != null) admission.setMainPrice(admissionDTO.getTotalPrice());
        if (admissionDTO.getDiscountPricePercentage() != null) admission.setDiscountPricePercentage(admissionDTO.getDiscountPricePercentage());
        if (admission.getMainPrice()!=0.0) admission.setDiscountPrice(getTotalPriceToDiscountPrice(admission));
        Level level = new Level();
        level.setLevelEnum(admissionDTO.getGroupLevel());
        level.setMainPrice(admission.getMainPrice());
        level.setDiscountPrice(admission.getDiscountPrice());
        admission.setLevel(level);
        admission.setIsDeleted(false);
        admissionRepository.save(admission);
    }

    @Override
    public ApiResult<?> deleteAdmission(UUID id) {
        Admission admission = admissionRepository.findById(id)
                .orElseThrow(() -> RestException.notFound("Admission not founded!"));
        admission.setIsDeleted(true);
        admissionRepository.save(admission);
        return ApiResult.successResponse("Admission deleted!");
    }
}
