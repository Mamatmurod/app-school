package ai.ecma.school.utils;

import ai.ecma.school.component.MessageService;
import ai.ecma.school.enums.authEnums.PermissionEnum;
import ai.ecma.school.exception.RestException;
import ai.ecma.school.payload.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ai.ecma.school.utils.AppConstant.*;

/**
 * @author Muhammad Mo'minov
 * 06.11.2021
 */
@Component
public class CommonUtils {
    public static String ATTACHMENT_SMALL_VIEW_PATH;
    public static String ATTACHMENT_MEDIUM_VIEW_PATH;
    public static String ATTACHMENT_DOWNLOAD_PATH;
    public static String DOMAIN;
    public static String ATTACHMENT_SERVICE_FILE_GET_URL;
    public static String MAKE_NGINX_DOWNLOAD_PATH;

    public static List<LocalDate> getDaysBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> datesInRange = new ArrayList<>();
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            datesInRange.add(date);
        }
        datesInRange.add(endDate);
        return datesInRange;
    }

    @SafeVarargs
    public static <T> T firstNonNull(final T... values) {
        return Stream.of(values).filter(Objects::nonNull).findFirst().orElse(null);
    }

    //QAVS LARNI QIRQIB TASHLAYDI
    public static String replaceBracket(String object) {

        String s = object.replaceAll("[\\[\\]\" ]", "");
        System.out.println(s);
        return s;
    }

    /**
     * @param currentTimeMills AGAR BERILGAN VAQT AYNI VAQTDAN O'TIB KETGAN BO'LSA TRUE QAYTARADI
     */
    public static boolean timeIsExpired(Long currentTimeMills) {
        return new Timestamp(currentTimeMills).before(new Timestamp(System.currentTimeMillis()));
    }

    public static String generateColor() {
        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(256);
        int green = randomGenerator.nextInt(256);
        int blue = randomGenerator.nextInt(256);

        return String.format("#%02x%02x%02x", red, green, blue);
    }

    public static UserDTO getCurrentUser() {
        try {
            HttpServletRequest httpServletRequest = currentRequest();
            UserDTO currentUser = (UserDTO) httpServletRequest.getAttribute(REQUEST_ATTRIBUTE_CURRENT_USER);
            if (currentUser == null || Objects.isNull(currentUser.getId())) {
                throw RestException.restThrow("Error! Access is not possible", HttpStatus.FORBIDDEN);
            }
            return currentUser;
        } catch (Exception e) {
            throw RestException.restThrow("Error! Access is not possible", HttpStatus.FORBIDDEN);
        }
    }

    public static UUID getCurrentUserId() {
        try {
            HttpServletRequest httpServletRequest = currentRequest();
            UserDTO currentUser = (UserDTO) httpServletRequest.getAttribute(REQUEST_ATTRIBUTE_CURRENT_USER);
            if (currentUser == null || Objects.isNull(currentUser.getId())) {
                throw RestException.restThrow("Error! Access is not possible", HttpStatus.FORBIDDEN);
            }
            return currentUser.getId();
        } catch (Exception e) {
            throw RestException.restThrow("Error! Access is not possible", HttpStatus.FORBIDDEN);
        }
    }

    public static String getTimezone() {
        try {
            HttpServletRequest httpServletRequest = currentRequest();
            String timezone = (String) httpServletRequest.getAttribute(REQUEST_ATTRIBUTE_TIMEZONE);
            if (timezone == null || timezone.equals("Asia/Tashkent") || !ZoneId.getAvailableZoneIds().contains(timezone)) {
                return "Asia/Tashkent";
            }
            return timezone;
        } catch (Exception e) {
            return "Asia/Tashkent";
        }
    }

    public static UserDTO getUserDTOFromRequestForAuditing() {
        try {
            HttpServletRequest httpServletRequest = currentRequest();
            return (UserDTO) httpServletRequest.getAttribute(REQUEST_ATTRIBUTE_CURRENT_USER);
        } catch (Exception e) {
            return null;
        }
    }

    //REQUEST DAN USER ID NI OLIB BERADI
    public static String getUserIdFromRequestHeader() {
        try {
            HttpServletRequest httpServletRequest = currentRequest();
            return httpServletRequest.getHeader(REQUEST_ATTRIBUTE_CURRENT_USER_ID);
        } catch (Exception e) {
            return null;
        }
    }

    //REQUEST DAN PERMISSION LARNI OLIB BERADI
    public static String getUserPermissionsFromRequestHeader() {
        try {
            HttpServletRequest httpServletRequest = currentRequest();
            return httpServletRequest.getHeader(REQUEST_ATTRIBUTE_CURRENT_USER_ID);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getUserIdFromRequest(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader(REQUEST_ATTRIBUTE_CURRENT_USER_ID);
    }

    public static String getUserPermissionsFromRequest(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader(AppConstant.REQUEST_ATTRIBUTE_CURRENT_USER_PERMISSIONS);
    }

    public static HttpServletRequest currentRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return Optional.ofNullable(servletRequestAttributes).map(ServletRequestAttributes::getRequest).orElse(null);
    }

    //REQUEST DAN TOKENNI OLIB BERADI
    public static String getTokenFromRequest() {
        HttpServletRequest httpServletRequest = currentRequest();
        if (Objects.isNull(httpServletRequest)) {
            return "";
        }
        String header = httpServletRequest.getHeader(AppConstant.AUTHORIZATION_HEADER);
        return Objects.nonNull(header) ? header : "";
    }


    public static Double changeOrderIndexTopAndBottomRequired(Double top, Double bottom) {

        //AGAR FRONT END IKKALA QIYMATNI NULL BERSA XATOLIKKA TUSHADI
        if (top == null && bottom == null)
            throw RestException.restThrow(MessageService.getMessage("TWO_ORD_NOT_NULL"), HttpStatus.BAD_REQUEST);

        //AGAR TOP NULL BO'LSA YA'NI ENG YUQORIGA OLIB CHIQMOQCHI BO'LSA BOTTOM NI YARMINI QAYTARAMAN
        if (top == null)
            return (bottom / 2);
        //AGAR BOTTOM NULL BO'LSA TOP GA 1 NI QO'SHIB QAYTARAMIZ
        if (bottom == null)
            return ++top;

        //AGAR ORALIQQA JOYLAMOQCHI BO'LSA TOP VA BOTTOMNI QO'SHIB IKKIGA BO'LIB QAYTARAMIZ
        return (top + bottom) / 2;
    }


    public static boolean havePermission(List<String> hasPermission, PermissionEnum[] mustPermission) {
        if (hasPermission == null)
            return false;
        for (PermissionEnum permissionEnum : mustPermission) {
            if (hasPermission.contains(permissionEnum.name()))
                return true;
        }
        return false;
    }


    public static boolean havePermission(List<String> hasPermission, String tableName) {
        if (hasPermission == null || tableName == null || tableName.isEmpty())
            return false;
        List<PermissionEnum> tableNamesPermissions = Arrays.stream(PermissionEnum.values()).filter(permissionEnum -> tableName.equals(permissionEnum.getTableName())).collect(Collectors.toList());

        for (PermissionEnum permissionEnum : tableNamesPermissions) {
            if (hasPermission.contains(permissionEnum.name()))
                return true;
        }
        return false;
    }

    //AGAR TIZIMDA TURMAGAN BOSHQA USER NI TEKSHIRMOQCHI BO'LSANG USER DTO NI O'ZING BERIB YUBORASAN
    public static boolean havePermission(UserDTO userDTO, PermissionEnum[] mustPermission) {
        List<String> hasPermission = userDTO.getPermissions();
        if (hasPermission == null)
            return false;
        for (PermissionEnum permissionEnum : mustPermission) {
            if (hasPermission.contains(permissionEnum.name()))
                return true;
        }
        return false;
    }


    //STRING QILIB SAQLANGAN ARRAYNI
    public static String[] getSelectedLabels(String value) {
        try {
            String arrayString = CommonUtils.replaceBracket(value);
            String[] array = arrayString.split(",");
            return array;
        } catch (Exception e) {
            return new String[0];
        }
    }

    //1-ARRAY DA BOR LEKIN 2-ARRAY DA YO'Q QIYMATNI LISTINI QAYTARADI
    public static List<String> getHaveNotElementsFirstArrayInSecondArray(String[] oldValueArr, String[] newValueArr) {

        List<String> idsForDelete = new ArrayList<>();
        for (String idInOldArray : oldValueArr) {
            boolean exist = false;
            for (String idInNewArray : newValueArr) {
                if (idInOldArray.equals(idInNewArray)) {
                    exist = true;
                    break;
                }
            }
            if (!exist)
                idsForDelete.add(idInOldArray);
        }

        return idsForDelete;
    }

    public static String makeBasicAuthAuthorization(String userLogin, String userPassword) {
        String loginPassword = userLogin + ":" + userPassword;
        String credentialEncoded = new String(Base64.getEncoder().encode(loginPassword.getBytes(StandardCharsets.UTF_8)));
        return "Basic " + credentialEncoded;
    }


    //  Sort.by(Sort.Direction.DESC, "createdAt")
    public static Sort sortByColumn(String sortedColumnName, Sort.Direction direction) {
        return Sort.by(direction, sortedColumnName);
    }

    public static String makeFullName(String firstName, String lastName) {

        String firstNameWithoutNull = Objects.nonNull(firstName) ? firstName : "";
        String lastNameWithoutNull = Objects.nonNull(lastName) ? lastName : "";

        return firstNameWithoutNull + " " + lastNameWithoutNull;
    }


    public static boolean havePermission(PermissionEnum[] mustPermission) {
        UserDTO userDTO = getCurrentUser();
        List<String> hasPermission = userDTO.getPermissions();
        if (hasPermission == null)
            return false;
        for (PermissionEnum permissionEnum : mustPermission) {
            if (hasPermission.contains(permissionEnum.name()))
                return true;
        }
        return false;
    }


    public static String byteSizeToMegabyteSize(String byteSize) {
        if (Objects.isNull(byteSize)) {
            return null;
        }
        double oneMegabyte = 1_048_576D;
        double megabyteSize = (Long.parseLong(byteSize) / oneMegabyte);

        String result;

        if (megabyteSize < 1) {
            double oneKilobyte = 128;
            result = String.format("%.2f", (Long.parseLong(byteSize) / oneKilobyte)) + " Kb";
        } else {
            result = String.format("%.2f", megabyteSize) + " Mb";
        }
        return result;
    }
}
