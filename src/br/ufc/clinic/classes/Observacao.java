package br.ufc.clinic.classes;

public class Observacao {
	private String descricao;
	private TipoObservacao tipoObservacao;
	
	//CONSTRUCT
	public Observacao(String descricao, TipoObservacao tipo) {
	
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
}
