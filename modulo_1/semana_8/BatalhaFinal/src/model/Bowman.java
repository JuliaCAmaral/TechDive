package model;

public class Archer extends Jogador {
    public Archer(int pontosDeSaude, int pontosDeAtaque, int pontosDeDefesa, String nome, String sexo, EnumArma arma) {
        super(pontosDeSaude, pontosDeAtaque, pontosDeDefesa, nome, sexo, arma);

        if (!(arma == EnumArma.BOW || arma == EnumArma.CROSSBOW)) {
            throw new RuntimeException("O arqueiro só pode usar como arma o arco ou a besta.");
        }
    }



}
