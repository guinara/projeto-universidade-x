package com.BancoDeDados.Projeto;

import com.BancoDeDados.Model.Aluno.Aluno;
import com.BancoDeDados.Telas.*;
import com.BancoDeDados.jpa.JpaAlunoDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Tela {
    JFrame frame;
    public Tela(JFrame frame){
        this.frame=frame;
    }
    boolean aberta=true;
    public void menuPrincipal() {
            JPanel jPanelMenu = new JPanel();
            jPanelMenu.setLayout(new BoxLayout(jPanelMenu, BoxLayout.Y_AXIS));
            jPanelMenu.setBorder(BorderFactory.createTitledBorder("Principal"));
            JButton btnCurso = new JButton("Cursos e Alunos");
            JButton btnFuncionarios = new JButton("Funcionarios");
            JButton btnFinanceiro = new JButton("Financeiro");
            btnCurso.setPreferredSize(new Dimension(40, 40));
            btnFuncionarios.setPreferredSize(new Dimension(40, 40));
            btnFinanceiro.setPreferredSize(new Dimension(40, 40));
            JLabel jlabel=new JLabel("Escolha a opção:");
            jlabel.setFont(new Font("Serif", Font.BOLD, 24));
            jPanelMenu.add(jlabel);
            btnCurso.setFont(new Font("Verdana",Font.BOLD, 24));
            jPanelMenu.add(Box.createHorizontalStrut(10));
            jPanelMenu.add(btnCurso);
            btnFuncionarios.setFont(new Font("Verdana",Font.BOLD, 24));
            jPanelMenu.add(Box.createHorizontalStrut(10));
            jPanelMenu.add(btnFuncionarios);
            btnFinanceiro.setFont(new Font("Verdana",Font.BOLD, 24));
            jPanelMenu.add(Box.createHorizontalStrut(10));
            jPanelMenu.add(btnFinanceiro);
            frame.setContentPane(jPanelMenu);
            frame.setVisible(true);
        btnCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cursos();
            }
        });
        btnFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionarios();
            }
        });
        btnFinanceiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                financeiro();
            }
        });

    }
    public void cursos(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBorder(BorderFactory.createTitledBorder("Cursos"));
        JButton btnAlunos = new JButton("Alunos");
        JButton btnDisciplinas = new JButton("Disciplinas");
        JButton btnProfessores = new JButton("Professores");
        JButton btnVoltar = new JButton("Voltar");
        JLabel jlabel=new JLabel("Escolha a opção:",JLabel.CENTER);
        jlabel.setFont(new Font("Verdana", Font.BOLD, 24));
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(jlabel);
        btnAlunos.setFont(new Font("Verdana", Font.BOLD, 24));
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(btnAlunos);
        btnDisciplinas.setFont(new Font("Verdana", Font.BOLD, 24));
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(btnDisciplinas);
        btnProfessores.setFont(new Font("Verdana", Font.BOLD, 24));
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(btnProfessores);
        btnVoltar.setFont(new Font("Verdana", Font.BOLD, 24));
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(btnVoltar);
        frame.setContentPane(jPanel);
        frame.setVisible(true);
        btnAlunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alunos();
            }
        });
        btnDisciplinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disciplinas();
            }
        });
        btnProfessores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                professores();
            }
        });
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrincipal();
            }
        });
    }
    private void alunos(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBorder(BorderFactory.createTitledBorder("Alunos"));
        TelasAluno telasAluno=new TelasAluno(frame);
        CRUD(telasAluno,jPanel);
    }


    private void disciplinas(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBorder(BorderFactory.createTitledBorder("Disciplinas"));
        TelasDisciplina telasDisciplina=new TelasDisciplina(frame);
        CRUD(telasDisciplina,jPanel);
    }
    private void CRUD(TelaCRUD telaCRUD,JPanel jPanel){
        JButton btn1 = new JButton("Resultados");
        JButton btn2 = new JButton("Inserir");
        JButton btn3 = new JButton("Alterar");
        JButton btn4 = new JButton("Deletar");
        JButton btn5 = new JButton("Voltar");
        JLabel jlabel=new JLabel("Escolha a opção:",JLabel.CENTER);
        jlabel.setFont(new Font("Verdana", Font.BOLD, 24));
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(jlabel);
        btn1.setFont(new Font("Verdana", Font.BOLD, 24));
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(btn1);
        btn2.setFont(new Font("Verdana", Font.BOLD, 24));
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(btn2);
        btn3.setFont(new Font("Verdana", Font.BOLD, 24));
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(btn3);
        btn4.setFont(new Font("Verdana", Font.BOLD, 24));
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(btn4);
        btn5.setFont(new Font("Verdana", Font.BOLD, 24));
        jPanel.add(Box.createHorizontalStrut(10));
        jPanel.add(btn5);
        frame.setContentPane(jPanel);
        frame.setVisible(true);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel.removeAll();
                telaCRUD.telaResultados();
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel.removeAll();
                telaCRUD.inserirCadastro();
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel.removeAll();
                telaCRUD.telaAtualizar();
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel.removeAll();
                telaCRUD.deletarCadastro();
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               cursos();
            }
        });
    }
    private void professores(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBorder(BorderFactory.createTitledBorder("Professores"));
        TelaProfessor telaProfessor=new TelaProfessor(frame);
        CRUD(telaProfessor,jPanel);
    }

    private void funcionarios(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBorder(BorderFactory.createTitledBorder("Funcionarios"));
        TelaProfessor telaProfessor=new TelaProfessor(frame);
        CRUD(telaProfessor,jPanel);
    }
    private void financeiro() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBorder(BorderFactory.createTitledBorder("Financeiro"));
        TelaFinanceira telaFinanceira=new TelaFinanceira(frame);
        CRUD(telaFinanceira,jPanel);
    }
}
