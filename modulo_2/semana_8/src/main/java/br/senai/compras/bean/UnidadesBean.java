package br.senai.compras.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UnidadesBean implements Serializable {

    private final String[] unidades = new String[]{
            "Unidades",
            "Kg",
            "Litros",
            "Garrafas",
            "Pacotes"
    };

    public String[] getUnidades() {
        return unidades;
    }
}
