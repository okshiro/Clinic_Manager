package br.ufc.clinic.classes;

import java.io.Serializable;

public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
    private long  cpf;
	
    
    //CONSTRUCTS
    
    public Paciente(String nome) {
    	setNome(nome);
    }
    public Paciente(String nome, long cpf) {
    	this(nome);
    	setCpf(cpf);
    }
    
    
    //GETS
    
	public String getNome() {
		return nome;
	}
	
	public long getCpf() {
		return cpf;
	}
	
	//SETS
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
}
