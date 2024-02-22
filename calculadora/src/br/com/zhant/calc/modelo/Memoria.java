package br.com.zhant.calc.modelo;

public class Memoria {

	private static final Memoria instancia = new Memoria();
	
	private String textoAtual = "";
	
	private Memoria() {
		
	}
	
	public static Memoria getInstancia() {
		return instancia;
	}
	
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual;
	}
	
}
