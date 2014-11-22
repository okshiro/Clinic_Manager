package br.ufc.clinic.controler;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.Conta;
import br.ufc.clinic.classes.Funcionario;
import br.ufc.clinic.classes.Gerente;
import br.ufc.clinic.classes.Medico;
import br.ufc.clinic.repository.RepositoryManage;
import br.ufc.clinic.view.visualizar.ViewLogin;


public class Controlador {
	RepositoryManage<Object> rep = new RepositoryManage<Object>();	
	
	public Controlador(){
		rep.createRepositoryALL();
		rep.loadRepositoryALL();
		rep.pullRepositoryALL();
	}
	
	public Funcionario login(){
		
		
		ViewLogin login = new ViewLogin();
	
		String usuario = login.getUsuario();
		String senha = login.getSenha();
		
		if(login.isAcepted()){
			
			Conta contaLogin = new Conta(usuario,senha);
			
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			for (Atendente a : rep.getAtendentes().get()) {
				funcionarios.add(a);
			}
			
			for (Medico m : rep.getMedico().get()) {
				funcionarios.add(m);
			}
			
			for (Gerente g : rep.getGerentes().get()) {
				funcionarios.add(g);
			}
			
			for (Funcionario f : funcionarios) {
				if(f.getConta().equals(contaLogin)){
					JOptionPane.showMessageDialog(null, "Funcionario: " + usuario+" foi autenticado! :)");
					return f;
				}
			}
			JOptionPane.showMessageDialog(null, "Falha ao fazer login!!");
		}
		
		return null;
		
	}
	
	public void cadastrarAtendente(String nome, String usuario, String senha){
		Atendente a = new Atendente(nome, new Conta(usuario, senha),0);
		rep.getAtendentes().add(a);
		System.out.println("deus");
	}
	
}
