package model;

public class Warrior extends Player {

    private static WeaponEnum[] weapons = { WeaponEnum.SWORD, WeaponEnum.AXE };

    public Warrior(String name, String gender, WeaponEnum weapon) {
        super (15, 15, name, gender, weapon);

        if (!(weapon == WeaponEnum.SWORD || weapon == WeaponEnum.AXE)) {
            throw new RuntimeException("O guerreiro só pode usar como arma a espada ou o machado.");
        }
    }

    public static WeaponEnum[] getWeapons(){
        return weapons;
    }
}
