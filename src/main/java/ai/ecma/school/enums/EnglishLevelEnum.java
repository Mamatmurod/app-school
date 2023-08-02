package ai.ecma.school.enums;

import lombok.Getter;

@Getter
public enum EnglishLevelEnum {

    BEGINNER("Beginner"),
    ELEMENTARY("Elementary"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced"),
    ;

    private final String capitalize;


    EnglishLevelEnum(String capitalize) {
        this.capitalize = capitalize;
    }

    /*public static List<CustomFieldOptionDTO> getOptions() {
        return Arrays.stream(EnglishLevelEnum.values())
                .map(item -> new CustomFieldOptionDTO(
                        item.name(),
                        item.getCapitalize(),
                        "#000"
                ))
                .collect(Collectors.toList());
    }

    public static DropDown<CustomFieldOptionDTO> makeDropdown() {
        DropDown<CustomFieldOptionDTO> dropDown = new DropDown<>();
        dropDown.setOptions(getOptions());
        return dropDown;
    }

    public static DropDown<CustomFieldOptionDTO> makeDropdown(EnglishLevelEnum value) {
        DropDown<CustomFieldOptionDTO> dropDown = makeDropdown();
        if (Objects.nonNull(value))
            dropDown.setValue(value.capitalize);
        return dropDown;
    }*/
}
