package ai.ecma.school.feign;

import ai.ecma.school.net.ApiResult;
import ai.ecma.school.utils.AppConstant;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Muhammad Mo'minov
 * @apiNote FAYLLAR BILAN ISHLOVCHI ATTACHMENT SERVICE BILAN ISHLAYDIGAN FEIGN
 * @since 22.11.2021
 */
@FeignClient(name = AttachmentFeign.ATTACHMENT_BASE_PATH, configuration = FeignConfig.class)
public interface AttachmentFeign {

    String BASE_PATH = "/api/attachment/v1";
    String ATTACHMENT_BASE_PATH = AppConstant.ATTACHMENT_SERVICE + BASE_PATH;

    String GET_FILE_INFO_BY_ID_LIST_PATH = "attachment/get-file-info-by-id-list";
    String FILE_INFO_BY_ID_LIST_PATH = "attachment/file-path-lms";
    String DOWNLOAD_FILE = "/attachment/download";

    @GetMapping(DOWNLOAD_FILE)
    Response download(@RequestParam String id);

    /**
     * FAYLLARNI ID SI BERIB YUBORILSA ULARNI BOR YOQLIGINI TEKSHIRADI
     */
    @GetMapping("/attachment/checking")
    ApiResult<?> exists(@RequestBody List<String> fileIdList);

}
