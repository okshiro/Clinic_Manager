package br.ufc.clinic.view.opcoes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class ViewOptionConsultarMedico extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private int opcao;

	public ViewOptionConsultarMedico() {
		opcao = -1;
		setBounds(100, 100, 468, 249);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEscolhaUmaOpo = new JLabel("Escolha uma opção!");
		lblEscolhaUmaOpo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEscolhaUmaOpo.setBounds(120, 12, 245, 36);
		contentPanel.add(lblEscolhaUmaOpo);
		
		final JRadioButton especialidade = new JRadioButton("Consultar Medicos por Especialidade");
		especialidade.setBounds(8, 56, 414, 23);
		contentPanel.add(especialidade);
		
		final JRadioButton especialidadeDia = new JRadioButton("Consultar Medicos por Especialidades + Dias que Trabalha");
		especialidadeDia.setBounds(8, 98, 513, 23);
		contentPanel.add(especialidadeDia);
		
		ButtonGroup group = new ButtonGroup();
		group.add(especialidade);
		group.add(especialidadeDia);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						if(especialidade.isSelected()){
							opcao = 1;
							dispose();
						}else if(especialidadeDia.isSelected()){
							opcao = 2;
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "Por favor, escolhar uma opção!!!");
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

	public int getOpcao() {
		return opcao;
	}
}
