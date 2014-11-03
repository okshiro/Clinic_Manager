package br.ufc.clinic.classes;

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
	
	
	
	
	//SOBRESCRITAS
	
	@Override
	public boolean equals(Object obj) {
		return this.usuario.equals(((Conta)obj).getUsuario());
	}
	
}
