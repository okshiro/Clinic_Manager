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
		System.out.println("Drogaasadasdasd");
	}

	public Atendente(String nome, Conta conta) {
		this(nome);
		setConta(conta);
	}
	
	
	public void cadastrarPaciente(String nome, long cpf, Endereco endereco, Telefone telefone){
		Paciente p = new Paciente(nome, cpf);
		p.addEndereco(endereco);
		p.addTelefone(telefone);
		
		repositorio.getPaciente().add(p);
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
		
		repositorio.getMedico().add(m);
		
	}
	
	public void cadastrarGerente(String nome, Conta c){
		Gerente g = new Gerente(nome, c);
		repositorio.getGerentes().add(g);
	}
	
	public void cadastrarPlanoDeSaude(String razaoSocial,long cnpj, Endereco enderecos, Telefone telefones ){
		PlanoSaude plano = new PlanoSaude(razaoSocial, cnpj);
		plano.addEndereco(enderecos);
		plano.addTelefone(telefones);
		
		repositorio.getPlano_saude().add(plano);
	}
	
	public void cadastrarConsultaParticular(int id, int duracao, LocalDate dia, LocalTime hora, Paciente paciente, Medico medico, double preco){
		ConsultaParticular c = new ConsultaParticular(id, duracao, dia, hora, paciente, medico, preco);
		repositorio.getConsulta_particular().add(c);
	}
	public void cadastrarConsultaPorPlano(int id, int duracao, LocalDate dia, LocalTime hora, Paciente paciente, Medico medico,PlanoSaude p){
		ConsultaPorPlano c = new ConsultaPorPlano(id, duracao, dia, hora, paciente, medico);
		c.setPlanoSaude(p);
		
		repositorio.getConsulta_plano().add(c);
	}
	
	public void cadastraEspecialidade(int id, String nome){
		repositorio.getEspecialidade().add(new Especialidade(id, nome));
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
	
	
	public Medico getMedico(Medico m){
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

}

