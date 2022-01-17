package model;

public class Paladin extends Player {

    private static WeaponEnum[] weapons = { WeaponEnum.HAMMER, WeaponEnum.MACE };

    public Paladin(String name, String gender, WeaponEnum weapon) {
        super(13, 18, name, gender, weapon);

        if (!(weapon == WeaponEnum.HAMMER || weapon == WeaponEnum.MACE)) {
            throw new RuntimeException("O paladino só pode usar como arma o martelo ou a clava.");
        }
    }

    public static WeaponEnum[] getWeapons(){
        return weapons;
    }
}
