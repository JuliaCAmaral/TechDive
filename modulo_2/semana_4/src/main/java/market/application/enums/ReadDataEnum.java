package market.application.enums;

public enum ReadDataEnum implements DisplayEnum {

    ALL         (1, "Listar todos"),
    BY_NAME     (2, "Busca específica");

    private final int value;
    private final String displayName;

    ReadDataEnum(int value, String displayName) {
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
