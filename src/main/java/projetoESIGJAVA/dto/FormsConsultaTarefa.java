package projetoESIGJAVA.dto;

import projetoESIGJAVA.entities.User;
import projetoESIGJAVA.entities.Tarefa;
import projetoESIGJAVA.enums.Status;


public class FormsConsultaTarefa {

    private Long numero;

    private String titulo;

    private User user;

    private Status situ;

    public FormsConsultaTarefa() {
    }

    public FormsConsultaTarefa(Long numero, String titulo, User user, Status situ) {
        this.numero = numero;
        this.titulo = titulo;
        this.user = user;
        this.situ = situ;

    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getSitu() {
        return situ;
    }

    public void setSitu(Status situ) {
        this.situ = situ;
    }
}
