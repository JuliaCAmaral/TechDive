package br.senai.compras.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Item {

    private Long id;

    @NotNull(message = "{campo.obrigatorio}")
    @Size(min = 2, max = 100, message = "{campo.invalido.tamanho}")
    private String nome;

    @NotNull(message = "{campo.obrigatorio}")
    private Double quantidade;

    @NotNull(message = "{campo.obrigatorio}")
    private String unidade;

    public Item() {}

    public Item(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getDescricao() {
        return String.format("%.1f %s(s) de %s", quantidade, unidade, nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
