package br.ufc.clinic.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Paciente;
import br.ufc.clinic.repository.GenericRepository;

public class ViewVisualizarPaciente extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			ViewVisualizarPaciente dialog = new ViewVisualizarPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ViewVisualizarPaciente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel labelPacientes = new JLabel("Pacientes Cadastrados");
		labelPacientes.setFont(new Font("Dialog", Font.BOLD, 20));
		labelPacientes.setBounds(93, 12, 284, 15);
		contentPanel.add(labelPacientes);
		
		final List listPacientes = new List();
		
		final GenericRepository<Paciente> pacientes = new GenericRepository<Paciente>("paciente");
		pacientes.create();
		pacientes.load();
		pacientes.pull();
		for (Paciente p : pacientes.get()) {
			listPacientes.add(p.toString());
		}
		
		
		listPacientes.setBounds(0, 40, 430, 177);
		contentPanel.add(listPacientes);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Sair");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				okButton.setActionCommand("Sair");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton detalhesButton = new JButton("Detalhes");
				detalhesButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String select = listPacientes.getSelectedItem();
						int index = select.indexOf("-");
						
						String nome = select.substring(0, index);
						long cpf = Long.parseLong(select.substring(index+1, select.length()));
						
						Paciente p = new Paciente(nome, cpf);
						for (Paciente pac  : pacientes.get()) {
							if(p.equals(pac)){
								System.out.println("Rolou");
								@SuppressWarnings("unused")
								ViewPaciente viewPaciente = new ViewPaciente(pac);
								break;
							}
						}
					}
				});
				buttonPane.add(detalhesButton);
			}
		}
		
		setVisible(true);
		setModal(true);
	}
}
