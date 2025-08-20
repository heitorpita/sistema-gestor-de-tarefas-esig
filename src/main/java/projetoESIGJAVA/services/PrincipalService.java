package projetoESIGJAVA.services;

public interface PrincipalService<T> {

    public T buscarId(Long id);
    public void salvar(T t);
    public void remover(T t);
}
