package gerenciamentoProfessores;

import java.util.ArrayList;

public class Docente {

    private int identificacao;

    private String nome;

    private ArrayList<Turma> turmasAtendidas = new ArrayList<Turma>();

    public Docente(String nome) {
        this.nome = nome;
    }

    public void addTurmasAtendidas(Turma turma) {
        turmasAtendidas.add(turma);
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Turma> getTurmasAtendidas() {
        return turmasAtendidas;
    }
}
