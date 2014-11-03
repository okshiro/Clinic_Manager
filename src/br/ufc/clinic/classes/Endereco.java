package br.ufc.clinic.classes;

import java.io.Serializable;


public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String complemento;
    private int numero;
	
    //CONSTRUCTS
    
    public Endereco(String estado) {
    	
    	setEstado(estado);
	}
    public Endereco(String estado, String cidade) {
    	this(estado);
    	setCidade(cidade);
	}
    public Endereco(String estado, String cidade, String bairro) {
    	this(estado, cidade);
    	setBairro(bairro);
	}
    public Endereco(String estado, String cidade, String bairro, String rua) {
    	this(estado, cidade, bairro);
    	setRua(rua);
	}
    public Endereco(String estado, String cidade, String bairro, String rua, String complemento) {
    	this(estado, cidade, bairro, rua);
    	setComplemento(complemento);
	}
    public Endereco(String estado, String cidade, String bairro, String rua, String complemento, int numero) {
    	this(estado, cidade, bairro, rua, complemento);
    	setNumero(numero);
	}
    
    

    //GETS
    
	public String getEstado() {
		return estado;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public String getRua() {
		return rua;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public int getNumero() {
		return numero;
	}
	
	//SETS
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	//SOBRESCRITAS
	
	@Override
	public boolean equals(Object obj) {
		return 
		   this.getEstado().toUpperCase().equals(((Endereco)obj).getEstado().toUpperCase()) &&
		   this.getCidade().toUpperCase().equals(((Endereco)obj).getCidade().toUpperCase()) &&
		   this.getRua().toUpperCase().equals(((Endereco)obj).getRua().toUpperCase()) &&
		   this.getBairro().toUpperCase().equals(((Endereco)obj).getBairro().toUpperCase()) &&
		   this.getComplemento().toUpperCase().equals(((Endereco)obj).getComplemento().toUpperCase()) &&
		   this.getNumero() == ((Endereco)obj).getNumero();
	}
	
	
	
}
