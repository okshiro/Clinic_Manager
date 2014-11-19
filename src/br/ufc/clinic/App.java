package br.ufc.clinic;

import javax.swing.UIManager;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.Funcionario;
import br.ufc.clinic.classes.Medico;
import br.ufc.clinic.controler.Controlador;
import br.ufc.clinic.view.visoes.ViewAtendente;
import br.ufc.clinic.view.visoes.ViewMedico;


public class App {

	private static Controlador control;
	private static Funcionario usuario;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		control = new Controlador();
		usuario = control.login();
		if(usuario != null){
			if(usuario instanceof Atendente){
				@SuppressWarnings("unused")
				ViewAtendente window = new ViewAtendente((Atendente) usuario);
			}else if(usuario instanceof Medico){
				@SuppressWarnings("unused")
				ViewMedico window = new ViewMedico((Medico) usuario);
			}
		}
		
		
	}

}
