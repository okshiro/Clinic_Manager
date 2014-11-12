package br.ufc.clinic.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
    private long  cpf;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;
    
	
    
    //CONSTRUCTS
    
    public Paciente(String nome) {
    	enderecos = new ArrayList<Endereco>();
    	telefones = new ArrayList<Telefone>();
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
	
	//ADDS
	public void addEndereco(Endereco e){
		this.enderecos.add(e);
	}
	
	public void addTelefone(Telefone t){
		this.telefones.add(t);
	}
	
	
	//REM
		public void remEndereco(Endereco e){
			this.enderecos.remove(e);
		}
		
		public void remTelefone(Telefone t){
			this.telefones.remove(t);
		}
	
	
	
	
	
}
