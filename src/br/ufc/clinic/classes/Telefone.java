package br.ufc.clinic.classes;

import java.io.Serializable;

public class Telefone implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	private String numero;

	//CONSTRUCT
	
	public Telefone(String numero) {
		setNumero(numero);
	}
	

	//GETS
	public String getNumero() {
		return numero;
	}

	//SETS
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	//SOBRESCRITAS
	
	@Override
	public String toString() {
		return this.numero;
	}
	
}
