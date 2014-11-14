package br.ufc.clinic.classes;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaParticular extends Consulta {
	private static final long serialVersionUID = 1L;
	private double valorPagar;
	
	//CONSTRUCTS
	
	public ConsultaParticular(int id, int duracao, LocalDate dia, LocalTime hora, Paciente paciente, Medico medico, double valor) {
		super(id, duracao, dia, hora, paciente, medico);
		setValorPagar(valor);
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
