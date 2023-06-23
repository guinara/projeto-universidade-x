package com.BancoDeDados.Telas;

import com.BancoDeDados.Model.Funcionario.Professor;
import com.BancoDeDados.Projeto.Tela;
import com.BancoDeDados.jpa.JpaProfessorDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaProfessor implements TelaCRUD{
    private JFrame frame;
    JpaProfessorDAO jpaProfessorDAO;
    public TelaProfessor(JFrame frame){
        this.frame = frame;
        this.jpaProfessorDAO= new JpaProfessorDAO();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(304, 400);

    }
    public void telaResultados(){
        String[] colunasTabela = new String[]{ "IdProfessor","Nome","Email" };
        DefaultTableModel modeloTabela = new DefaultTableModel(null,colunasTabela);
        JTable table = new JTable();
        List<Professor> professores= jpaProfessorDAO.lista();
        if(professores.size() > 0) {
            for (Professor professor : professores) {
                Object[] rowData = { professor.getIdprofessor(), professor.getNome(), professor.getEmail()};
                modeloTabela.addRow( rowData);
            }
        }
        table.setModel(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        JButton BTNVoltar = new JButton("Voltar");
        frame.add(BTNVoltar);
        BTNVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        frame.setVisible(true);
    }

    public void inserirCadastro() {
        JPanel JPainel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel JLCampo2 = new JLabel("Digite o nome do professor: ");
        JTextField JNOME = new JTextField(20);
        JLabel JLCampo3 = new JLabel("Digite o email do professor: ");
        JTextField JEmail= new JTextField(20);
        JButton BTNCadastro = new JButton("Cadastro");
        JButton BTNVoltar = new JButton("Voltar");
        JPainel.add(JLCampo2);
        JPainel.add(JNOME);
        JPainel.add(JLCampo3);
        JPainel.add(JEmail);
        JPainel.add(BTNCadastro);
        JPainel.add(BTNVoltar);

        frame.setContentPane(JPainel);
        frame.setVisible(true);

        BTNCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Professor professor = new Professor();
                professor.setNome(JNOME.getText());
                professor.setEmail(JEmail.getText());
                jpaProfessorDAO.adiciona(professor);
                JOptionPane.showMessageDialog(frame,"Cadastro efetuado!");
            }
        });
        BTNVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });

    }

    public void telaAtualizar() {
        JPanel JPainel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel JLCampo1 = new JLabel("Digite o id do professor: ");
        JTextField JID_professor = new JTextField(20);
        JLabel JLCampo2 = new JLabel("Digite o nome do professor: ");
        JTextField JNOME = new JTextField(20);
        JLabel JLCampo3 = new JLabel("Digite o email do professor: ");
        JTextField JEmail= new JTextField(20);
        JButton BTNCadastro = new JButton("Cadastro");
        JButton BTNVoltar = new JButton("Voltar");
        JPainel.add(JLCampo1);
        JPainel.add(JID_professor);
        JPainel.add(JLCampo2);
        JPainel.add(JNOME);
        JPainel.add(JLCampo3);
        JPainel.add(JEmail);
        JPainel.add(BTNCadastro);
        JPainel.add(BTNVoltar);

        frame.setContentPane(JPainel);
        frame.setVisible(true);

        BTNCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Professor professor = new Professor();
                professor.setIdprofessor(Integer.parseInt(JID_professor.getText()));
                professor.setNome(JNOME.getText());
                professor.setEmail(JEmail.getText());
                jpaProfessorDAO.altera(professor);
                JOptionPane.showMessageDialog(frame,"Alteração efetuada!");
            }
        });
        BTNVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });

    }

    public void deletarCadastro() {
        JPanel PainelDeleta=new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lbIDDELETAR=new JLabel("ID para deletar:");
        JTextField textField1=new JTextField(20);
        JButton BTNdeletar = new JButton("Deletar");
        JButton btnVoltar = new JButton("Voltar");
        PainelDeleta.add(lbIDDELETAR);
        PainelDeleta.add(textField1);
        PainelDeleta.add(BTNdeletar);
        PainelDeleta.add(btnVoltar);

        BTNdeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(textField1.getText());
                Professor professor = new Professor();
                professor.setIdprofessor(id);
                jpaProfessorDAO.remove(professor);

                JOptionPane.showMessageDialog(PainelDeleta,"Deletado!");
            }
        });
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        frame.setContentPane(PainelDeleta);
        frame.setVisible(true);
    }
    public void voltar(){
        Tela tela = new Tela(frame);
        tela.cursos();
        frame.pack();
    }
}
