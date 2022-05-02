package br.senai.cadastrocursos.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Cursos {

    private String codigo;
    private LocalDate dataDeInicio;
    private LocalDate dataDeFim;

    @Override
    public String toString() {
        return String.format("CURSO: Código: %s - Data de Início: %s - Data de Fim: %s.",
                codigo, dataDeInicio, dataDeFim);
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
}
