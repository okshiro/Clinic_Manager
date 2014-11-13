package br.ufc.clinic.view.visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.DiaSemana;
import br.ufc.clinic.classes.Endereco;
import br.ufc.clinic.classes.Especialidade;
import br.ufc.clinic.classes.Medico;
import br.ufc.clinic.classes.Telefone;
import br.ufc.clinic.ferramentas.Ferramentas;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMedico extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewMedico dialog = new ViewMedico(new Medico("sds",232));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewMedico(Medico m) {
		setBounds(100, 100, 731, 506);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblMedico = new JLabel("Medico");
			lblMedico.setFont(new Font("Dialog", Font.BOLD, 19));
			lblMedico.setBounds(329, 12, 152, 15);
			contentPanel.add(lblMedico);
		}
		{
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setBounds(30, 51, 70, 15);
			contentPanel.add(lblNome);
		}
		{
			JLabel lblCrm = new JLabel("CRM:");
			lblCrm.setBounds(30, 85, 70, 15);
			contentPanel.add(lblCrm);
		}
		{
			JLabel lblEnderecos = new JLabel("Enderecos:");
			lblEnderecos.setBounds(307, 51, 105, 15);
			contentPanel.add(lblEnderecos);
		}
		{
			List listEnderecos = new List();
			for(Endereco e : m.getEnderecos()){
				listEnderecos.add(e.toString());
			}
			
			listEnderecos.setBounds(397, 55, 304, 137);
			contentPanel.add(listEnderecos);
		}
		{
			JLabel lblTelefones = new JLabel("Telefones:");
			lblTelefones.setBounds(307, 206, 84, 15);
			contentPanel.add(lblTelefones);
		}
		{
			List listTelefones = new List();
			for(Telefone t : m.getTelefones()){
				listTelefones.add(t.toString());
			}
			
			listTelefones.setBounds(397, 200, 304, 127);
			contentPanel.add(listTelefones);
		}
		{
			JLabel lblEspecialidades = new JLabel("Especialidades:");
			lblEspecialidades.setBounds(65, 128, 121, 15);
			contentPanel.add(lblEspecialidades);
		}
		{
			List listEspecialidades = new List();
			for(Especialidade e : m.getEspecialidades()){
				listEspecialidades.add(e.toString());
			}
			listEspecialidades.setBounds(10, 149, 244, 112);
			contentPanel.add(listEspecialidades);
		}
		{
			JLabel lblDiasQueTrabalha = new JLabel("Dias que Trabalha:");
			lblDiasQueTrabalha.setBounds(58, 267, 152, 22);
			contentPanel.add(lblDiasQueTrabalha);
		}
		{
			List listDiasTrabalha = new List();
			for(DiaSemana d : m.getDiasTrabalha()){
				listDiasTrabalha.add(Ferramentas.DiaSemanaToString(d));
			}
			listDiasTrabalha.setBounds(10, 311, 244, 102);
			contentPanel.add(listDiasTrabalha);
		}
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
		}
		setModal(true);
		setVisible(true);
	}

}
