package br.senai.compras.bean;

import br.senai.compras.model.Item;
import br.senai.compras.repository.ItemRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ListagemBean implements Serializable {

    @Inject
    private ItemRepository itemRepo;

    private List<Item> itens = new ArrayList<>();

    private List<Item> itensSelected = new ArrayList<>();

    public void onload() {
        List<Item> itensBanco = itemRepo.listItens();
        itens = itensBanco;
    }

    public void remove() {
        for (Item item : itensSelected) {
            itemRepo.remove(item.getId());
        }
        this.itens = itemRepo.listItens();
    }

    public List<Item> getItens() {
        return itens;
    }

    public List<Item> getItensSelected() {
        return itensSelected;
    }

    public void setItensSelected(List<Item> itensSelected) {
        this.itensSelected = itensSelected;
    }
}
