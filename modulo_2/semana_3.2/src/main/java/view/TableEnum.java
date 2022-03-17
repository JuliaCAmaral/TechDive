package view;

public enum  TableEnum implements DisplayEnum {

    MANUFACTURER    (1, "Fornecedor"),
    CATEGORY        (2, "Categoria"),
    PRODUCT         (3, "Produto");

    private final int value;
    private final String displayName;

    TableEnum(int value, String displayName) {
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
