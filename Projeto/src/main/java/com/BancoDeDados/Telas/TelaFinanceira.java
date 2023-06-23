package com.BancoDeDados.Telas;

import com.BancoDeDados.Model.Financeiro.Gasto;
import com.BancoDeDados.Projeto.Tela;
import com.BancoDeDados.jpa.JpaGasto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaFinanceira implements TelaCRUD{
    private JFrame frame;
    JpaGasto jpaGastoDAO;
    public TelaFinanceira(JFrame frame){
        this.frame = frame;
        this.jpaGastoDAO= new JpaGasto();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(304, 400);

    }
    public void telaResultados(){
        String[] colunasTabela = new String[]{ "idgasto","ano","tipo","jan","fevereiro","março","abr","mai","jun",
                "julho","agosto","setembro","outubro","novembro","dezembro" };
        DefaultTableModel modeloTabela = new DefaultTableModel(null,colunasTabela);
        JTable table = new JTable();
        List<Gasto> gastos= jpaGastoDAO.lista();
        if(gastos.size() > 0) {
            for (Gasto gasto : gastos) {
                Object[] rowData = { gasto.getIdgasto(), gasto.getAno(), gasto.getJan(),gasto.getFev(),gasto.getMar(),
                        gasto.getAbr(),gasto.getMai(),gasto.getJun(),gasto.getJul(),gasto.getSet(),gasto.getOut(),
                        gasto.getNov(),gasto.getDez()};
                modeloTabela.addRow( rowData);
            }
        }
        table.setModel(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        JButton BTNVoltar = new JButton("Voltar");
        BTNVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        frame.setVisible(true);
    }

    @Override
    public void inserirCadastro() {
            JPanel JPainel=new JPanel(new FlowLayout(FlowLayout.CENTER));
            JTextField Jano = new JTextField(20);
            JTextField JID = new JTextField(20);
            JTextField txtJan = new JTextField(20);
            JTextField txtFev = new JTextField(20);
            JTextField txtMar = new JTextField(20);
            JTextField txtAbr = new JTextField(20);
            JTextField txtMai = new JTextField(20);
            JTextField txtJun = new JTextField(20);
            JTextField txtJul = new JTextField(20);
            JTextField txtAgo = new JTextField(20);
            JTextField txtSet = new JTextField(20);
            JTextField txtOut = new JTextField(20);
            JTextField txtNov = new JTextField(20);
            JTextField txtDez = new JTextField(20);
            JButton BTNCadastro = new JButton("Cadastro");
            JButton BTNVoltar = new JButton("Voltar");
            JPainel.add(new JLabel("Digite o ano do gasto: "));
            JPainel.add(Jano);
            JPainel.add(new JLabel("Digite o valor para o mês de janeiro: "));
            JPainel.add(txtJan);
            JPainel.add(new JLabel("Digite o valor para o mês de fevereiro: "));
            JPainel.add(txtFev);
            JPainel.add(new JLabel("Digite o valor para o mês de março: "));
        JPainel.add(txtMar);
            JPainel.add(new JLabel("Digite o valor para o mês de abril: "));
        JPainel.add(txtAbr);
            JPainel.add(new JLabel("Digite o valor para o mês de maio: "));
        JPainel.add(txtMai);
            JPainel.add(new JLabel("Digite o valor para o mês de junho: "));
        JPainel.add(txtJun);
            JPainel.add(new JLabel("Digite o valor para o mês de julho: "));
        JPainel.add(txtJul);
            JPainel.add(new JLabel("Digite o valor para o mês de agosto: "));
        JPainel.add(txtAgo);
            JPainel.add(new JLabel("Digite o valor para o mês de setembro: "));
        JPainel.add(txtSet);
            JPainel.add(new JLabel("Digite o valor para o mês de outubro: "));
        JPainel.add(txtOut);
            JPainel.add(new JLabel("Digite o valor para o mês de novembro: "));
        JPainel.add(txtNov);
            JPainel.add(new JLabel("Digite o valor para o mês de dezembro: "));
        JPainel.add(txtDez);
            JRadioButton jrPRE = new JRadioButton("previsto");
            JRadioButton jrREA = new JRadioButton("realizado");
        JPainel.add(new JLabel("Previsto: "));
        JPainel.add(jrPRE);
        JPainel.add(new JLabel("Realizado: "));
            JPainel.add(jrREA);
            JPainel.add(BTNCadastro);
            JPainel.add(BTNVoltar);

            frame.setContentPane(JPainel);
            frame.setVisible(true);

            BTNCadastro.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Gasto gasto = new Gasto();
                    gasto.setIdgasto(Integer.parseInt(JID.getText()));
                    gasto.setAno(Integer.parseInt(Jano.getText()));
                    gasto.setJan(Double.parseDouble(txtJan.getText()));
                    gasto.setFev(Double.parseDouble(txtFev.getText()));
                    gasto.setMar(Double.parseDouble(txtMar.getText()));
                    gasto.setAbr(Double.parseDouble(txtAbr.getText()));
                    gasto.setMai(Double.parseDouble(txtMai.getText()));
                    gasto.setJun(Double.parseDouble(txtJun.getText()));
                    gasto.setJul(Double.parseDouble(txtJul.getText()));
                    gasto.setAgo(Double.parseDouble(txtAgo.getText()));
                    gasto.setSet(Double.parseDouble(txtSet.getText()));
                    gasto.setOut(Double.parseDouble(txtOut.getText()));
                    gasto.setNov(Double.parseDouble(txtNov.getText()));
                    gasto.setDez(Double.parseDouble(txtDez.getText()));
                    if(jrPRE.isSelected()){
                        gasto.setTipo("Previsto");
                    } else if (jrREA.isSelected()) {
                        gasto.setTipo("Realizado");
                    }
                    jpaGastoDAO.altera(gasto);
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

    @Override
    public void telaAtualizar() {
        JPanel JPainel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField Jano = new JTextField(20);
        JTextField JID = new JTextField(20);
        JTextField txtJan = new JTextField(20);
        JTextField txtFev = new JTextField(20);
        JTextField txtMar = new JTextField(20);
        JTextField txtAbr = new JTextField(20);
        JTextField txtMai = new JTextField(20);
        JTextField txtJun = new JTextField(20);
        JTextField txtJul = new JTextField(20);
        JTextField txtAgo = new JTextField(20);
        JTextField txtSet = new JTextField(20);
        JTextField txtOut = new JTextField(20);
        JTextField txtNov = new JTextField(20);
        JTextField txtDez = new JTextField(20);
        JButton BTNCadastro = new JButton("Cadastro");
        JButton BTNVoltar = new JButton("Voltar");
        JPainel.add(new JLabel("Digite o id do gasto: "));
        JPainel.add(JID);
        JPainel.add(new JLabel("Digite o ano do gasto: "));
        JPainel.add(Jano);
        JPainel.add(new JLabel("Digite o valor para o mês de janeiro: "));
        JPainel.add(txtJan);
        JPainel.add(new JLabel("Digite o valor para o mês de fevereiro: "));
        JPainel.add(txtFev);
        JPainel.add(new JLabel("Digite o valor para o mês de março: "));
        JPainel.add(txtMar);
        JPainel.add(new JLabel("Digite o valor para o mês de abril: "));
        JPainel.add(txtAbr);
        JPainel.add(new JLabel("Digite o valor para o mês de maio: "));
        JPainel.add(txtMai);
        JPainel.add(new JLabel("Digite o valor para o mês de junho: "));
        JPainel.add(txtJun);
        JPainel.add(new JLabel("Digite o valor para o mês de julho: "));
        JPainel.add(txtJul);
        JPainel.add(new JLabel("Digite o valor para o mês de agosto: "));
        JPainel.add(txtAgo);
        JPainel.add(new JLabel("Digite o valor para o mês de setembro: "));
        JPainel.add(txtSet);
        JPainel.add(new JLabel("Digite o valor para o mês de outubro: "));
        JPainel.add(txtOut);
        JPainel.add(new JLabel("Digite o valor para o mês de novembro: "));
        JPainel.add(txtNov);
        JPainel.add(new JLabel("Digite o valor para o mês de dezembro: "));
        JPainel.add(txtDez);
        JRadioButton jrPRE = new JRadioButton("previsto");
        JRadioButton jrREA = new JRadioButton("realizado");
        JPainel.add(new JLabel("Previsto: "));
        JPainel.add(jrPRE);
        JPainel.add(new JLabel("Realizado: "));
        JPainel.add(jrREA);
        JPainel.add(BTNCadastro);
        JPainel.add(BTNVoltar);

        frame.setContentPane(JPainel);
        frame.setVisible(true);

        BTNCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gasto gasto = new Gasto();
                gasto.setIdgasto(Integer.parseInt(JID.getText()));
                gasto.setAno(Integer.parseInt(Jano.getText()));
                gasto.setJan(Double.parseDouble(txtJan.getText()));
                gasto.setFev(Double.parseDouble(txtFev.getText()));
                gasto.setMar(Double.parseDouble(txtMar.getText()));
                gasto.setAbr(Double.parseDouble(txtAbr.getText()));
                gasto.setMai(Double.parseDouble(txtMai.getText()));
                gasto.setJun(Double.parseDouble(txtJun.getText()));
                gasto.setJul(Double.parseDouble(txtJul.getText()));
                gasto.setAgo(Double.parseDouble(txtAgo.getText()));
                gasto.setSet(Double.parseDouble(txtSet.getText()));
                gasto.setOut(Double.parseDouble(txtOut.getText()));
                gasto.setNov(Double.parseDouble(txtNov.getText()));
                gasto.setDez(Double.parseDouble(txtDez.getText()));
                if(jrPRE.isSelected()){
                    gasto.setTipo("Previsto");
                } else if (jrREA.isSelected()) {
                    gasto.setTipo("Realizado");
                }
                jpaGastoDAO.altera(gasto);
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

    @Override
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

                Gasto gasto = new Gasto();
                gasto.setIdgasto(id);
                jpaGastoDAO.remove(gasto);

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
