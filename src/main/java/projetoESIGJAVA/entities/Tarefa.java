package projetoESIGJAVA.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import projetoESIGJAVA.enums.Status;
import projetoESIGJAVA.enums.Prioridade;

@Entity
public class Tarefa implements Principal, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "TITULO NAO PODE ESTA VAZIO")
    private String titulo;

    @NotEmpty(message = "Descrição nao pode esta vazia")
    private String descricao;


    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="id_user")
    private User user;


    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Temporal(TemporalType.DATE)
    @NotNull(message="Deadline precisa ser definido")
    private Date deadline;

    public Tarefa() {
        status = Status.EM_ANDAMENTO;
    }

    public Tarefa(Long id, String titulo, String descricao, User user, Prioridade prioridade, Status status, Date deadline) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.user = user;
        this.prioridade = prioridade;
        this.status = status;
        this.deadline = deadline;
    }

    public boolean isFinished() {
        return status == Status.CONCLUIDO;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override


    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarefa other = (Tarefa) obj;
        return Objects.equals(id, other.id);
    }


    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", responsavel=" + user
                + " , prioridade=" + prioridade + ", status=" + status + ", deadline=" + deadline + "]";
    }
}



