package br.ufc.clinic.classes;

import java.util.Date;

public class Consulta {
	private double duracao;
	private Date horario;
	private Paciente paciente;
	private Medico medico;
	
	
	public Consulta(Date horario, Paciente paciente, Medico medico) {
		this(30, horario, paciente, medico);
	}
	public Consulta(double duracao, Date horario, Paciente paciente, Medico medico) {
		setDuracao(duracao);
		setHorario(horario);
		setPaciente(paciente);
		setMedico(medico);
	}
	
	
	
	//GETS
	
	public double getDuracao() {
		return duracao;
	}
	
	public Date getHorario() {
		return horario;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public Medico getMedico() {
		return medico;
	}

	
	//SETS
	
	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
	
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
}
