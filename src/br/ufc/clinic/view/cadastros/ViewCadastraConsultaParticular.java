package br.ufc.clinic.view.cadastros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.List;

public class ViewCadastraConsultaParticular extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField dia;
	private JTextField hora;

	public static void main(String[] args) {
		try {
			ViewCadastraConsultaParticular dialog = new ViewCadastraConsultaParticular();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewCadastraConsultaParticular() {
		setBounds(100, 100, 635, 469);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCadastrarConsulta = new JLabel("Cadastrar Consulta");
			lblCadastrarConsulta.setFont(new Font("Dialog", Font.BOLD, 19));
			lblCadastrarConsulta.setBounds(211, 12, 218, 15);
			contentPanel.add(lblCadastrarConsulta);
		}
		{
			JLabel lblIdentificao = new JLabel("Identificação:");
			lblIdentificao.setBounds(26, 75, 108, 15);
			contentPanel.add(lblIdentificao);
		}
		{
			JSpinner id = new JSpinner();
			id.setBounds(134, 73, 93, 20);
			contentPanel.add(id);
		}
		
		JLabel lblMinDurao = new JLabel("Min Duração:");
		lblMinDurao.setBounds(26, 113, 108, 15);
		contentPanel.add(lblMinDurao);
		
		JSpinner duracao = new JSpinner();
		duracao.setBounds(134, 111, 94, 20);
		contentPanel.add(duracao);
		
		JLabel lblDia = new JLabel("Dia:");
		lblDia.setBounds(26, 153, 70, 15);
		contentPanel.add(lblDia);
		
		dia = new JTextField();
		dia.setBounds(134, 151, 94, 19);
		contentPanel.add(dia);
		dia.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(26, 187, 70, 15);
		contentPanel.add(lblHora);
		
		hora = new JTextField();
		hora.setBounds(134, 185, 93, 19);
		contentPanel.add(hora);
		hora.setColumns(10);
		
		JLabel lblPre = new JLabel("Preço");
		lblPre.setBounds(26, 227, 70, 15);
		contentPanel.add(lblPre);
		
		JSpinner preco = new JSpinner();
		preco.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		preco.setBounds(134, 225, 93, 20);
		contentPanel.add(preco);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(298, 78, 70, 15);
		contentPanel.add(lblPaciente);
		
		List pacientes = new List();
		pacientes.setBounds(244, 113, 172, 242);
		contentPanel.add(pacientes);
		
		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setBounds(479, 75, 70, 15);
		contentPanel.add(lblMedico);
		
		List medicos = new List();
		medicos.setBounds(424, 113, 181, 242);
		contentPanel.add(medicos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {	
						
					}
				});
				
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
	}
}
