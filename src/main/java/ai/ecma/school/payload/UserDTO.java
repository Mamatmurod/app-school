package ai.ecma.school.payload;

import ai.ecma.school.enums.authEnums.PermissionEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.ObjectUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Muhammad Mo'minov
 * 06.11.2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO implements Serializable {
    private UUID id;

    private String firstName;

    private String lastName;

    private String patron;

    private String fullName;

    private String phoneNumber;

    private List<String> permissions;

    private boolean enabled;

    private String photoUrl;

    private String photoId;
    private boolean isAdmin;

    private Date birthDate;

    private String signature;

    public UserDTO(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserDTO(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return (ObjectUtils.defaultIfNull(firstName, "") + " " + ObjectUtils.defaultIfNull(lastName, "")).trim();
    }


    public boolean havePermission(PermissionEnum permission) {
        return permissions != null && permissions.contains(permission.name());
    }
}
