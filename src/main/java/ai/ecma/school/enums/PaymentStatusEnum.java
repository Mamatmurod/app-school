package ai.ecma.school.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentStatusEnum {
    PENDING("PENDING"),
    PAID("PAID"),
    REJECTED("REJECTED");

    private final String value;
}
