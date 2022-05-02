package br.senai.cadastrocursos.modelo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class Cursos {

    @NotEmpty(message = "{campo.obrigatorio} : codigo")
    private String codigo;

    @NotEmpty(message = "{campo.obrigatorio} : nome")
    @Size(min = 2, max = 100, message = "{campo.invalido.tamanho} : nome")
    private String nome;

    @NotNull(message = "{campo.obrigatorio} : data de inicio")
    private LocalDate dataDeInicio;

    @NotNull(message = "{campo.obrigatorio} : data de fim")
    private LocalDate dataDeFim;

    public Cursos() {
    }

    public Cursos(String codigo, String nome, LocalDate dataDeInicio, LocalDate dataDeFim) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataDeInicio = dataDeInicio;
        this.dataDeFim = dataDeFim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cursos cursos = (Cursos) o;
        return Objects.equals(codigo, cursos.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(LocalDate dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public LocalDate getDataDeFim() {
        return dataDeFim;
    }

    public void setDataDeFim(LocalDate dataDeFim) {
        this.dataDeFim = dataDeFim;
    }

    @Override
    public String toString() {
        return String.format("CURSO: Código: %s - Data de Início: %s - Data de Fim: %s.",
                codigo, dataDeInicio, dataDeFim);
    }
}
