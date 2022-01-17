package view;

import model.DisplayEnum;

public enum  YesNoEnum implements DisplayEnum {
    YES (1, "Sim"),
    NO  (2, "Não");

    private final int value;
    private final String displayName;

    YesNoEnum(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public int getValue(){
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }
}
