package view;

import model.DisplayEnum;

public enum  WalkingModeEnum implements DisplayEnum {
    CAREFULLY   (1, "Andando cuidadosamente"),
    RUNNING     (2, "Correndo"),
    JUMPING     (3, "Saltando");

    private final int value;
    private final String displayName;

    WalkingModeEnum(int value, String displayName) {
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
