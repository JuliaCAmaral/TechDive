package view;

import model.DisplayEnum;

public enum MenuEnum implements DisplayEnum {
    BOOK        (1, "Reservar"),
    CANCEL      (2, "Cancelar"),
    SIMULATION  (3, "Simulação"),
    EXIT        (0, "Sair");

    private final int value;
    private final String displayName;

    MenuEnum(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
