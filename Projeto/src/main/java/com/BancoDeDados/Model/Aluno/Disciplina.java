package com.BancoDeDados.Model.Aluno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;
@Entity
@Table(name="disciplina")
public class Disciplina {
    @Id
    @Column(name= "iddisciplina",length = 11)
    private int IdDisciplina;
    @Column(name= "descricao",length = 50)
    private String descricao;
    @Column(name= "carga_horaria",length = 11)
    private Integer cargaHoraria;
    @Column(name= "fk_idprofessor",length = 11)
    private Integer fk_IdProfessor;
    @Column(name= "fk_idcurso",length = 11)
    private Integer fk_IdCurso;
    public int getIdDisciplina() {
        return IdDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        IdDisciplina = idDisciplina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getFk_IdProfessor() {
        return fk_IdProfessor;
    }

    public void setFk_IdProfessor(Integer fk_IdProfessor) {
        this.fk_IdProfessor = fk_IdProfessor;
    }

    public Integer getFk_IdCurso() {
        return fk_IdCurso;
    }

    public void setFk_IdCurso(Integer fk_IdCurso) {
        this.fk_IdCurso = fk_IdCurso;
    }
}
