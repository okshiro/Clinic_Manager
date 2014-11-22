package br.ufc.clinic;

import javax.swing.UIManager;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.Funcionario;
import br.ufc.clinic.classes.Gerente;
import br.ufc.clinic.classes.Medico;
import br.ufc.clinic.controler.Controlador;
import br.ufc.clinic.view.cadastros.ViewCadastroAtendente;
import br.ufc.clinic.view.opcoes.ViewOptionInicial;
import br.ufc.clinic.view.visoes.ViewAtendente;
import br.ufc.clinic.view.visoes.ViewGerente;
import br.ufc.clinic.view.visoes.ViewMedico;


public class App {

	private static Controlador control;
	private static Funcionario usuario;
	
	public static void main(String[] args) {
		control = new Controlador();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ViewOptionInicial inicio = new ViewOptionInicial();
		
		int opcao = inicio.getOption();
		if(opcao == -1){
			System.exit(0);
		}else{
			if(opcao == 1){
				usuario = control.login();
				if(usuario != null){
					if(usuario instanceof Atendente){
						@SuppressWarnings("unused")
						ViewAtendente window = new ViewAtendente(new Atendente(usuario.getNome(), usuario.getConta()));
					}else if(usuario instanceof Medico){
						@SuppressWarnings("unused")
						ViewMedico window = new ViewMedico(new Medico(usuario.getNome(), usuario.getConta()));
					}else if(usuario instanceof Gerente){
						@SuppressWarnings("unused")
						ViewGerente window = new ViewGerente(new Gerente(usuario.getNome(), usuario.getConta()));
					}
				}
			}else if(opcao == 2){
				@SuppressWarnings("unused")
				ViewCadastroAtendente novoAdmin = new ViewCadastroAtendente(control);
			}
		}
		
		
		
		
	}

}
