package br.ufc.clinic.classes;

public class Atendente extends Funcionario {

	private static final long serialVersionUID = 1L;

	//CONSTRUCT
	
	public Atendente(String nome) {
		super(nome);
	}

	public Atendente(String nome, Conta conta) {
		super(nome, conta);
	}

}
