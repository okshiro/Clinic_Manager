package br.ufc.clinic.view.cadastros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.Conta;

public class ViewCadastroGerente extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNomeCompleto;
	private JTextField textUsuario;
	private JPasswordField passwordSenha;

	public ViewCadastroGerente(final Atendente atendente) {
		setBounds(100, 100, 452, 321);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	
			JLabel lblNonoGerente = new JLabel("Novo Gerente");
			lblNonoGerente.setFont(new Font("Dialog", Font.BOLD, 17));
			lblNonoGerente.setBounds(149, 12, 146, 15);
			contentPanel.add(lblNonoGerente);
		
			JLabel lblNome = new JLabel("Nome Completo");
			lblNome.setBounds(159, 39, 116, 15);
			contentPanel.add(lblNome);
	
		
		textNomeCompleto = new JTextField();
		textNomeCompleto.setBounds(111, 72, 198, 28);
		contentPanel.add(textNomeCompleto);
		textNomeCompleto.setColumns(10);
		
			JLabel labelUsuario = new JLabel("Usuário");
			labelUsuario.setBounds(179, 112, 70, 15);
			contentPanel.add(labelUsuario);
		
			textUsuario = new JTextField();
			textUsuario.setBounds(109, 128, 200, 28);
			contentPanel.add(textUsuario);
			textUsuario.setColumns(10);
		
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(179, 168, 70, 15);
		contentPanel.add(lblSenha);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(111, 195, 198, 31);
		contentPanel.add(passwordSenha);
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				JButton sairButton = new JButton("Sair");
				sairButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				sairButton.setActionCommand("OK");
				buttonPane.add(sairButton);
				getRootPane().setDefaultButton(sairButton);
			
				JButton cadastrarButton = new JButton("Cadastrar");
				cadastrarButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String nome = textNomeCompleto.getText();
						String usuario = textUsuario.getText();
						@SuppressWarnings("deprecation")
						String senha = passwordSenha.getText();
						atendente.cadastrarGerente(nome, new Conta(usuario, senha));
						JOptionPane.showMessageDialog(null, "Gerente Cadastrado Com Sucesso!!!");
						dispose();
					}
				});
				
				cadastrarButton.setActionCommand("Cancel");
				buttonPane.add(cadastrarButton);
			
		setModal(true);
		setVisible(true);
	}
}
