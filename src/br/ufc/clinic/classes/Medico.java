package br.ufc.clinic.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Medico extends Funcionario {
	
	private static final long serialVersionUID = 1L;
	
	private long crm;
	private List<DiaSemana> diasTrabalha;
	private List<Especialidade> especialidades;
	private List<PlanoSaude> planosSaude;
	private List<Endereco> enderecos;
	private List<Telefone> telefones;
	
	
	//CONSTRUCTS
	
	public Medico(String nome) {
		super(nome);
		diasTrabalha = new ArrayList<DiaSemana>();
		especialidades = new ArrayList<Especialidade>();
		planosSaude = new ArrayList<PlanoSaude>();
		enderecos = new ArrayList<Endereco>();
		telefones = new ArrayList<Telefone>();	
	}
	
	public Medico(String nome, long crm) {
		this(nome);
		 this.crm= crm;
	}

	public Medico(String nome, Conta conta) {
		super(nome, conta);
		diasTrabalha = new ArrayList<DiaSemana>();
		especialidades = new ArrayList<Especialidade>();
		planosSaude = new ArrayList<PlanoSaude>();
		enderecos = new ArrayList<Endereco>();
		telefones = new ArrayList<Telefone>();
	}
	
	public Medico(String nome, Conta conta, long crm) {
		this(nome, conta);
		setCrm(crm);
	}



	//GETS
	public long getCrm() {
		return crm;
	}

	public List<DiaSemana> getDiasTrabalha() {
		return Collections.unmodifiableList(this.diasTrabalha);
	}
	
	public List<Especialidade> getEspecialidades() {
		return Collections.unmodifiableList(this.especialidades);
	}
	
	public List<PlanoSaude> getPlanosSaude() {
		return Collections.unmodifiableList(this.planosSaude);
	}
	
	public List<Endereco> getEnderecos() {
		return Collections.unmodifiableList(this.enderecos);
	}
	
	public List<Telefone> getTelefones() {
		return Collections.unmodifiableList(this.telefones);
	}
	
	//SETS
	
	public void setCrm(long crm) {
		this.crm = crm;
	}
	
	//ADDS
	
	public void addDiasTrabalha(DiaSemana diaTrabalha) {
		this.diasTrabalha.add(diaTrabalha);
	}
	
	public void addEspecialidades(Especialidade especialidade) {
		this.especialidades.add(especialidade);
	}
	
	public void addEndereco(Endereco endereco){
		this.enderecos.add(endereco);
	}
	
	public void addTelefone(Telefone telefone){
		this.telefones.add(telefone);
	}
	
	//REMS
	
	public void remDiasTrabalha(DiaSemana diaTrabalha) {
		this.diasTrabalha.remove(diaTrabalha);
	}
	
	public void remEspecialidades(Especialidade especialidade) {
		this.especialidades.remove(especialidade);
	}
	
	public void remEnderecos(Endereco endereco){
		this.enderecos.remove(endereco);
	}
	
	public void remTelefone(Telefone telefone){
		this.telefones.remove(telefone);
	}
	
	//SOBRESCRITAS
	
	@Override
	public String toString() {
		return this.getNome() + "-" + this.crm;
	}
	
	@Override
	public boolean equals(Object obj) {
		Medico m = (Medico) obj;
		return this.getNome().equals(m.getNome()) && this.getCrm() == m.getCrm();
	}


}
