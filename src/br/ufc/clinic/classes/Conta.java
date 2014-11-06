package br.ufc.clinic.classes;

import java.io.Serializable;

public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String usuario;
    private String senha;
    
    public Conta(String u, String s) {
    	this.usuario = u;
    	this.senha = s;
	}	
	
	
	//SOBRESCRITAS
	
	@Override
	public boolean equals(Object obj) {
		return this.usuario.equals(((Conta)obj).usuario)  && this.senha.equals( ((Conta)obj).senha);
	}
	
	//apagar isso depois
	@Override
	public String toString() {
		return this.usuario + this.senha;
	}
	
}
