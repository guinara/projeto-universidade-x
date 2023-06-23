package com.BancoDeDados.Projeto;

import com.BancoDeDados.Telas.TelaProfessor;
import com.BancoDeDados.Telas.TelasDisciplina;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class ProjetoApplication {

	public static void main(String[] args) {


//		TelaProfessor telaProfessor =new TelaProfessor();
//		telaProfessor.inserirCadastro();
		JFrame frame = new JFrame();
		frame.setSize(250, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tela tela =new Tela(frame);
		tela.menuPrincipal();
		frame.pack();
		//SpringApplication.run(ProjetoApplication.class, args);
	}
	}
