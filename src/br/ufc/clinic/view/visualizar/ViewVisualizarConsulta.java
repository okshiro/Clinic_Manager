package br.ufc.clinic.view.visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Consulta;
import javax.swing.JLabel;
import java.awt.Font;

public class ViewVisualizarConsulta extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			ViewVisualizarConsulta dialog = new ViewVisualizarConsulta(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewVisualizarConsulta(List<Consulta> consultas) {
		setBounds(100, 100, 450, 433);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblSuasConsultas = new JLabel("Suas Consultas");
		lblSuasConsultas.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSuasConsultas.setBounds(138, 12, 180, 15);
		contentPanel.add(lblSuasConsultas);
		
		java.awt.List listConsultas = new java.awt.List();
		if(consultas == null){
			System.out.println("Lista de Consultas Vazia para Visualizar");
			return;
		}
		for(Consulta c : consultas){
			listConsultas.add(c.toString());
			System.out.println("sd");
		}
		
		
		listConsultas.setBounds(10, 33, 410, 307);
		contentPanel.add(listConsultas);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setModal(true);
		setVisible(true);
	}
}
