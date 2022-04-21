package br.senai.compras.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Map;

@FacesValidator("QuantidadeValidator")
public class QuantidadeValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        Map<String, Object> atributos = uiComponent.getAttributes();
        if (value == null || !(value instanceof Double) || (Double)value < 0) {
            String nomeCampo = (String) atributos.getOrDefault("nome-campo", "Campo");
            FacesMessage msg = new FacesMessage(nomeCampo + ": Valor informado é inválido", "Erro de validação");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
