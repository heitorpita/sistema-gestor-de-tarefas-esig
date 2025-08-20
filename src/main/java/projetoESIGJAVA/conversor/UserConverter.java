package projetoESIGJAVA.conversor;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import projetoESIGJAVA.entities.User;
import projetoESIGJAVA.services.UserService;

@FacesConverter("userConverter")
public class UserConverter implements Converter {

    private final UserService service;

    public UserConverter() {
        service = new UserService();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return (User) service.buscarId(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((User) value).getId().toString();
    }
}
