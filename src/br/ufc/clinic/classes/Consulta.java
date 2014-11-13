package br.ufc.clinic.classes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
	
	private int id;
	
	private int duracaoMinutos;
	private LocalDate dia;
	private LocalTime hora;
	
	private Paciente paciente;
	private Medico medico;	
	
	public Consulta(int id, int duracao, LocalDate dia, LocalTime hora, Paciente paciente, Medico medico) {
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
}
