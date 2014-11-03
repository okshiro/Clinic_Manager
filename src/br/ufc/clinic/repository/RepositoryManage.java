package br.ufc.clinic.repository;

import java.util.ArrayList;
import java.util.List;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.ConsultaParticular;
import br.ufc.clinic.classes.ConsultaPorPlano;
import br.ufc.clinic.classes.Conta;
import br.ufc.clinic.classes.Especialidade;
import br.ufc.clinic.classes.Funcionario;
import br.ufc.clinic.classes.Medico;
import br.ufc.clinic.classes.Paciente;
import br.ufc.clinic.classes.PlanoSaude;



public class RepositoryManage<T>{
	List<GenericRepository<T>> repositorios;
	
	@SuppressWarnings("unchecked")
	public RepositoryManage() {
		this.repositorios = new ArrayList<GenericRepository<T>>();
		this.repositorios.add((GenericRepository<T>) new GenericRepository<Atendente>("atendente"));
		this.repositorios.add((GenericRepository<T>) new GenericRepository<ConsultaParticular>("consulta_particular"));
		this.repositorios.add((GenericRepository<T>) new GenericRepository<ConsultaPorPlano>("consulta_plano"));
		this.repositorios.add((GenericRepository<T>) new GenericRepository<Conta>("conta"));
		this.repositorios.add((GenericRepository<T>) new GenericRepository<Especialidade>("especialidade"));
		this.repositorios.add((GenericRepository<T>) new GenericRepository<Funcionario>("funcionario"));
		this.repositorios.add((GenericRepository<T>) new GenericRepository<Medico>("medico"));
		this.repositorios.add((GenericRepository<T>) new GenericRepository<Paciente>("paciente"));
		this.repositorios.add((GenericRepository<T>) new GenericRepository<PlanoSaude>("plano_saude"));

	}
	
	public void create(){
		for (GenericRepository<T> i : this.repositorios) {
			i.create();
		}
	};
	
	public void destroy(){
		for (GenericRepository<T> i : this.repositorios) {
			i.destroy();
		}
	};
	
	public void load(){
		for (GenericRepository<T> i : this.repositorios) {
			i.load();
		}
	}
	
	public void push(){
		for (GenericRepository<T> i : this.repositorios) {
			i.push();
		}
	};
	
	public void pull(){
		for (GenericRepository<T> i : this.repositorios) {
			i.pull();
		}
	};
	
	public <E> void add(E entity){
		for (GenericRepository<?> i : this.repositorios) {
			if(i.getClass() instanceof (GenericRepository<E>).getClass() ){
				
			}
		}
	}
	

}
