package br.ufc.clinic.view.visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.DiaSemana;
import br.ufc.clinic.classes.Medico;

public class ViewVisualizarHorariosLivres extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public ViewVisualizarHorariosLivres(final Atendente atendente, DiaSemana dia) {
		setBounds(100, 100, 499, 440);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblMedicosComEsse = new JLabel("Medicos com Esse Dia Livre");
			lblMedicosComEsse.setFont(new Font("Dialog", Font.BOLD, 18));
			lblMedicosComEsse.setBounds(98, 12, 347, 29);
			contentPanel.add(lblMedicosComEsse);
		}
		
		
		java.util.List<Medico> modalMedicos = atendente.horariosLivres(dia);
		
		final List listaMedicos = new List();
		for(Medico m : modalMedicos){
			listaMedicos.add(m.toString());
		}
		
		listaMedicos.setBounds(10, 55, 459, 302);
		contentPanel.add(listaMedicos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton sairButton = new JButton("Sair");
				sairButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				sairButton.setActionCommand("OK");
				buttonPane.add(sairButton);
				getRootPane().setDefaultButton(sairButton);
			}
			{
				JButton visualizarButton = new JButton("Visualizar");
				visualizarButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String select = listaMedicos.getSelectedItem();
						if(select == null){
							JOptionPane.showMessageDialog(null, "Selecione um Medico!!");
							return;
						}
						
						int index = select.indexOf("-");
						
						String nome = select.substring(0, index);
						long crm = Long.parseLong(select.substring(index+1, select.length()));
						@SuppressWarnings("unused")
						ViewMedico verMedico = new ViewMedico(atendente.getMedicoOriginal(new Medico(nome, crm)));
					}
				});
				visualizarButton.setActionCommand("Cancel");
				buttonPane.add(visualizarButton);
			}
		}
		setModal(true);
		setVisible(true);
	}
}
