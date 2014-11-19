package br.ufc.clinic.classes;

import java.io.Serializable;

import br.ufc.clinic.ferramentas.Ferramentas;

public class Observacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String descricao;
	private TipoObservacao tipoObservacao;
	
	//CONSTRUCT
	public Observacao(String descricao, TipoObservacao tipo) {
		setDescricao(descricao);
		setTipoObservacao(tipo);
	
	}

	
	
	//GETS
	
	public String getDescricao() {
		return descricao;
	}

	public TipoObservacao getTipoObservacao() {
		return tipoObservacao;
	}
	
	//SETS
	

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setTipoObservacao(TipoObservacao tipoObservacao) {
		this.tipoObservacao = tipoObservacao;
	}
	
	//SOBRESCRITAS
	
	@Override
	public String toString() {
		return Ferramentas.TipoObservacaoToString(this.tipoObservacao) +" : " + this.descricao;
	}
}
