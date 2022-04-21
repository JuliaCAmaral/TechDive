package br.senai.compras.bean;

import br.senai.compras.model.Item;
import br.senai.compras.repository.ItemRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class ItemBean implements Serializable {

    @Inject
    private ItemRepository itemRepo;

    private Item item = new Item();

    public String salvar() {
        boolean isItemNovo = item.getId() == null;
        if (isItemNovo) {
            boolean jaCadastrado = itemRepo.existe(item.getNome());
            if (jaCadastrado) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Erro de validação", "Item já cadastrado."));
                return null;
            }
            itemRepo.add(item);
        }
        item = new Item();
        return "listagem?faces-redirect=true";
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
