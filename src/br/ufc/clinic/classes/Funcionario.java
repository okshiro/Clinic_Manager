package br.ufc.clinic.classes;

import java.io.Serializable;

public class Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Conta conta;
	
	//CONTRUCT
	public Funcionario(String nome){
		setNome(nome);
	}
	public Funcionario(String nome, Conta conta){
		this(nome);
		setConta(conta);
	}
	
	
	
	//GETS
	
	public String getNome() {
		return nome;
	}
	
	public Conta getConta() {
		return conta;
	}
	
	//SETS
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
