package br.ufc.clinic.classes;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaPorPlano extends Consulta {
	private static final long serialVersionUID = 1L;
	private PlanoSaude planoSaude;
	

	public ConsultaPorPlano(int id, int duracao, LocalDate dia, LocalTime hora, Paciente paciente, Medico medico) {
		super(id, duracao, dia, hora, paciente, medico);
	}

	
	//GETS
	
	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}

	
	//SETS
	
	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}

}
