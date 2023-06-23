package com.BancoDeDados.Model.Funcionario;

import jakarta.persistence.*;

@Entity
@Table(name="professor")
public class Professor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "idprofessor",length = 11)
    private int idprofessor;
    @Column(name="nome",length = 50)
    private String nome;
    @Column(name="email",length = 100)
    private String email;
    public int getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(int idprofessor) {
        this.idprofessor = idprofessor;
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

}
