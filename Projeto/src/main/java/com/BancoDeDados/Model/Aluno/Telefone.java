package com.BancoDeDados.Model.Aluno;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name="telefone")
public class Telefone {
    @Id
    private int IdTelefone;
    private String numero;
    private TipoTelefone tipo;
    private int IdAluno;
}
