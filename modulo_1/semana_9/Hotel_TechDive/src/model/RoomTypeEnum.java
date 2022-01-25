package model;

public enum RoomTypeEnum implements DisplayEnum {
    STANDARD    (1, "Simples",                90,  140),
    PREMIUM     (2, "Luxo",                   150, 400),
    SUPREME     (3, "Suíte suprema",          500, 800),
    EXIT        (0, "Voltar ao menu inicial", 0,   0);

    private final int value;
    private final String displayName;
    private final double lowCost;
    private final double highCost;

    RoomTypeEnum(int value, String displayName, double lowCost, double highCost) {
        this.value = value;
        this.displayName = displayName;
        this.lowCost = lowCost;
        this.highCost = highCost;
    }

    public double getLowCost() {
        return lowCost;
    }

    public double getHighCost() {
        return highCost;
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
