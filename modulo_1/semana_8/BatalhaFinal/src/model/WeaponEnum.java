package model;

public enum WeaponEnum implements DisplayEnum {

    SWORD       (1, 5, "Espada",          "com a sua espada"),
    AXE         (2, 5, "Machado",         "com o seu machado"),
    HAMMER      (3, 5, "Martelo",         "com o seu martelo"),
    MACE        (4, 5, "Clava",           "com a sua clava"),
    BOW         (5, 5, "Arco",            "com o seu arco, a flecha atingiu"),
    CROSSBOW    (6, 5, "Besta",           "com a sua besta, o virote atingiu"),
    ROD         (7, 5, "Cajado",          "com o seu cajado lançando uma bola de fogo"),
    MAGIC_BOOK  (8, 5, "Livro de magias", "absorvendo a energia do livro com uma mão e liberando com a outra"),
    TRAP        (9, 2, "Armadilha",       "caindo na armadilha"),
    DOUBLE_AXE  (10, 7, "Machado duplo",  "com o seu machado duplo");

    private final int value;
    private final String displayName;
    private final int attack;
    private final String message;

    WeaponEnum(int value, int attack, String displayName, String message) {
        this.value = value;
        this.displayName = displayName;
        this.attack = attack;
        this.message = message;
    }

    public int getValue(){
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getAttack() {
        return attack;
    }

    public String getMessage() {
        return message;
    }
}

