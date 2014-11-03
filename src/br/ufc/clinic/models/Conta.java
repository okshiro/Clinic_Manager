package br.ufc.clinic.models;

import java.io.Serializable;

public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String usuario;
    private String senha;
    
    public Conta(String u, String s) {
    	setUsuario(u);
    	setSenha(s);
	}
    
    
    
    //GETS
    
	public String getUsuario() {
		return usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	//SETS
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
