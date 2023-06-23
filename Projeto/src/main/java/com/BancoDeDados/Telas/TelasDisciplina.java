package com.BancoDeDados.Telas;

import com.BancoDeDados.Model.Aluno.Disciplina;
import com.BancoDeDados.Projeto.Tela;
import com.BancoDeDados.jpa.JpaDisciplinaDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelasDisciplina implements TelaCRUD{
    private JFrame frame;
    JpaDisciplinaDAO jpaDisciplinaDAO;
    public TelasDisciplina(JFrame frame){
        this.frame = frame;
        this.jpaDisciplinaDAO= new JpaDisciplinaDAO();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(304, 400);

    }
    public void telaResultados(){
        String[] colunasTabela = new String[]{ "IdDisciplina","Descricao","Carga horária","id_professor","fk_idCurso" };
        DefaultTableModel modeloTabela = new DefaultTableModel(null,colunasTabela);
        JTable table = new JTable();
        List<Disciplina> disciplinas = jpaDisciplinaDAO.lista();
        if(disciplinas.size() > 0) {
            for (Disciplina disciplina : disciplinas) {
                Object[] rowData = { disciplina.getIdDisciplina(), disciplina.getDescricao(), disciplina.getCargaHoraria(),
                        disciplina.getFk_IdProfessor(), disciplina.getFk_IdCurso()};
                modeloTabela.addRow( rowData);
            }
        }
        table.setModel(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(table);
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(btnVoltar);
        frame.pack();
        frame.setVisible(true);
    }

    public void inserirCadastro() {
        JPanel JPainel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel JLDesc = new JLabel("Digite a descrição da disciplina: ");
        JTextField JDesc = new JTextField(20);
        JLabel JLCampo3 = new JLabel("Digite a carga horaria da disciplina: ");
        JTextField JCargaHoraria= new JTextField(20);
        JLabel JLCampo4 = new JLabel("Digite o id do professor: ");
        JTextField JID_professor = new JTextField(20);
        JLabel JLCampo5 = new JLabel("Digite o id do Curso: ");
        JTextField txtIdCurso = new JTextField(20);
        JButton BTNCadastro = new JButton("Cadastro");
        JButton BTNVoltar = new JButton("Voltar");
        JPainel.add(JLDesc);
        JPainel.add(JDesc);
        JPainel.add(JLCampo3);
        JPainel.add(JCargaHoraria);
        JPainel.add(JLCampo4);
        JPainel.add(JID_professor);
        JPainel.add(JLCampo5);
        JPainel.add(txtIdCurso);
        JPainel.add(BTNCadastro);
        JPainel.add(BTNVoltar);

        frame.setContentPane(JPainel);
        frame.setVisible(true);

        BTNCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Disciplina disciplina = new Disciplina();
                disciplina.setDescricao(JDesc.getText());
                disciplina.setCargaHoraria(Integer.parseInt(JCargaHoraria.getText()));
                disciplina.setFk_IdProfessor(Integer.parseInt(JID_professor.getText()));
                disciplina.setFk_IdCurso(Integer.parseInt(txtIdCurso.getText()));
                jpaDisciplinaDAO.adiciona(disciplina);
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
        JLabel JLIdDisc = new JLabel("Digite o ID da disciplina: ");
        JTextField JIdDisc = new JTextField(20);
        JLabel JLDesc = new JLabel("Digite a descrição da disciplina: ");
        JTextField JDesc = new JTextField(20);
        JLabel JLCampo3 = new JLabel("Digite a carga horaria da disciplina: ");
        JTextField JCargaHoraria= new JTextField(20);
        JLabel JLCampo4 = new JLabel("Digite o id do professor: ");
        JTextField JID_professor = new JTextField(20);
        JLabel JLCampo5 = new JLabel("Digite o id do Curso: ");
        JTextField txtIdCurso = new JTextField(20);
        JButton BTNAcao = new JButton("Atualizar");
        JButton BTNVoltar = new JButton("Voltar");
        JPainel.add(JLIdDisc);
        JPainel.add(JIdDisc);
        JPainel.add(JLDesc);
        JPainel.add(JDesc);
        JPainel.add(JLCampo3);
        JPainel.add(JCargaHoraria);
        JPainel.add(JLCampo4);
        JPainel.add(JID_professor);
        JPainel.add(JLCampo5);
        JPainel.add(txtIdCurso);
        JPainel.add(BTNAcao);
        JPainel.add(BTNVoltar);

        frame.setContentPane(JPainel);
        frame.setVisible(true);

        BTNAcao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Disciplina disciplina = new Disciplina();
                disciplina.setIdDisciplina(Integer.parseInt(JIdDisc.getText()));
                disciplina.setDescricao(JDesc.getText());
                disciplina.setCargaHoraria(Integer.parseInt(JCargaHoraria.getText()));
                disciplina.setFk_IdProfessor(Integer.parseInt(JID_professor.getText()));
                disciplina.setFk_IdCurso(Integer.parseInt(txtIdCurso.getText()));
                jpaDisciplinaDAO.altera(disciplina);
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
                Disciplina disciplina = new Disciplina();
                disciplina.setIdDisciplina(id);
                jpaDisciplinaDAO.remove(disciplina);

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
