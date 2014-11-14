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

import br.ufc.clinic.classes.ConsultaPorPlano;
import br.ufc.clinic.repository.GenericRepository;

public class ViewVisualizarConsultaPorPlano extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			ViewVisualizarConsultaPorPlano dialog = new ViewVisualizarConsultaPorPlano();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewVisualizarConsultaPorPlano() {
		setBounds(100, 100, 402, 394);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblConsultas = new JLabel("Consultas Por Plano");
			lblConsultas.setFont(new Font("Dialog", Font.BOLD, 19));
			lblConsultas.setBounds(83, 12, 244, 15);
			contentPanel.add(lblConsultas);
		}
			
			final GenericRepository<ConsultaPorPlano> cplano = new GenericRepository<ConsultaPorPlano>("consulta_plano");
			cplano.create();
			cplano.pull();
			
			final List consultas = new List();
			for(ConsultaPorPlano p : cplano.get()){
				consultas.add(p.toString());
			}
			
			consultas.setBounds(10, 41, 362, 260);
			contentPanel.add(consultas);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton sair = new JButton("Sair");
				sair.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				sair.setActionCommand("SAIR");
				buttonPane.add(sair);
				getRootPane().setDefaultButton(sair);
			}
			
				JButton detalhes= new JButton("Detalhes");
				detalhes.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String consultaText = consultas.getSelectedItem();
						if(consultaText == null){
							JOptionPane.showMessageDialog(null, "Selecione uma Consulta!!!");
							return;
						}
						

						int i = consultaText.indexOf(":");
						int id;
						try {
							id = Integer.parseInt( consultaText.substring(0, i-1));
						} catch (Exception e2) {
							e2.printStackTrace();
							return;
						}
						for(ConsultaPorPlano p : cplano.get()){
							if(p.getId() == id){
								@SuppressWarnings("unused")
								ViewConsultaPorPlano consPlano = new ViewConsultaPorPlano(p);
								return;
							};
						}
					}
				});
				detalhes.setActionCommand("Detalhes");
				buttonPane.add(detalhes);
			
				JButton excluir = new JButton("Excluir");
				excluir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String consultaText = consultas.getSelectedItem();
						if(consultaText == null){
							JOptionPane.showMessageDialog(null, "Selecione uma Consulta!!!");
							return;
						}
						if(JOptionPane.showConfirmDialog(null, "Desejá apagar essa Consulta?") > 0){
							return;
						}
						
						int i = consultaText.indexOf(":");
						int id;
						try {
							id = Integer.parseInt( consultaText.substring(0, i-1));
						} catch (Exception e2) {
							e2.printStackTrace();
							return;
						}
						for(ConsultaPorPlano p : cplano.get()){
							if(p.getId() == id){
								cplano.rem(p);
								consultas.remove(consultas.getSelectedIndex());
								JOptionPane.showMessageDialog(null, "Consulta Removida com Sucesso!!!");
								return;
							};
						}
					}
				});
				excluir.setActionCommand("Cancel");
				buttonPane.add(excluir);
		}
		setModal(true);
		setVisible(true);
	}

}
