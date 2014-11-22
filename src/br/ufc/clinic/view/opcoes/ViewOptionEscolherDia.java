package br.ufc.clinic.view.opcoes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import br.ufc.clinic.classes.DiaSemana;

public class ViewOptionEscolherDia extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private DiaSemana dia;

	public ViewOptionEscolherDia() {
		setBounds(100, 100, 414, 372);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblHorariosLivresMedicos = new JLabel("Escolha um Dia da Semana");
			lblHorariosLivresMedicos.setFont(new Font("Dialog", Font.BOLD, 18));
			lblHorariosLivresMedicos.setBounds(59, 13, 312, 41);
			contentPanel.add(lblHorariosLivresMedicos);
		}
			final JRadioButton Segunda = new JRadioButton("Segunda");
			Segunda.setBounds(27, 62, 149, 23);
			contentPanel.add(Segunda);
		
			final JRadioButton Terca = new JRadioButton("Terça");
			Terca.setBounds(27, 89, 149, 23);
			contentPanel.add(Terca);
	
			final JRadioButton Quarta = new JRadioButton("Quarta");
			Quarta.setBounds(27, 121, 149, 23);
			contentPanel.add(Quarta);
		
			final JRadioButton Quinta = new JRadioButton("Quinta");
			Quinta.setBounds(27, 148, 149, 23);
			contentPanel.add(Quinta);
		
			final JRadioButton Sexta = new JRadioButton("Sexta");
			Sexta.setBounds(27, 176, 149, 23);
			contentPanel.add(Sexta);
		
			final JRadioButton Sabado = new JRadioButton("Sabado");
			Sabado.setBounds(27, 203, 149, 23);
			contentPanel.add(Sabado);
		
			final JRadioButton Domingo = new JRadioButton("Domingo");
			Domingo.setBounds(27, 237, 149, 23);
			contentPanel.add(Domingo);
		
			
			ButtonGroup group = new ButtonGroup();
			group.add(Segunda);
			group.add(Terca);
			group.add(Quarta);
			group.add(Quinta);
			group.add(Sexta);
			group.add(Sabado);
			group.add(Domingo);
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						if(Segunda.isSelected()){
							dia = DiaSemana.SEGUNDA;
						}else if(Terca.isSelected()){
							dia = DiaSemana.TERCA;
						}else if(Quarta.isSelected()){
							dia = DiaSemana.QUARTA;
						}else if(Quinta.isSelected()){
							dia = DiaSemana.QUINTA;
						}else if(Sexta.isSelected()){
							dia = DiaSemana.SEXTA;
						}else if(Sabado.isSelected()){
							dia = DiaSemana.SABADO;
						}else if(Domingo.isSelected()){
							dia = DiaSemana.DOMINGO;
						}
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
			setModal(true);
			setVisible(true);
	}
	
	public DiaSemana getDia(){
		return this.dia;
	}
}
