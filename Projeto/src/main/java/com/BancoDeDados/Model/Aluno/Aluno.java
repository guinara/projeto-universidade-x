package com.BancoDeDados.Model.Aluno;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="aluno")
public class Aluno implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "idaluno",length = 11)
    private int IdAluno;
    @Column(name="nome",length = 25)
    private String nome;
    @Column(name="cpf",length = 14)
    private String cpf;
    @Column(name="data_nascimento")
    private Date data_nascimento;
    @Column(name="sexo",length = 1)
    private String sexo;
    @Column(name="ativo_sn",length = 11)
    private int ativo_sn;



    @Column(name="email",length = 150)
    private String email;
/*
    @OneToMany
    @JoinColumn(name = "fk_idaluno",referencedColumnName = "idaluno")
    private Aluno aluno;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy="aluno")
    private Set<Aluno_Curso> aluno_cursos;
*/
    public int getIdAluno() {
        return IdAluno;
    }

    public void setIdAluno(int idAluno) {
        IdAluno = idAluno;
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
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return data_nascimento;
    }

    public void setNascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getAtivo_sn() {
        return ativo_sn;
    }

    public void setAtivo_sn(int ativo_sn) {
        this.ativo_sn = ativo_sn;
    }

}
