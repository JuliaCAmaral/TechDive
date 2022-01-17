package view;

import model.DisplayEnum;

public enum CharacterEnum implements DisplayEnum {
    WARRIOR (1, "Guerreiro"),
    PALADIN (2, "Paladino"),
    BOWMAN  (3, "Arqueiro"),
    DRUID   (4, "Mago");

    private final int value;
    private final String displayName;


    CharacterEnum(int value, String displayName) {
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
