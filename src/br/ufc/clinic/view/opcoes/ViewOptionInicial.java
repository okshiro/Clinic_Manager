package br.ufc.clinic.view.opcoes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class ViewOptionInicial extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private int option;
	
	public ViewOptionInicial() {
		setBounds(100, 100, 438, 218);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSejBemVindo = new JLabel("Sejá Bem Vindo!!!");
			lblSejBemVindo.setFont(new Font("Dialog", Font.BOLD, 19));
			lblSejBemVindo.setBounds(119, 12, 206, 23);
			contentPanel.add(lblSejBemVindo);
		}
		
		final JRadioButton rdbtnEntrar = new JRadioButton("Fazer Login");
		rdbtnEntrar.setBounds(139, 64, 149, 23);
		contentPanel.add(rdbtnEntrar);
		
		final JRadioButton rdbtnCriarConta = new JRadioButton("Criar Conta");
		rdbtnCriarConta.setBounds(139, 106, 149, 23);
		contentPanel.add(rdbtnCriarConta);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnEntrar);
		group.add(rdbtnCriarConta);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						if(rdbtnEntrar.isSelected()){
							option = 1;
							dispose();
						}else if(rdbtnCriarConta.isSelected()){
							option = 2;
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "Escolhar uma Opção!!!");
						}
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
						option = -1;
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

	public int getOption() {
		return option;
	}
}
