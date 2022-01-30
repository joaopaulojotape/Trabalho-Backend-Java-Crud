package br.com.academify2.model;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name = "aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Length(min = 3, message = "Nome do aluno é inválido")
    @NotNull(message = "Nome do aluno é inválido")
    private String name;
    @NotBlank(message = "campo matrícula é obrigatorio")
    private String matricula;
    @Email
    private String email;
    @NotBlank(message = "campo telefone é obrigatorio")
    private String telefone;
    @CPF
    private String cpf;
    @NotBlank(message = "campo endereço é obrigatorio")
    private String endereco;
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
    @NotNull(message = "Selecione a Data de Cadastro")
    @Past(message = "Data inválida, nao pode ser uma data passada em relação a atual")
    private Date dataHoraCadastro;
    @NotNull(message = "Data de nascimento inválida")
    @Past(message = "Data de nascimento inválida, nao pode ser uma data passada em relação a atual")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


}
