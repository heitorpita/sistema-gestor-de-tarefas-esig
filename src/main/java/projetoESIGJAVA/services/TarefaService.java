package projetoESIGJAVA.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projetoESIGJAVA.dao.GenericDao;
import projetoESIGJAVA.dto.FormsConsultaTarefa;
import projetoESIGJAVA.entities.Tarefa;

public class TarefaService implements PrincipalService<Tarefa>, Serializable {
    private static final long serialVersionUID = 1L;

    private GenericDao<Tarefa> dao;

    public TarefaService() {
        dao = new GenericDao<Tarefa>();
    }

    @Override
    public Tarefa buscarId(Long id) {
        return dao.buscarId(Tarefa.class, id);
    }

    @Override
    public void salvar(Tarefa t) {
        dao.salvar(t);
    }

    @Override
    public void remover(Tarefa t) {
        dao.remover(Tarefa.class, t.getId());
    }

    public List<Tarefa> buscarTodos(FormsConsultaTarefa form) {
        List<Tarefa> resultado = new ArrayList<Tarefa>();
        StringBuilder hql = new StringBuilder("select t from Tarefa t where 1=1");
        if (form.getNumero() != null && form.getNumero() != 0) {
            hql.append(String.format(" and t.id = %d", form.getNumero()));
        }
        if (form.getTitulo() != null && !form.getTitulo().isEmpty()) {
            String titulo = "%" + form.getTitulo().toLowerCase() + "%";
            hql.append(String.format(" and (lower(t.titulo) like '%s' or lower(t.descricao) like '%s')", titulo, titulo));
        }
        if (form.getUser() != null && form.getUser().getId() != null) {
            hql.append(String.format(" and t.user.id = %d", form.getUser().getId()));
        }
        if (form.getSitu() != null) {
            hql.append(String.format(" and t.status like '%s'", form.getSitu().toString()));
        }
        hql.append(" order by t.id");
        resultado = dao.buscarTodos(hql.toString());
        return resultado;
    }
}