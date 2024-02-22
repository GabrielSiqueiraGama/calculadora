package br.com.zhant.calc.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.zhant.calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Display extends JPanel{
	
	private JLabel label;
	
	public Display() {
		
		setBackground(new Color(46,49,50));//Cor de fundo. Cinza
		label = new JLabel(Memoria.getInstancia().getTextoAtual());//Infomração na tela
		label.setForeground(Color.WHITE);//Cor do conteudo dentro da tela
		label.setFont(new Font("courier", Font.PLAIN, 30));//Definição sobre fonte.
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));//Coloca o conteudo na direita
		add(label);//Adicionando a tela. 
		
	}
	
}
