package ai.ecma.school.enums;

public enum ImportTypeEnum {
    AMOCRM("Amocrm"),
    MANUAL("Manual");

    private String name;

    public String getName() {
        return name;
    }

    ImportTypeEnum(String name) {
        this.name = name;
    }
}
