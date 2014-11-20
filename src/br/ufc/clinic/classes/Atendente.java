package br.ufc.clinic.classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.ufc.clinic.repository.GenericRepository;

public class Atendente extends Funcionario {

	private static final long serialVersionUID = 1L;

	//CONSTRUCT
	
	public Atendente(String nome) {
		super(nome);
	}

	public Atendente(String nome, Conta conta) {
		super(nome, conta);
	}
	
	
	public void cadastrarPaciente(String nome, long cpf, Endereco endereco, Telefone telefone){
		Paciente p = new Paciente(nome, cpf);
		p.addEndereco(endereco);
		p.addTelefone(telefone);
		
		GenericRepository<Paciente> paciente = new GenericRepository<Paciente>("paciente");
		if(paciente.exist()){
			paciente.load();
		}else{
			paciente.create();
			paciente.load();
		}
		paciente.pull();
		paciente.add(p);
		paciente.push();
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
		
		GenericRepository<Medico> medico = new GenericRepository<Medico>("medico");
		if(medico.exist()){
			medico.load();
		}else{
			medico.create();
			medico.load();
		}
		medico.pull();
		medico.add(m);
		medico.push();
	}
	
	public void cadastrarGerente(String nome, Conta c){
		Gerente g = new Gerente(nome, c);
		GenericRepository<Gerente> gerente = new GenericRepository<Gerente>("gerente");
		gerente.create();
		gerente.load();
		gerente.pull();
		gerente.add(g);
	}
	
	public void cadastrarPlanoDeSaude(String razaoSocial,long cnpj, Endereco enderecos, Telefone telefones ){
		PlanoSaude plano = new PlanoSaude(razaoSocial, cnpj);
		plano.addEndereco(enderecos);
		plano.addTelefone(telefones);
		
		GenericRepository<PlanoSaude> p = new GenericRepository<PlanoSaude>("plano_saude");
		p.create();
		p.load();
		p.pull();
		p.add(plano);		
	}
	
	public void cadastrarConsultaParticular(int id, int duracao, LocalDate dia, LocalTime hora, Paciente paciente, Medico medico, double preco){
		ConsultaParticular c = new ConsultaParticular(id, duracao, dia, hora, paciente, medico, preco);
		GenericRepository<ConsultaParticular> consulta = new GenericRepository<ConsultaParticular>("consulta_particular");
		consulta.create();
		consulta.pull();
		consulta.add(c);
		consulta.push();
	}
	public void cadastrarConsultaPorPlano(int id, int duracao, LocalDate dia, LocalTime hora, Paciente paciente, Medico medico,PlanoSaude p){
		ConsultaPorPlano c = new ConsultaPorPlano(id, duracao, dia, hora, paciente, medico);
		c.setPlanoSaude(p);
		
		GenericRepository<ConsultaPorPlano> consulta = new GenericRepository<ConsultaPorPlano>("consulta_plano");
		consulta.create();
		consulta.load();
		consulta.pull();
		consulta.add(c);
		consulta.push();
	}
	
	public void cadastraEspecialidade(int id, String nome){
		GenericRepository<Especialidade> especialidades = new GenericRepository<Especialidade>("especialidade");
		especialidades.create();
		especialidades.load();
		especialidades.pull();
		especialidades.add(new Especialidade(id, nome));
		especialidades.push();
	}
	
	
	public List<Medico> horariosLivres(DiaSemana dia){
		GenericRepository<Medico> repMedicos = new GenericRepository<Medico>("medico");
		repMedicos.create();
		repMedicos.load();
		repMedicos.pull();
		
		java.util.List<Medico> modalMedicos = new ArrayList<Medico>();
		modalMedicos.addAll(repMedicos.get());
		
		for(int i=0; i< modalMedicos.size(); i++){
			if(modalMedicos.get(i).getDiasTrabalha().contains(dia)){
				modalMedicos.remove(i);
			}
		}
		return modalMedicos;
	}
	
	public Medico getMedico(Medico m){
		GenericRepository<Medico> repMedicos = new GenericRepository<Medico>("medico");
		repMedicos.create();
		repMedicos.load();
		repMedicos.pull();
		for(Medico medico : repMedicos.get()){
			if(medico.equals(m)){
				return medico;
			}
		}
		return null;
	}

}
