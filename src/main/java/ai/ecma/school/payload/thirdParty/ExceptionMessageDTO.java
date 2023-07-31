package ai.ecma.school.payload.thirdParty;


import ai.ecma.school.payload.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMessageDTO implements Serializable {
    private UserDTO user;
    private String message;
    private String serviceName;
    private String url;
}
