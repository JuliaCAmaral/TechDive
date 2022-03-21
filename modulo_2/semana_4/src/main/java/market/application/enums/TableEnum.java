package market.application.enums;

public enum TableEnum implements DisplayEnum {

    CLIENT      (1, "Cliente"),
    PRODUCT     (2, "Produto");

    private final int value;
    private final String displayName;

    TableEnum(int value, String displayName) {
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
