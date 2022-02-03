package exercicio_10;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private LocalDateTime dataHora;

    private String descricao;

    private double valor;

    public Transacao(LocalDateTime dataHora, String descricao, double valor) {
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String toString() {
        String horaFormatada = dtf.format(dataHora);

        String valorFormatado = df.format(valor);

        return horaFormatada + " " + descricao + " " + valorFormatado;
    }
}
