package br.ufc.clinic.view;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ViewLogin extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField usuario;
	private JPasswordField senha;
	private JButton entrar;
	private JButton sair;
	private Boolean acepted = false;
	
	public ViewLogin() {
		this.usuario = new JTextField(15);
		this.senha = new JPasswordField(15);
		this.entrar = new JButton("Entrar");
		this.entrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				acepted = true;
				dispose();
			}
		});
		
		this.sair = new JButton("Sair");
		this.sair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				acepted = false;
				dispose();
			}
		});
		
		
		JLabel labelUsuario = new JLabel("usuário");
		JLabel labelSenha = new JLabel("Senha");
		
		add(labelUsuario);
		add(usuario);
		add(labelSenha);
		add(senha);
		add(entrar);
		add(sair);
		
		setModal(true);
		setSize(300, 200);
		setLayout(new FlowLayout());
		setVisible(true);
	}
	
	public String getUsuario(){
		return this.usuario.getText();
	}
	@SuppressWarnings("deprecation")
	public String getSenha(){
		return this.senha.getText();
	}
	

	public ViewLogin(Frame owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Dialog owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Window owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Frame owner, boolean modal) {
		super(owner, modal);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Frame owner, String title) {
		super(owner, title);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Dialog owner, boolean modal) {
		super(owner, modal);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Dialog owner, String title) {
		super(owner, title);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Window owner, ModalityType modalityType) {
		super(owner, modalityType);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Window owner, String title) {
		super(owner, title);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Dialog owner, String title, boolean modal) {
		super(owner, title, modal);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Window owner, String title, ModalityType modalityType) {
		super(owner, title, modalityType);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Frame owner, String title, boolean modal,
			GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Dialog owner, String title, boolean modal,
			GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		// TODO Auto-generated constructor stub
	}

	public ViewLogin(Window owner, String title, ModalityType modalityType,
			GraphicsConfiguration gc) {
		super(owner, title, modalityType, gc);
		// TODO Auto-generated constructor stub
	}

	public Boolean isAcepted() {
		return acepted;
	}

}
