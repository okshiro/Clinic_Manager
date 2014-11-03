package br.ufc.clinic.classes;

import java.util.Date;

public class ConsultaParticular extends Consulta {

	private double valorPagar;
	
	//CONSTRUCTS
	
	public ConsultaParticular(Date horario, Paciente paciente, Medico medico) {
		super(horario, paciente, medico);
	}
	public ConsultaParticular(Date horario, Paciente paciente, Medico medico, double valorPagar) {
		super(horario, paciente, medico);
		setValorPagar(valorPagar);
	}

	public ConsultaParticular(double duracao, Date horario, Paciente paciente, Medico medico) {
		super(duracao, horario, paciente, medico);
	}
	public ConsultaParticular(double duracao, Date horario, Paciente paciente, Medico medico, double valorPagar) {
		super(duracao, horario, paciente, medico);
		setValorPagar(valorPagar);
	}

	
	//GETS
	
	public double getValorPagar() {
		return valorPagar;
	}

	//SETS
	
	public void setValorPagar(double valorPagar) {
		this.valorPagar = valorPagar;
	}
	
	

}
