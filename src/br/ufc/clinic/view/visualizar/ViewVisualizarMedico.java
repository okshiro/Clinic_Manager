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
import br.ufc.clinic.classes.Medico;

public class ViewVisualizarMedico extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	public ViewVisualizarMedico(Atendente atendente, final java.util.List<Medico> medicos){
		setBounds(100, 100, 462, 424);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblMedico = new JLabel("Medicos");
		lblMedico.setFont(new Font("Dialog", Font.BOLD, 17));
		lblMedico.setBounds(192, 12, 96, 20);
		contentPanel.add(lblMedico);
		
		final List listaMedicos = new List();
		
		for(Medico m : medicos){
			listaMedicos.add(m.toString());
		}
		
		
		
		listaMedicos.setBounds(10, 34, 422, 297);
		contentPanel.add(listaMedicos);
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
				okButton.setActionCommand("SAIR");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			{
				JButton excluirButton = new JButton("Excluir");
				excluirButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String select = listaMedicos.getSelectedItem();
						if(select == null){
							JOptionPane.showMessageDialog(null, "Selecione um Medico!!");
							return;
						}
						int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente Excluir esse Medico?");
						if(opcao > 0){
							return;
						}
						
						int index = select.indexOf("-");
						
						String nome = select.substring(0, index);
						long crm = Long.parseLong(select.substring(index+1, select.length()));
						listaMedicos.remove(listaMedicos.getSelectedIndex());
						medicos.remove(new Medico(nome, crm));
						JOptionPane.showMessageDialog(null, "Medico Removido com Sucesso!!!");
					}
				});
				excluirButton.setActionCommand("Excluir");
				buttonPane.add(excluirButton);
				getRootPane().setDefaultButton(excluirButton);
			}
			
			{
				JButton detalhesButton = new JButton("Detalhes");
				detalhesButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String select = listaMedicos.getSelectedItem();
						if(select == null){
							JOptionPane.showMessageDialog(null, "Selecione um Medico!!");
							return;
						}
						int index = select.indexOf("-");
						
						String nome = select.substring(0, index);
						long crm = Long.parseLong(select.substring(index+1, select.length()));
						
						Medico m = new Medico(nome, crm);
						for (Medico med  : medicos) {
							if(m.equals(med)){
								@SuppressWarnings("unused")
								ViewMedico viewMedico = new ViewMedico(med);
								break;
							}
						}
					}
				});
				
				detalhesButton.setActionCommand("DETALHES");
				buttonPane.add(detalhesButton);
			}
		}
		setModal(true);
		setVisible(true);
	}
	
	
	public ViewVisualizarMedico(Atendente atendente) {
		this(atendente, atendente.getListaMedico());
	}
}
