package com.BancoDeDados.Model.Aluno;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
@org.springframework.data.relational.core.mapping.Table(name="aluno_curso")
public class AlunoCurso {

    @Id
    @Column(name= "fk_idaluno",length = 11)
    private int IdAluno;
    @Id
    @Column(name= "fk_idcurso",length = 11)
    private int IdCurso;
    @Column(name= "data_inscricao_curso")
    private Date dataInscricao;
    @Column(name= "valor_pago_curso",length = 11)
    private double valorPago;
    public int getIdAluno() {
        return IdAluno;
    }

    public void setIdAluno(int idAluno) {
        IdAluno = idAluno;
    }

    public int getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(int idCurso) {
        IdCurso = idCurso;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

/*
    @ManyToOne
    @JoinColumn(name = "fk_idaluno",referencedColumnName = "idaluno")
    private Curso curso;
*/
}

