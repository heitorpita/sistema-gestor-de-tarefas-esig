package projetoESIGJAVA.conversor;

import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import projetoESIGJAVA.enums.Prioridade;

@FacesConverter("prioridadeConverter")
public class PrioridadeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return Prioridade.valueOf(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Prioridade prioridade = (Prioridade) value;
        return String.valueOf(prioridade.getCodigo());
    }


}
