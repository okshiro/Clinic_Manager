package br.ufc.clinic.view.cadastros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.controler.Controlador;

public class ViewCadastroAtendente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField usuario;
	private JTextField nome;
	private JPasswordField senha;

	public ViewCadastroAtendente(final Controlador control) {
		setBounds(100, 100, 481, 418);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCadastrarNovoAdministrador = new JLabel("Novo Atendente");
		lblCadastrarNovoAdministrador.setFont(new Font("Dialog", Font.BOLD, 19));
		lblCadastrarNovoAdministrador.setBounds(144, 12, 196, 15);
		contentPanel.add(lblCadastrarNovoAdministrador);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(199, 126, 70, 15);
		contentPanel.add(lblUsurio);
		
		usuario = new JTextField();
		usuario.setBounds(126, 153, 220, 28);
		contentPanel.add(usuario);
		usuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(217, 203, 52, 15);
		contentPanel.add(lblSenha);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(166, 55, 123, 15);
		contentPanel.add(lblNomeCompleto);
		
		nome = new JTextField();
		nome.setBounds(126, 82, 220, 32);
		contentPanel.add(nome);
		nome.setColumns(10);
		
		senha = new JPasswordField();
		senha.setBounds(126, 238, 220, 28);
		contentPanel.add(senha);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						control.cadastrarAtendente(nome.getText(), usuario.getText(), senha.getText());
						JOptionPane.showMessageDialog(null, "Atendente Cadastrado com Sucesso!!");
						dispose();
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setModal(true);
		setVisible(true);
	}
}
