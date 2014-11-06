package br.ufc.clinic.repository;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.ConsultaParticular;
import br.ufc.clinic.classes.ConsultaPorPlano;
import br.ufc.clinic.classes.Conta;
import br.ufc.clinic.classes.Especialidade;
import br.ufc.clinic.classes.Funcionario;
import br.ufc.clinic.classes.Gerente;
import br.ufc.clinic.classes.Medico;
import br.ufc.clinic.classes.Paciente;
import br.ufc.clinic.classes.PlanoSaude;


public class RepositoryManage<T>{
		private  GenericRepository<Atendente> atendentes;
		private  GenericRepository<ConsultaParticular> consulta_particular;
		private  GenericRepository<ConsultaPorPlano> consulta_plano;
		private  GenericRepository<Conta> conta;
		private  GenericRepository<Especialidade> especialidade;
		private  GenericRepository<Funcionario> funcionario;
		private  GenericRepository<Medico> medico;
		private  GenericRepository<Paciente> paciente;
		private  GenericRepository<Gerente> gerente;
		private  GenericRepository<PlanoSaude> plano_saude;
		
		
		public RepositoryManage() {
			this.atendentes = new GenericRepository<Atendente>("atendente");
			this.consulta_particular = new GenericRepository<ConsultaParticular>("consulta_particular");
			this.consulta_plano = new GenericRepository<ConsultaPorPlano>("consulta_plano");
			this.conta = new GenericRepository<Conta>("conta");
			this.especialidade = new GenericRepository<Especialidade>("especialidade");
			this.funcionario = new GenericRepository<Funcionario>("funcionario");
			this.medico = new GenericRepository<Medico>("medico");
			this.gerente = new GenericRepository<Gerente>("gerente");
			this.paciente = new GenericRepository<Paciente>("paciente");
			this.plano_saude = new GenericRepository<PlanoSaude>("plano_saude");
		}
	
		public void createRepositoryALL(){
			this.atendentes.create();
			this.consulta_particular.create();
			this.consulta_plano.create();
			this.conta.create();
			this.especialidade.create();
			this.funcionario.create();
			this.medico.create();
			this.gerente.create();
			this.paciente.create();
			this.plano_saude.create();
		}
		public void destroyRepositoryALL(){
			this.atendentes.destroy();
			this.consulta_particular.destroy();
			this.consulta_plano.destroy();
			this.conta.destroy();
			this.especialidade.destroy();
			this.funcionario.destroy();
			this.medico.destroy();
			this.gerente.destroy();
			this.paciente.destroy();
			this.plano_saude.destroy();
		}
		
		public void loadRepositoryALL(){
			this.atendentes.load();
			this.consulta_particular.load();
			this.consulta_plano.load();
			this.conta.load();
			this.especialidade.load();
			this.funcionario.load();
			this.medico.load();
			this.gerente.load();
			this.paciente.load();
			this.plano_saude.load();
		}
		
		public void pushRepositoryALL(){
			this.atendentes.push();
			this.consulta_particular.push();
			this.consulta_plano.push();
			this.conta.push();
			this.especialidade.push();
			this.funcionario.push();
			this.medico.push();
			this.gerente.push();
			this.paciente.push();
			this.plano_saude.push();
		}
		
		public void pullRepositoryALL(){
			this.atendentes.pull();
			this.consulta_particular.pull();
			this.consulta_plano.pull();
			this.conta.pull();
			this.especialidade.pull();
			this.funcionario.pull();
			this.medico.pull();
			this.gerente.pull();
			this.paciente.pull();
			this.plano_saude.pull();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//GETS
		
		public GenericRepository<Atendente> getAtendentes() {
			return atendentes;
		}


		public GenericRepository<ConsultaParticular> getConsulta_particular() {
			return consulta_particular;
		}


		public GenericRepository<ConsultaPorPlano> getConsulta_plano() {
			return consulta_plano;
		}


		public GenericRepository<Conta> getConta() {
			return conta;
		}


		public GenericRepository<Especialidade> getEspecialidade() {
			return especialidade;
		}


		public GenericRepository<Funcionario> getFuncionario() {
			return funcionario;
		}


		public GenericRepository<Medico> getMedico() {
			return medico;
		}

		public GenericRepository<Gerente> getGerentes() {
			return gerente;
		}
		
		public GenericRepository<Paciente> getPaciente() {
			return paciente;
		}
		
		public GenericRepository<PlanoSaude> getPlano_saude() {
			return plano_saude;
		}
}
