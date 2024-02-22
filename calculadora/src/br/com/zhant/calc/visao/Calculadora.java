package br.com.zhant.calc.visao;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame{

	public Calculadora() {
		
		organizarLayout();

		setSize(232, 322);//Define o tamanho
		setDefaultCloseOperation(EXIT_ON_CLOSE);//Encerra o processo ao fechar a pagina
		setLocationRelativeTo(null);//faz com que o app seja aberto no meio da tela
		setVisible(true);//Seta visibilidade como verdadeira, criando assim o "app desktop"	
	}
	
	private void organizarLayout() {
		setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new Dimension(233, 60));
		add(display, BorderLayout.NORTH);
		
		Teclado teclado = new Teclado();
		add(teclado, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new Calculadora();
	}
	
}
