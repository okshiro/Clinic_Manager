package br.ufc.clinic.view.visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.ConsultaParticular;

public class ViewConsultaParticular extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	public ViewConsultaParticular(ConsultaParticular consultaParticular) {
		setBounds(100, 100, 516, 372);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblConsultaParticular = new JLabel("Consulta Particular");
			lblConsultaParticular.setFont(new Font("Dialog", Font.BOLD, 19));
			lblConsultaParticular.setBounds(142, 12, 237, 15);
			contentPanel.add(lblConsultaParticular);
		}
		{
			JLabel lblIdentificao = new JLabel("Identificação:");
			lblIdentificao.setBounds(29, 58, 118, 15);
			contentPanel.add(lblIdentificao);
		}
		{
			JLabel lblDurao = new JLabel("Duração:");
			lblDurao.setBounds(29, 85, 70, 15);
			contentPanel.add(lblDurao);
		}
		{
			JLabel lblData = new JLabel("Data:");
			lblData.setBounds(29, 112, 70, 15);
			contentPanel.add(lblData);
		}
		{
			JLabel lblHora = new JLabel("Hora:");
			lblHora.setBounds(29, 139, 70, 15);
			contentPanel.add(lblHora);
		}
		{
			JLabel lblPaciente = new JLabel("Paciente:");
			lblPaciente.setBounds(29, 172, 70, 15);
			contentPanel.add(lblPaciente);
		}
		{
			JLabel lblMdico = new JLabel("Médico:");
			lblMdico.setBounds(29, 207, 70, 15);
			contentPanel.add(lblMdico);
		}
		
		JLabel identificacao = new JLabel(Integer.toString(consultaParticular.getId()));
		identificacao.setBounds(134, 58, 178, 15);
		contentPanel.add(identificacao);
		
		JLabel duracao = new JLabel(Double.toString(consultaParticular.getDuracao()));
		duracao.setBounds(111, 85, 178, 15);
		contentPanel.add(duracao);
		
		JLabel data = new JLabel(consultaParticular.getDia().toString());
		data.setBounds(77, 112, 158, 15);
		contentPanel.add(data);
		
		JLabel hora = new JLabel(consultaParticular.getHora().toString());
		hora.setBounds(77, 139, 128, 15);
		contentPanel.add(hora);
		
		JLabel paciente = new JLabel(consultaParticular.getPaciente().toString());
		paciente.setBounds(100, 172, 384, 15);
		contentPanel.add(paciente);
		
		JLabel medico = new JLabel(consultaParticular.getMedico().toString());
		medico.setBounds(90, 207, 394, 15);
		contentPanel.add(medico);
		{
			JLabel lblPreco = new JLabel("Preco:");
			lblPreco.setBounds(29, 235, 70, 15);
			contentPanel.add(lblPreco);
		}
		{
			JLabel preco = new JLabel(Double.toString(consultaParticular.getValorPagar()));
			preco.setBounds(90, 235, 70, 15);
			contentPanel.add(preco);
		}
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
				sairButton.setActionCommand("SAIR");
				buttonPane.add(sairButton);
				getRootPane().setDefaultButton(sairButton);
			}
		}
		setModal(true);
		setVisible(true);
	}
}
