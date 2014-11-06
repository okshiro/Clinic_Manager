package br.ufc.clinic;

import javax.swing.UIManager;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.Funcionario;
import br.ufc.clinic.controler.Controlador;
import br.ufc.clinic.view.ViewAtendente;




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
			@SuppressWarnings("unused")
			ViewAtendente window = new ViewAtendente((Atendente) usuario);
		}
		
	}

}
