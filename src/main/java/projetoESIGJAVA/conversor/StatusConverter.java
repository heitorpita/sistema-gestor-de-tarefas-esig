package projetoESIGJAVA.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import projetoESIGJAVA.enums.Status;

@FacesConverter("statusConverter")
public class StatusConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            int codigo = Integer.parseInt(value);
            return Status.valueOf(codigo);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        Status status = (Status) value;
        return String.valueOf(status.getCodigo());
    }
}