package br.ufc.clinic.view.visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Consulta;
import br.ufc.clinic.classes.ConsultaParticular;
import br.ufc.clinic.classes.ConsultaPorPlano;
import br.ufc.clinic.repository.GenericRepository;

public class ViewVisualizarConsultasDia extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			ViewVisualizarConsultasDia dialog = new ViewVisualizarConsultasDia(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ViewVisualizarConsultasDia(LocalDate dia) {
		setBounds(100, 100, 450, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblConsultas = new JLabel("Consultas");
			lblConsultas.setFont(new Font("Dialog", Font.BOLD, 18));
			lblConsultas.setBounds(180, 12, 124, 15);
			contentPanel.add(lblConsultas);
		}
		{
			JLabel lblDia = new JLabel("Dia:" + dia.toString());
			lblDia.setBounds(22, 28, 240, 15);
			contentPanel.add(lblDia);
		}
			
			GenericRepository<ConsultaPorPlano> cplano = new GenericRepository<ConsultaPorPlano>("consulta_plano");
			GenericRepository<ConsultaParticular> cparticular = new GenericRepository<ConsultaParticular>("consulta_particular");
			cplano.create();
			cplano.load();
			cplano.pull();
			
			cparticular.create();
			cparticular.load();
			cparticular.pull();
			
			final java.util.List<Consulta> consultas = new ArrayList<Consulta>();
			for(ConsultaParticular cp: cparticular.get()){
				consultas.add(cp);
			}
			for(ConsultaPorPlano cp: cplano.get()){
				consultas.add(cp);
			}
			
			final List listConsultas = new List();
			
			for(Consulta c : consultas){
				if(c.getDia().equals(dia)){
					listConsultas.add(c.toString());
				}
			}
			
			listConsultas.setBounds(10, 50, 410, 222);
			contentPanel.add(listConsultas);

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
						String select = listConsultas.getSelectedItem();
						if(select == null){
							JOptionPane.showMessageDialog(null, "Selecione uma Consulta!!!");
							return;
						}
						int i = select.indexOf(":");
						int id;
						try {
							id = Integer.parseInt( select.substring(0, i-1));
						} catch (Exception e2) {
							e2.printStackTrace();
							return;
						}

						Consulta con = null;
						for(Consulta c : consultas){
							if(c.getId() == id){
								con = c;
							}
						}
						
						if(con == null){
							return;
						}
						if(con instanceof ConsultaParticular){
							@SuppressWarnings("unused")
							ViewConsultaParticular cp = new ViewConsultaParticular((ConsultaParticular)con);
						}else if(con instanceof ConsultaPorPlano){
							@SuppressWarnings("unused")
							ViewConsultaPorPlano cp = new ViewConsultaPorPlano((ConsultaPorPlano)con);
						}
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
