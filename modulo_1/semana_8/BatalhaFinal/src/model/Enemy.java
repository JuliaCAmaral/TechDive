package model;

abstract class Enemi extends Character implements Atacante {
    public Enemi(int pontosDeSaude, int pontosDeAtaque, int pontosDeDefesa) {
        super(pontosDeSaude, pontosDeAtaque, pontosDeDefesa);
    }

    private WeaponEnum enumArma;

    @Override
    public void atacar(Character character) {

    }
}
