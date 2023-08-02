package ai.ecma.school.enums;


import ai.ecma.school.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * {@link Group} LARNING HOLATLARI (STATUS)
 *
 * @author Muhammad Mo'minov
 * @since 06.11.2021
 */
@Getter
@AllArgsConstructor
public enum GroupStatusEnum {
    /**
     * GURUH BIRINCHI OCHILGAN HOLAT
     */
    CREATED("#FFD700", 1D),

    /**
     * GURUHNING DARSLARI BOSHLANGAN
     */
    STARTED("#FF0000", 2D),

    /**
     * GURUHNING DARSLARI QAYSIDIR SABAB BILAN TO'XTATILGAN. MASALAN KARANTIN BO'LIB QOLGAN
     */
    SUSPENDED("#0000FF", 3D),

    /**
     * GURUHNING DARSLARI TUGAGAN (TALABALAR BITIRGAN)
     */
    COMPLETED(" #00FF00", 4D),

    ARCHIVE("", 5D);

    private final String colorCode;
    private final Double orderIndex;
}
