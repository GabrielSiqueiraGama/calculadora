package br.com.zhant.calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	private enum TipoComando{
		ZERAR, NUMERO, DIV, MULT, SUB, SOM, IGUAL, VIRGULA, MUDAR, PORCENTAGEM;
	}
	
	private static final Memoria instancia = new Memoria();
	
	private TipoComando ultimaOperacao = null;
	private boolean substituir = false;
	private String textoAtual = "";
	private String textoBuffer = "";
	
	private final List<MemoriaObservador> observadores = new ArrayList<MemoriaObservador>();
	
	private Memoria() {
		
	}
	
	public static Memoria getInstancia() {
		return instancia;
	}
	
	public void adicionarObservador(MemoriaObservador observador) {
		observadores.add(observador);
	}
	
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual;
	}
	
	public void processarComando(String texto) {
		
		TipoComando tipoComando = dectatTipoComando(texto);
		
		if(tipoComando == null) {
			return;
		}else if(tipoComando == TipoComando.ZERAR){
			textoAtual = "";
			textoBuffer = "";
			substituir = false;
			ultimaOperacao = null;
		}else if(tipoComando == TipoComando.NUMERO 
				|| tipoComando == TipoComando.VIRGULA) {
			textoAtual = substituir ? texto : textoAtual + texto;
			substituir = false;
		}
		
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
	}

	private TipoComando dectatTipoComando(String texto) {
		if(textoAtual.isEmpty() && texto == "0") {
			return null;
		}
		try {//Confere se não é um numero. 
			Integer.parseInt(texto);
			return TipoComando.NUMERO;
		} catch (NumberFormatException e) {
			//Quando não for numero realiza os demais testes.
			if("AC".equals(texto)) {
				return TipoComando.ZERAR;
			}else if("/".equals(texto)) {
				return TipoComando.DIV;
			}else if("+".equals(texto)) {
				return TipoComando.SOM;
			}else if("*".equals(texto)) {
				return TipoComando.MULT;
			}else if("-".equals(texto)) {
				return TipoComando.SUB;
			}else if("=".equals(texto)) {
				return TipoComando.IGUAL;
			}else if(",".equals(texto) && !textoAtual.contains(",")) {
				return TipoComando.VIRGULA;
			}else if("+/-".equals(texto)) {
				return TipoComando.MUDAR;
			}else if("%".equals(texto)) {
				return TipoComando.PORCENTAGEM;
			}
		}
		return null;
	}
	
}
