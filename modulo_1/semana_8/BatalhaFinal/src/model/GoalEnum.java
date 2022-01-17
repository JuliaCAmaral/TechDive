package model;

public enum GoalEnum implements DisplayEnum {

    REVENGE (1,"Vingança"),
    HONOR   (2,"Glória");

    private final int value;
    private final String displayName;

    GoalEnum(int value, String displayName) {
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
