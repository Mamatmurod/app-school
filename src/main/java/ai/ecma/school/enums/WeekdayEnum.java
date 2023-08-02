package ai.ecma.school.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Getter
@AllArgsConstructor
public enum WeekdayEnum {

    MONDAY(1, "Mon", "Dushanba"),
    TUESDAY(2, "Tue", "Seshanba"),
    WEDNESDAY(3, "Wed", "Chorshanba"),
    THURSDAY(4, "Thu", "Payshanba"),
    FRIDAY(5, "Fri", "Juma"),
    SATURDAY(6, "Sat", "Shanba"),
    SUNDAY(7, "Sun", "Yakshanba");

    private final int index;
    private final String shortTitle;
    private final String fullName;

    public static LinkedList<WeekdayEnum> getCoupleOdd(WeekdayEnum now) {
        if (now.getIndex() % 2 == 0) {
            return new LinkedList<>(List.of(previousIndex(now.getIndex()), now));
        } else if (now == SUNDAY) {
            return new LinkedList<>(List.of(MONDAY, TUESDAY));
        } else {
            return new LinkedList<>(List.of(now, nextIndex(now.getIndex())));
        }
    }

    public static WeekdayEnum previousIndex(int index) {
        if (index > 7 || index < 1)
            throw new IllegalArgumentException();
        return Arrays.stream(WeekdayEnum.values()).filter(weekdayEnum -> weekdayEnum.getIndex() == index - 1).findAny().get();
    }

    public static WeekdayEnum nextIndex(int index) {
        if (index > 7 || index < 1)
            throw new IllegalArgumentException();
        return Arrays.stream(WeekdayEnum.values()).filter(weekdayEnum -> weekdayEnum.getIndex() == index + 1).findAny().get();
    }

    public static WeekdayEnum from(DayOfWeek weekday) {
        return WeekdayEnum.valueOf(weekday.name());
    }


    public boolean isEven() {
        return index % 2 == 0;
    }
}
