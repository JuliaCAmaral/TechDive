package model;

abstract class Jogador extends Personagem implements Atacante {
    public Jogador(int pontosDeSaude, int pontosDeAtaque, int pontosDeDefesa) {
        super(pontosDeSaude, pontosDeAtaque, pontosDeDefesa);
    }

    private String nome;
    private String sexo;
    private Motivacao motivacao;
    private EnumArma arma;
    private int hp;

    public Jogador(int pontosDeSaude, int pontosDeAtaque, int pontosDeDefesa, String nome, String sexo, EnumArma arma) {
        super(pontosDeSaude, pontosDeAtaque, pontosDeDefesa);

        if (!nome.isEmpty()) {
            this.nome = nome;
        }

        if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F")) {
            this.sexo = sexo;
        }
        this.arma = arma;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void atacar(Personagem personagem) {

    }
}
