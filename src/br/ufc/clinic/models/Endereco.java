package br.ufc.clinic.models;

import java.io.Serializable;

public class Endereco implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String complemento;
    private int numero;
}
