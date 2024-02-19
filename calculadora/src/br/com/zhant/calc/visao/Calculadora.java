package br.com.zhant.calc.visao;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame{

	public Calculadora() {
		setVisible(true);//Seta visibilidade como verdadeira, criando assim o "app desktop"	
		setDefaultCloseOperation(EXIT_ON_CLOSE);//Encerra o processo ao fechar a pagina
		setSize(233,322);//Define o tamanho
		setLocationRelativeTo(null);//faz com que o app seja aberto no meio da tela
	}
	
	public static void main(String[] args) {
		new Calculadora();
	}
	
}
