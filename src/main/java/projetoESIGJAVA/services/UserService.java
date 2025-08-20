package projetoESIGJAVA.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projetoESIGJAVA.dao.GenericDao;
import projetoESIGJAVA.entities.User;

public class UserService implements PrincipalService<User>, Serializable {

    private static final long serialVersionUID = 1L;

    private GenericDao<User> dao;

    public UserService() {
        dao = new GenericDao<User>();
    }

    @Override
    public User buscarId(Long id) {
        return dao.buscarId(User.class, id);
    }

    @Override
    public void salvar(User user) {
        dao.salvar(user);
    }

    @Override
    public void remover(User user) {
        dao.remover(User.class, user.getId());
    }

    public List<User> buscarTodos() {
        String hql = "select u from User u order by u.nome";
        return dao.buscarTodos(hql);
    }
}