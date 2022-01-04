package gerenciamentoProfessores;

import java.time.LocalDate;

public class Assunto {

    private String descricao;

    private int duracao;

    private LocalDate dataInicio;

    private LocalDate dataFinal;

    public Assunto(String descricao, int duracao, LocalDate dataInicio, LocalDate dataFinal) {
        this.descricao = descricao;
        this.duracao = duracao;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }
}
