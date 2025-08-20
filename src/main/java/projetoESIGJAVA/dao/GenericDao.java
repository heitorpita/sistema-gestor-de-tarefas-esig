package projetoESIGJAVA.dao;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import projetoESIGJAVA.connection.ConnectionFactory;
import projetoESIGJAVA.entities.Principal;
import projetoESIGJAVA.utils.Message;

public class GenericDao <T extends Principal> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static EntityManager manager;

    public GenericDao() {
        manager = ConnectionFactory.getEntityManager();
    }

    public T buscarId(Class<T> clazz, Long id) {
        return manager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List <T> buscarTodos(String hq1) {
        return manager.createQuery(hq1).getResultList();
    }

    public void salvar(T entidade) {
        try {
            manager.getTransaction().begin();
            if(entidade.getId() == null) {
                manager.persist(entidade);
            } else {
                manager.merge(entidade);
            }
            Message.info("Operação realizada com sucesso!");
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
    }

    public void remover(Class<T> clazz, Long id) {


        T t = buscarId(clazz, id);
        try {
            manager.getTransaction().begin();
            manager.remove(t);
            Message.info("Excluido com sucesso!");
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }


    }











}

