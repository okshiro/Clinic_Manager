package br.ufc.clinic.classes;

import java.util.Date;

public class ConsultaPorPlano extends Consulta {

	private PlanoSaude planoSaude;
	
	public ConsultaPorPlano(Date horario, Paciente paciente, Medico medico) {
		super(horario, paciente, medico);
	}
	
	public ConsultaPorPlano(Date horario, Paciente paciente, Medico medico, PlanoSaude planoSaude) {
		super(horario, paciente, medico);
		setPlanoSaude(planoSaude);
	}

	public ConsultaPorPlano(double duracao, Date horario, Paciente paciente, Medico medico) {
		super(duracao, horario, paciente, medico);
	}
	public ConsultaPorPlano(double duracao, Date horario, Paciente paciente, Medico medico, PlanoSaude planoSaude) {
		super(duracao, horario, paciente, medico);
		setPlanoSaude(planoSaude);
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
