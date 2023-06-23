package com.BancoDeDados.Model.Funcionario;
public class Funcionario {
    private int IdFuncionario;
    private String Nome;
    private String funcao;
    private String Telefone;
    public int getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        IdFuncionario = idFuncionario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }
}
