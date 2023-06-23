package com.BancoDeDados.Model.Aluno;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name="endereco")
public class Endereco {
    @Id
    private int IdEndereco;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private int IdAluno;
}
