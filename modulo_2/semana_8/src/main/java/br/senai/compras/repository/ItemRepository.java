package br.senai.compras.repository;

import br.senai.compras.model.Item;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ApplicationScoped
public class ItemRepository {

    private List<Item> itens = new ArrayList<>();
    private long idAtual = 0;

    public List<Item> listItens() {
        return itens;
    }

    public void add(Item itemNovo) {
        Long nextId = nextId();
        itemNovo.setId(nextId);
        itens.add(itemNovo);
    }

    public void remove(long id) {
        itens.removeIf(item -> item.getId() == id);
    }

    private Long nextId() {
        return ++idAtual;
    }

    public boolean existe(String nome) {
        return itens.stream().anyMatch(i -> i.getNome().toLowerCase(Locale.ROOT) == nome.toLowerCase(Locale.ROOT));
    }
}
