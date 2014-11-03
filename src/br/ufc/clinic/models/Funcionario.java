package br.ufc.clinic.models;

import java.io.Serializable;

public abstract class Funcionario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Conta conta;
	
}
