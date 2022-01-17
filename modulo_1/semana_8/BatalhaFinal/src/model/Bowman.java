package model;

public class Bowman extends Player {

    private static WeaponEnum[] weapons = { WeaponEnum.BOW, WeaponEnum.CROSSBOW };

    public Bowman(String name, String gender, WeaponEnum weapon) {
        super(18, 13, name, gender, weapon);

        if (!(weapon == WeaponEnum.BOW || weapon == WeaponEnum.CROSSBOW)) {
            throw new RuntimeException("O arqueiro só pode usar como arma o arco ou a besta.");
        }
    }

    public static WeaponEnum[] getWeapons(){
        return weapons;
    }
}
