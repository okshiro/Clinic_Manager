package br.ufc.clinic.classes;

public class Gerente extends Funcionario {

	private static final long serialVersionUID = 1L;

	public Gerente(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	public Gerente(String nome, Conta conta) {
		super(nome, conta);
		// TODO Auto-generated constructor stub
	}
	
	//SOBRESCRITAS
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.getNome().equals(((Gerente)obj).getNome());
	}

}
