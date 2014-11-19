package br.ufc.clinic.ferramentas;

import br.ufc.clinic.classes.DiaSemana;
import br.ufc.clinic.classes.TipoObservacao;

public class Ferramentas {
	public static String  DiaSemanaToString(DiaSemana d){
		return d == DiaSemana.DOMINGO ? "DOMINGO" : 
			   d == DiaSemana.SEGUNDA ? "SEGUNDA" :
			   d == DiaSemana.TERCA ? "TERCA" :
			   d == DiaSemana.QUARTA ? "QUARTA" :
			   d == DiaSemana.QUINTA ? "QUINTA" :
			   d == DiaSemana.SEXTA ? "SEXTA": "SABADO"; 
	}
	
	public static DiaSemana  StringToDiaSemana(String d){
		return d.equals("DOMINGO")  ? DiaSemana.DOMINGO  : 
			   d.equals("SEGUNDA")  ? DiaSemana.SEGUNDA  :
			   d.equals("TERCA")  ? DiaSemana.TERCA :
			   d.equals("QUARTA")  ? DiaSemana.QUARTA :
			   d.equals("QUINTA")  ? DiaSemana.QUINTA :
			   d.equals("SEXTA")  ? DiaSemana.SEXTA :  DiaSemana.SABADO; 
	}
	
	public static String TipoObservacaoToString(TipoObservacao t){
		return t == TipoObservacao.QUEIXAS ? "QUEIXAS" :
			   t == TipoObservacao.PREESCRIOES ? "PREESCRIÇÔES" : "RESULTADOS";
			  
	}
}
