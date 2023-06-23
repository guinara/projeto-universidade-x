package com.BancoDeDados.Telas;

import com.BancoDeDados.Model.Aluno.Aluno;
import com.BancoDeDados.Model.Aluno.Disciplina;
import com.BancoDeDados.Projeto.Tela;
import com.BancoDeDados.jpa.JpaAlunoDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
public class TelasAluno implements TelaCRUD{
    private JFrame frame;

    JpaAlunoDao jpaAlunoDao;
    public TelasAluno(JFrame frame){
        this.frame = frame;
        this.jpaAlunoDao= new JpaAlunoDao();
        frame.setSize(255, 400);
        frame.setVisible(true);
    }
    public void telaResultados(){
        String[] colunasTabela = new String[]{ "IdAluno", "nome","Email","cpf","nascimento","sexo","situacao" };
        DefaultTableModel modeloTabela = new DefaultTableModel(null,colunasTabela);
        JTable table = new JTable();
        List<Aluno> alunos= jpaAlunoDao.lista();
        if(alunos.size() > 0) {
            for (Aluno aluno : alunos) {
                Object[] rowData = { aluno.getIdAluno(), aluno.getNome(),aluno.getEmail(),aluno.getCpf() ,aluno.getNascimento(),aluno.getSexo(),aluno.getAtivo_sn()};
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

    public void telaAtualizar() {
        JPanel JPDataNasc=new JPanel(new GridLayout(3,1));
        JPanel JPID=new JPanel(new GridLayout(3,1));
        JPanel JPCPF=new JPanel(new GridLayout(3,1));
        JPanel JPNome= new JPanel(new GridLayout(3,1));
        JPanel JPSitu=new JPanel(new GridLayout(3,1));
        JPanel JPSexo=new JPanel(new GridLayout(3,1));
        JPanel JPBotoes=new JPanel(new GridLayout(2,1));
        JPanel JPANEL = new JPanel(new GridLayout(4, 2));
        JLabel JLIdAluno = new JLabel("Digite o ID do Aluno: ");
        JTextField JIdAluno = new JTextField();
        JLabel JLNome = new JLabel("Digite o nome do Aluno: ");
        JTextField JNome = new JTextField();
        JLabel JLCpf = new JLabel("Digite o CPF do Aluno: ");
        JTextField JCpf = new JTextField();
        JTextField JEMAIL = new JTextField();
        JLabel JLDataNasc = new JLabel("Digite a data de nascimento do Aluno: ");
        JTextField JDataNasc= new JTextField();
        JLabel JLSexo = new JLabel("Digite o sexo do Aluno: ");
        JTextField JSexo = new JTextField();
        JLabel JLSituacao = new JLabel("Digite a situação do Aluno: ");
        JTextField JSituacao = new JTextField();
        JButton BTNCadastro = new JButton("Alterar");
        JButton BTNVoltar = new JButton("Voltar");
        JPID.add(JLIdAluno);
        JPID.add(JIdAluno);
        JPNome.add(JLNome);
        JPNome.add(JNome);
        JPCPF.add(JLCpf);
        JPCPF.add(JCpf);
        JPCPF.add(new JLabel("Email"));
        JPCPF.add(JEMAIL);
        JPDataNasc.add(JLDataNasc);
        JPDataNasc.add(JDataNasc);
        JPSexo.add(JLSexo);
        JPSexo.add(JSexo);
        JPSitu.add(JLSituacao);
        JPSitu.add(JSituacao);

        JPBotoes.add(BTNCadastro);
        JPBotoes.add(BTNVoltar);

        JPANEL.add(JPID);
        JPANEL.add(JPNome);
        JPANEL.add(JPCPF);
        JPANEL.add(JPDataNasc);
        JPANEL.add(JPSexo);
        JPANEL.add(JPSitu);
        JPANEL.add(JPBotoes);
        frame.setContentPane(JPANEL);
        frame.setVisible(true);

        BTNCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno aluno = new Aluno();
                aluno.setIdAluno(Integer.parseInt(JIdAluno.getText()));
                aluno.setCpf(JCpf.getText());
                aluno.setNome(JNome.getText());
                aluno.setSexo(JSexo.getText());
                aluno.setEmail(JEMAIL.getText());
                aluno.setAtivo_sn(Integer.parseInt(JSituacao.getText()));
                String dateString = JDataNasc.getText();
                //"yyyy-mm-dd" formatp esperado
                // Convertendo a string para java.sql.Date
                Date date = Date.valueOf(dateString);
                aluno.setNascimento(date);
                aluno.setSexo(JSexo.getText());
                jpaAlunoDao.altera(aluno);
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

    public void inserirCadastro() {
        JPanel JPDataNasc=new JPanel(new GridLayout(3,1));
        JPanel JPCPF=new JPanel(new GridLayout(3,1));
        JPanel JPNome= new JPanel(new GridLayout(3,1));
        JPanel JPSitu=new JPanel(new GridLayout(3,1));
        JPanel JPSexo=new JPanel(new GridLayout(3,1));
        JPanel JPBotoes=new JPanel(new GridLayout(2,1));
        JPanel JPANEL = new JPanel(new GridLayout(4, 2));
        JLabel JLNome = new JLabel("Digite o nome do Aluno: ");
        JTextField JNome = new JTextField();
        JLabel JLCpf = new JLabel("Digite o CPF do Aluno: ");
        JTextField JCpf = new JTextField();
        JTextField JEMAIL = new JTextField();
        JLabel JLDataNasc = new JLabel("Digite a data de nascimento do Aluno: ");
        JTextField JDataNasc= new JTextField();
        JLabel JLSexo = new JLabel("Digite o sexo do Aluno: ");
        JTextField JSexo = new JTextField();
        JLabel JLSituacao = new JLabel("Digite a situação do Aluno: ");
        JTextField JSituacao = new JTextField();
        JButton BTNCadastro = new JButton("Cadastro");
        JButton BTNVoltar = new JButton("Voltar");
        JPNome.add(JLNome);
        JPNome.add(JNome);
        JPCPF.add(JLCpf);
        JPCPF.add(JCpf);
        JPCPF.add(new JLabel("Email:"));
        JPCPF.add(JEMAIL);
        JPDataNasc.add(JLDataNasc);
        JPDataNasc.add(JDataNasc);
        JPSexo.add(JLSexo);
        JPSexo.add(JSexo);
        JPSitu.add(JLSituacao);
        JPSitu.add(JSituacao);

        JPBotoes.add(BTNCadastro);
        JPBotoes.add(BTNVoltar);

        JPANEL.add(JPNome);
        JPANEL.add(JPCPF);
        JPANEL.add(JPDataNasc);
        JPANEL.add(JPSexo);
        JPANEL.add(JPSitu);
        JPANEL.add(JPBotoes);
        frame.setContentPane(JPANEL);
        frame.setVisible(true);
        BTNCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JpaAlunoDao jpaAlunoDao= new JpaAlunoDao();
                Aluno aluno = new Aluno();
                //aluno.setIdAluno(Integer.parseInt(JIdAluno.getText()));
                aluno.setCpf(JCpf.getText());
                aluno.setNome(JNome.getText());
                aluno.setSexo(JSexo.getText());
                aluno.setEmail(JEMAIL.getText());
                aluno.setAtivo_sn(Integer.parseInt(JSituacao.getText()));
                String dateString = JDataNasc.getText();
                //"yyyy-mm-dd" formatp esperado
                // Convertendo a string para java.sql.Date
                Date date = Date.valueOf(dateString);
                aluno.setNascimento(date);
                aluno.setSexo(JSexo.getText());
                // Call your method here
                jpaAlunoDao.adiciona(aluno);
                JOptionPane.showMessageDialog(frame,"Cadastro efetuado!");
            }
        });
        BTNVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        frame.setVisible(true);
    }

    public void deletarCadastro() {
        JPanel PainelDeleta = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lbIDDELETAR = new JLabel("ID para deletar:");
        JTextField textField1 = new JTextField(20);
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

//            AlunoCurso alunoCurso = new AlunoCurso();
//            alunoCurso.setIdAluno(id);
//            jpaAlunoCursoDao.remove(alunoCurso);

                Aluno aluno = new Aluno();
                aluno.setIdAluno(id);
                jpaAlunoDao.remove(aluno);

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
