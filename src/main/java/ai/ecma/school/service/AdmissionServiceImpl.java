package ai.ecma.school.service;

import ai.ecma.school.entity.Admission;
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
        if (admissionRepository.findByGroupLevelEnum(admissionDTO.getGroupLevel())) {
            return ApiResult.errorResponse("Admission Already Exist", 409);
        }
        Admission admission = new Admission();
        admission.setBranchId(CommonUtils.getCurrentUser().getActiveCompany());
        admission.setEndDate(new Date(admissionDTO.getEndDate()));
        admission.setStartDate(new Date(admissionDTO.getStarDate()));
        admission.setGroupLevelEnum(getGroupLevel(admissionDTO.getGroupLevel()));
        admissionSave(admissionDTO, admission);
        return ApiResult.successResponse("Admission Added Successfully");
    }

    private double getTotalPriceToDiscountPrice(Admission admission) {
        if (admission.getDiscountPricePercentage()==0) return admission.getTotalPrice();
        return admission.getTotalPrice()-(admission.getTotalPrice() / 100) * admission.getDiscountPricePercentage();
    }

    private GroupLevelEnum getGroupLevel(String groupLevel) {
        return switch (groupLevel) {
            case "5" -> GroupLevelEnum.V;
            case "6" -> GroupLevelEnum.VI;
            case "7" -> GroupLevelEnum.VII;
            case "8" -> GroupLevelEnum.VIII;
            case "9" -> GroupLevelEnum.IX;
            case "10" -> GroupLevelEnum.X;
            case "11" -> GroupLevelEnum.XI;
            default -> throw RestException.notFound("Group Level not founded!");
        };
    }

    @Override
    public ApiResult<?> editAdmission(AdmissionDTO admissionDTO) {

        Admission admission = admissionRepository.findById(admissionDTO.getId())
                .orElseThrow(() -> RestException.notFound("Admission not founded!"));
        if (admissionDTO.getEndDate() != null) admission.setEndDate(new Date(admissionDTO.getEndDate()));
        if (admissionDTO.getStarDate() != null) admission.setStartDate(new Date(admissionDTO.getStarDate()));
        if (admissionDTO.getGroupLevel() != null) admission.setGroupLevelEnum(getGroupLevel(admissionDTO.getGroupLevel()));
        admissionSave(admissionDTO, admission);
        return ApiResult.successResponse("Admission edited!");
    }

    private void admissionSave(AdmissionDTO admissionDTO, Admission admission) {
        if (admissionDTO.getTotalPrice() != null) admission.setTotalPrice(admissionDTO.getTotalPrice());
        if (admissionDTO.getDiscountPricePercentage() != null) admission.setDiscountPricePercentage(admissionDTO.getDiscountPricePercentage());
        if (admission.getTotalPrice()!=0.0) admission.setDiscountPrice(getTotalPriceToDiscountPrice(admission));

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
