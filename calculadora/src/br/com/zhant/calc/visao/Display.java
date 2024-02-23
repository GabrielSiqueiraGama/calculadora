package br.com.zhant.calc.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.zhant.calc.modelo.Memoria;
import br.com.zhant.calc.modelo.MemoriaObservador;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador{
	
	private final JLabel label;
	
	public Display() {
		Memoria.getInstancia().adicionarObservador(this);
		
		setBackground(new Color(46,49,50));//Cor de fundo. Cinza
		label = new JLabel(Memoria.getInstancia().getTextoAtual());//Infomração na tela
		label.setForeground(Color.WHITE);//Cor do conteudo dentro da tela
		label.setFont(new Font("courier", Font.PLAIN, 30));//Definição sobre fonte.
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));//Coloca o conteudo na direita
		
		add(label);//Adicionando a tela. 
		
	}

	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);
	}
	
}
