package model;

public class Armadilha implements Attacker {

    private int pontosDeAtaque;
    private WeaponEnum enumArma;

    public Armadilha() {
        this.pontosDeAtaque = 5;
        this.enumArma = WeaponEnum.TRAP;
    }

    @Override
    public void attack(Character character) {

    }
}
