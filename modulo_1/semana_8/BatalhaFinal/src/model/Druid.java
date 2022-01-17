package model;

public class Druid extends Player {

    private static WeaponEnum[] weapons = { WeaponEnum.ROD, WeaponEnum.MAGIC_BOOK };

    public Druid(String name, String gender, WeaponEnum weapon) {
        super(19, 11, name, gender, weapon);

        if (!(weapon == WeaponEnum.ROD || weapon == WeaponEnum.MAGIC_BOOK)) {
            throw new RuntimeException("O mago só pode usar como arma o cajado ou o livro de magias.");
        }
    }

    public static WeaponEnum[] getWeapons(){
        return weapons;
    }
}
