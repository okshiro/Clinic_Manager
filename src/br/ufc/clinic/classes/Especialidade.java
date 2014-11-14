package br.ufc.clinic.classes;

import java.io.Serializable;

public class Especialidade implements Serializable{

	private static final long serialVersionUID = 1L;

	private long codigo;
	private String nome;
	
	//CONSTRUCT
	public Especialidade(long codigo, String nome) {
		setCodigo(codigo);
		setNome(nome);
	}


	//GETS
	
	public long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
		
	//SETS
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//SOBRESCRITAS
	
	@Override
	public String toString() {
		return  this.codigo + "-" + this.nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.getCodigo() == ((Especialidade)obj).getCodigo();
	}
	

}
