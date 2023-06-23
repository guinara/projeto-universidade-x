package com.BancoDeDados.Model.Aluno;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name="curso")
public class Curso {
    @Id
private int IdCurso;
private String descricao;

}
