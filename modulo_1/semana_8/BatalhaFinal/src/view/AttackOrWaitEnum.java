package view;

import model.DisplayEnum;

public enum  AttackOrWaitEnum implements DisplayEnum {
    ATTACK  (1, "Atacar!"),
    WAIT    (2, "Esperar");

    private final int value;
    private final String displayName;

    AttackOrWaitEnum(int value, String displayName) {
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
