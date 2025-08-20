package projetoESIGJAVA.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Entity

public class User implements Principal, Serializable{

    private static final long serialVersionUID = 5124114455841775873L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min=3, max=50, message="Nome deve ter 3 a 50 letras")
    @NotBlank(message = "Nao Pode ficar vazio")
    private String nome;

    @Email(message = "email deve esta na forma correta")
    private String email;

    @NotNull(message = "Deve-se colocar a Data de Nascimento")
    private Date dataNascimento;

    public User() {}


    public User(Long id, String nome, String email, Date dataNascimento) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataNascimento, email, id, nome);
    }


    @Override


    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(email, other.email)
                && Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
    }


    @Override
    public String toString() {
        return "Responsavel [id=" + id + ", nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento
                + "]";
    }
}
