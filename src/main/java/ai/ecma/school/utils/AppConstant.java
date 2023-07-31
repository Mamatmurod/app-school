package ai.ecma.school.utils;

/**
 * @author Muhammad Mo'minov
 * 06.11.2021
 */
public interface AppConstant {
    String BASE_PATH = "/api/school";
    // String BASE_PATH_V2 = BASE_PATH + "/v2";
    String BASE_PATH_V1 = BASE_PATH + "/v1";

    String DOMAIN = "http://10.10.10.226:8080";

    long FIFTY_YEARS_IN_MS = 1577836800000L;
    long FIVE_HOURS_IN_MS = 18000000L;

    String DEFAULT_SIZE = "10";
    String DEFAULT_PAGE = "0";
    int MAX_PAGE_SIZE = 200;
    int MAX_GENERIC_VALUE_SIZE = 200;
    int DEFAULT_SIZE_FOR_VIEW = 1000;


    String AUTH_SERVICE = "AUTH-SERVICE";
    String ATTACHMENT_SERVICE = "ATTACHMENT-SERVICE";
    String FINANCE_SERVICE = "FINANCE-SERVICE";
    String ACADEMIC_CONTENT_SERVICE = "ACADEMIC-CONTENT-SERVICE";
    String STAFF_SERVICE = "STAFF-SERVICE";
    String BRANCH_SERVICE = "BRANCH-SERVICE";
    String CALL_CENTER_SERVICE = "CALL-CENTER-SERVICE";
    String TURNIKET_SERVICE = "TURNIKET-SERVICE";

    String AUTHORIZATION_HEADER = "Authorization";
    String REQUEST_ATTRIBUTE_CURRENT_USER_PERMISSIONS = "Permissions";

    String REQUEST_ATTRIBUTE_CURRENT_USER = "User";
    String REQUEST_ATTRIBUTE_TIMEZONE = "Timezone";
    String REQUEST_ATTRIBUTE_CURRENT_USER_ID = "UserId";

    String MODULE_NAME = "SCHOOL";


    String SERVICE_USERNAME_HEADER = "ServiceUsername";
    String SERVICE_PASSWORD_HEADER = "ServicePassword";

    String ACTUATOR_PATH = "http://localhost:8180/actuator/refresh";

    String ATTACHMENT_SERVICE_FILE_GET_URL = "";
    String CALL_CENTER_MESSAGE_URL = "";
    String UNKNOWN = "unknown";

    String PHONE_NUMBER_REGEX = "[+][0-9]{8,18}";

    String EXCEL_CONTENT_TYPE = "application/vnd.ms-excel";


    Integer NO_ITEMS_FOUND = 300032;
    Integer SERVER_ERROR = 500;
    Integer REQUIRED = 400;
    Integer CONFLICT = 401;
    Integer NOT_FOUND = 404;
    Integer ACCESS_DENIED = 405;
    String FEIGN_PRODUCES = "application/json;charset=utf-8";
}
