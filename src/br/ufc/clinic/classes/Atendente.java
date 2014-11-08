package br.ufc.clinic.classes;

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
	
	
	public void cadastrarMedico(String nome, long crm, Conta conta, Endereco endereco){
		Medico m = new Medico(nome, conta, crm);
		if(endereco != null){
			m.addEndereco(endereco);
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

}
