package br.ufc.clinic.classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.ufc.clinic.repository.RepositoryManage;
public class Atendente extends Funcionario {

	private static final long serialVersionUID = 1L;
	private RepositoryManage<Object> repositorio;

	//CONSTRUCT
	
	public Atendente(String nome) {
		super(nome);
		repositorio = new RepositoryManage<Object>();
		repositorio.createRepositoryALL();
		repositorio.loadRepositoryALL();
		repositorio.pullRepositoryALL();
	}

	public Atendente(String nome, Conta conta) {
		this(nome);
		setConta(conta);
	}
	
	
	public void cadastrarPaciente(String nome, long cpf, Endereco endereco, Telefone telefone){
		Paciente p = new Paciente(nome, cpf);
		p.addEndereco(endereco);
		p.addTelefone(telefone);
		this.adicionarParciente(p);
	}
	
	
	public void cadastrarMedico(String nome, long crm, Conta conta, Endereco endereco, Telefone telefone,Especialidade especialidade, List<DiaSemana> dias ){
		Medico m = new Medico(nome, conta, crm);
		if(endereco != null){
			m.addEndereco(endereco);
		}
		if(telefone != null){
			m.addTelefone(telefone);
		}
		m.addEspecialidades(especialidade);
		
		for (DiaSemana d : dias) {
			m.addDiasTrabalha(d);
		}
		this.adicionarMedico(m);
	}
	
	public void cadastrarGerente(String nome, Conta c){
		Gerente g = new Gerente(nome, c);
		this.adicionarGerente(g);
	}
	
	public void cadastrarPlanoDeSaude(String razaoSocial,long cnpj, Endereco enderecos, Telefone telefones ){
		PlanoSaude plano = new PlanoSaude(razaoSocial, cnpj);
		plano.addEndereco(enderecos);
		plano.addTelefone(telefones);
		this.adicionarPlanoDeSaude(plano);
	}
	
	public void cadastrarConsultaParticular(int id, int duracao, LocalDate dia, LocalTime hora, Paciente paciente, Medico medico, double preco){
		ConsultaParticular c = new ConsultaParticular(id, duracao, dia, hora, paciente, medico, preco);
		this.adicionarConsultaPartiular(c);
	}
	public void cadastrarConsultaPorPlano(int id, int duracao, LocalDate dia, LocalTime hora, Paciente paciente, Medico medico,PlanoSaude p){
		ConsultaPorPlano c = new ConsultaPorPlano(id, duracao, dia, hora, paciente, medico);
		c.setPlanoSaude(p);
		this.adicionarConsultasPorPlano(c);
	}
	
	public void cadastraEspecialidade(int id, String nome){
		Especialidade e = new Especialidade(id, nome);
		this.adicionarEspecialidade(e);
	}
	
	
	public List<Medico> horariosLivres(DiaSemana dia){
		
		java.util.List<Medico> modalMedicos = repositorio.getMedico().get();
		
		for(int i=0; i< modalMedicos.size(); i++){
			if(modalMedicos.get(i).getDiasTrabalha().contains(dia)){
				modalMedicos.remove(i);
			}
		}
		return modalMedicos;
	}
	
	
	public Medico getMedicoOriginal(Medico m){
		for(Medico medico : repositorio.getMedico().get()){
			if(medico.equals(m)){
				return medico;
			}
		}
		return null;
	}
	
	public List<Medico> getMedicoEspecialidade(Especialidade e){
		List<Medico> medicos = new ArrayList<Medico>();
		for(Medico medico : repositorio.getMedico().get()){
			if(medico.getEspecialidades().equals(e)){
				medicos.add(medico);
			}
		}
		return medicos;
	}
	
	public List<Medico> getMedicoEspecialidadeDia(Especialidade e, DiaSemana dia){
		List<Medico> medicosEsp = getMedicoEspecialidade(e);
		for(int i = 0; i<medicosEsp.size() ; i++){
			if(!(medicosEsp.get(i).getDiasTrabalha().contains(dia))){
				medicosEsp.remove(medicosEsp.get(i));
			}
		}
		return medicosEsp;
	}
	
	
	
	
	
	//PACIENTES
	public List<Paciente> getListaPaciente(){
		return repositorio.getPaciente().get();
	}
	public void removerParciente(Paciente p){
		 repositorio.getPaciente().rem(p);
	}
	public void adicionarParciente(Paciente p){
		 repositorio.getPaciente().add(p);
	}
	
	
	
	//CONSULTAS POR PLANO
	public List<ConsultaPorPlano> getListaConsultasPorPlano(){
		return repositorio.getConsulta_plano().get();
	}
	public void removerConsultasPorPlano(ConsultaPorPlano c){
		repositorio.getConsulta_plano().rem(c);
	}
	public void adicionarConsultasPorPlano(ConsultaPorPlano c){
		repositorio.getConsulta_plano().add(c);
	}
	
	
	//CONSULTAS PARTCULAR
	public List<ConsultaParticular> getListaConsultasParticular(){
		return repositorio.getConsulta_particular().get();
	}
	public void removerConsultaPartiular(ConsultaParticular c){
		repositorio.getConsulta_particular().rem(c);
	}
	public void adicionarConsultaPartiular(ConsultaParticular c){
		repositorio.getConsulta_particular().add(c);
	}
	
	
	//CONTAS
	public List<Conta> getListaConta(){
		return repositorio.getConta().get();
	}
	public void removerConta(Conta c){
		repositorio.getConta().rem(c);
	}
	public void adicionarConta(Conta c){
		repositorio.getConta().add(c);
	}
	
	
	//ATENDENTE
	public List<Atendente> getListaAtendente(){
		return repositorio.getAtendentes().get();
	}
	public void removerAtendente(Atendente a){
		repositorio.getAtendentes().rem(a);
	}
	public void adicionarAtendente(Atendente a){
		repositorio.getAtendentes().add(a);
	}
	
	
	//ESPECIALIDADES
	public List<Especialidade> getListaEspecialidade(){
		return repositorio.getEspecialidade().get();
	}
	public void removerEspecialidade(Especialidade e){
		repositorio.getEspecialidade().rem(e);
	}
	public void adicionarEspecialidade(Especialidade e){
		repositorio.getEspecialidade().add(e);
	}
	
	//FUNCIONARIO
	public List<Funcionario> getListaFuncionario(){
		return repositorio.getFuncionario().get();
	}
	public void removerFuncionario(Funcionario f){
		repositorio.getFuncionario().rem(f);
	}
	public void adicionarFuncionario(Funcionario f){
		repositorio.getFuncionario().add(f);
	}
	
	
	//GERENET
	public List<Gerente>  getListaGerente(){
		return repositorio.getGerentes().get();
	}
	public void removerGerente(Gerente e){
		repositorio.getGerentes().rem(e);
	}
	public void adicionarGerente(Gerente e){
		repositorio.getGerentes().add(e);
	}
	
	
	//MEDICOS
	public List<Medico> getListaMedico(){
		return repositorio.getMedico().get();
	}
	public void removerMedico(Medico m){
		repositorio.getMedico().rem(m);
	}
	public void adicionarMedico(Medico m){
		repositorio.getMedico().add(m);
	}
	
	//PLANOS DE SAUDE
	public List<PlanoSaude> getListaPlanoSaude(){
		return repositorio.getPlano_saude().get();
	}
	public void removerPlanoDeSaude(PlanoSaude p){
		repositorio.getPlano_saude().rem(p);
	}
	public void adicionarPlanoDeSaude(PlanoSaude p){
		repositorio.getPlano_saude().add(p);
	}
	
	
	
	
	
	
	
	
	
	
	

}

