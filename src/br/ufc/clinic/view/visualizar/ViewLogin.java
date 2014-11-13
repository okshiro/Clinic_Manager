package br.ufc.clinic.view.visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewLogin extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JPasswordField textSenha;
	private boolean acepted;

	public ViewLogin() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblRealizarLogin = new JLabel("Realizar Login");
			lblRealizarLogin.setFont(new Font("Dialog", Font.BOLD, 20));
			lblRealizarLogin.setBounds(128, 12, 186, 29);
			contentPanel.add(lblRealizarLogin);
		}
		{
			JLabel lblUsurio = new JLabel("usuário");
			lblUsurio.setFont(new Font("Dialog", Font.BOLD, 14));
			lblUsurio.setBounds(179, 53, 70, 15);
			contentPanel.add(lblUsurio);
		}
		{
			textUsuario = new JTextField();
			textUsuario.setBounds(112, 80, 196, 26);
			contentPanel.add(textUsuario);
			textUsuario.setColumns(10);
		}
		{
			JLabel lblSenha = new JLabel("Senha");
			lblSenha.setFont(new Font("Dialog", Font.BOLD, 14));
			lblSenha.setBounds(179, 126, 70, 15);
			contentPanel.add(lblSenha);
		}
		
		textSenha = new JPasswordField();
		textSenha.setBounds(112, 159, 196, 26);
		contentPanel.add(textSenha);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						acepted = true;
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener(
						) {
					
					public void actionPerformed(ActionEvent e) {
						acepted = false;
						setVisible(false);
					}
				});
				
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setModal(true);
		setVisible(true);
	}
	
	public String getUsuario(){
		return this.textUsuario.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getSenha(){
		return this.textSenha.getText();
	}
	

	public boolean isAcepted() {
		return acepted;
	}
}
