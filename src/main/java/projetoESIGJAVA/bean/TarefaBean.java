package projetoESIGJAVA.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import projetoESIGJAVA.entities.User;
import projetoESIGJAVA.entities.Tarefa;
import projetoESIGJAVA.dto.FormsConsultaTarefa;
import projetoESIGJAVA.enums.Prioridade;
import projetoESIGJAVA.enums.Status;
import projetoESIGJAVA.services.UserService;
import projetoESIGJAVA.services.TarefaService;

@ManagedBean
@SessionScoped
public class TarefaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Tarefa tarefa;
    private FormsConsultaTarefa formConsulta;
    private List<Tarefa> listaTarefas;

    private transient TarefaService tarefaService;
    private transient UserService userService;

    @PostConstruct
    public void init() {
        tarefa = new Tarefa();
        tarefaService = new TarefaService();
        userService = new UserService();
        formConsulta = new FormsConsultaTarefa();
        listaTarefas = tarefaService.buscarTodos(formConsulta);
    }

    public String cadastrar() {
        tarefaService.salvar(tarefa);
        carregarTarefas();
        limpar();
        return "";
    }

    public String listar() {
        listaTarefas = tarefaService.buscarTodos(formConsulta);
        limpar();
        return "";
    }

    public String editar(Tarefa t) {
        this.tarefa = t;
        return "formTarefa.jsf";
    }

    public String concluir(Tarefa t) {
        t.setStatus(Status.CONCLUIDO);
        tarefaService.salvar(t);
        return "";
    }

    public String remover(Tarefa t) {
        tarefaService.remover(t);
        carregarTarefas();
        return "";
    }

    private void carregarTarefas() {
        listaTarefas = tarefaService.buscarTodos(formConsulta);
    }

    public List<SelectItem> getComboNiveisPrioridade() {
        List<SelectItem> itensComboNiveisPrioridade = new ArrayList<>();
        for (Prioridade p : Prioridade.values()) {
            boolean isSelecionado = tarefa.getPrioridade() == p;
            itensComboNiveisPrioridade.add(new SelectItem(p, p.name(), null, isSelecionado));
        }
        return itensComboNiveisPrioridade;
    }

    public List<SelectItem> getNiveisStatus() {
        List<SelectItem> niveisStatus = new ArrayList<>();
        for (Status s : Status.values()) {
            niveisStatus.add(new SelectItem(s, s.name()));
        }
        return niveisStatus;
    }

    public List<SelectItem> getComboResponsaveis() {
        List<SelectItem> itensComboBoxResponsaveis = new ArrayList<>();
        List<User> responsaveis = userService.buscarTodos();
        for (User u : responsaveis) {
            boolean isSelecionado = tarefa.getUser() != null && tarefa.getUser().getId() != null
                    && tarefa.getUser().equals(u);
            itensComboBoxResponsaveis.add(new SelectItem(u, u.getNome(), null, isSelecionado));
        }
        return itensComboBoxResponsaveis;
    }

    private void limpar() {
        tarefa = new Tarefa();
        formConsulta = new FormsConsultaTarefa();
    }

    // Getters and Setters

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public FormsConsultaTarefa getFormConsulta() {
        return formConsulta;
    }

    public void setFormConsulta(FormsConsultaTarefa formConsulta) {
        this.formConsulta = formConsulta;
    }
}