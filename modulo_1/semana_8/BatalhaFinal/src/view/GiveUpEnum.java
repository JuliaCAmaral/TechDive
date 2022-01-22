package view;

import model.DisplayEnum;

public enum  GiveUpEnum implements DisplayEnum {
    NO  (1, "Irei atacar!"),
    YES (2, "Irei fugir.");

    private final int value;
    private final String displayName;

    GiveUpEnum(int value, String displayName) {
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
