package market.application.enums;

public enum CrudEnum implements DisplayEnum {

    CREATE  (1, "Salvar"),
    READ    (2, "Listar"),
    UPDATE  (3, "Atualizar"),
    DELETE  (4, "Deletar");

    private final int value;
    private final String displayName;

    CrudEnum(int value, String displayName) {
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
