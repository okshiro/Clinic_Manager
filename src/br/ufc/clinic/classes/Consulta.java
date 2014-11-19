package br.ufc.clinic.classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Consulta  implements Serializable{
	private static final long serialVersionUID = 1L;

	private int id;
	
	private int duracaoMinutos;
	private LocalDate dia;
	private LocalTime hora;
	
	private Paciente paciente;
	private Medico medico;
	
	private  List<Observacao> observacao;
	
	public Consulta(int id, int duracao, LocalDate dia, LocalTime hora, Paciente paciente, Medico medico) {
		observacao = new ArrayList<Observacao>();
		setId(id);
		setDia(dia);
		setHora(hora);
		setDuracao(duracao);
		setPaciente(paciente);
		setMedico(medico);
	}
	
	
	
	//GETS
	
	public double getDuracao() {
		return duracaoMinutos;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public Medico getMedico() {
		return medico;
	}

	public LocalDate getDia() {
		return dia;
	}
	public LocalTime getHora() {
		return hora;
	}
	
	public int getId() {
		return id;
	}
	
	public List<Observacao> getObservacao() {
		if(this.observacao == null){
			this.observacao = new ArrayList<Observacao>();
		}
		return observacao;
	}
	
	//SETS
	
	public void setDuracao(int duracao) {
		this.duracaoMinutos = duracao;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public void setDia(LocalDate dia) {
		this.dia = dia;
	}
	
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setObservacao(Observacao observacao) {
		if(this.observacao == null){
			this.observacao = new ArrayList<Observacao>();
		}
		this.observacao.add(observacao);
	}
	
	//SOBRESCRITAS
	@Override
	public String toString() {
		return this.id + " : " + paciente.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return getId() == ((Consulta) obj).getId();
	}
	

	
	
	
}
