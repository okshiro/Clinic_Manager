package br.ufc.clinic.view.cadastros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.ConsultaParticular;
import br.ufc.clinic.classes.Medico;
import br.ufc.clinic.classes.Paciente;

public class ViewCadastraConsultaParticular extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField dia;
	private JTextField hora;

	public ViewCadastraConsultaParticular(final Atendente atendente) {
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
			final JSpinner id = new JSpinner();
			id.setBounds(134, 73, 93, 20);
			contentPanel.add(id);
		
		
		JLabel lblMinDurao = new JLabel("Min Duração:");
		lblMinDurao.setBounds(26, 113, 108, 15);
		contentPanel.add(lblMinDurao);
		
		final JSpinner duracao = new JSpinner();
		duracao.setModel(new SpinnerNumberModel(new Integer(30), null, null, new Integer(1)));
		duracao.setBounds(134, 111, 94, 20);
		contentPanel.add(duracao);
		
		JLabel lblDia = new JLabel("Dia:");
		lblDia.setBounds(26, 153, 70, 15);
		contentPanel.add(lblDia);
		
		dia = new JTextField();
		dia.setText(LocalDate.now().toString());
		dia.setBounds(134, 151, 94, 19);
		contentPanel.add(dia);
		dia.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(26, 187, 70, 15);
		contentPanel.add(lblHora);
		
		hora = new JTextField();
		hora.setText(LocalTime.now().toString());
		hora.setBounds(134, 185, 93, 19);
		contentPanel.add(hora);
		hora.setColumns(10);
		
		JLabel lblPre = new JLabel("Preço");
		lblPre.setBounds(26, 227, 70, 15);
		contentPanel.add(lblPre);
		
		final JSpinner preco = new JSpinner();
		preco.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		preco.setBounds(134, 225, 93, 20);
		contentPanel.add(preco);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(298, 78, 70, 15);
		contentPanel.add(lblPaciente);
		
		
		final List pacientes = new List();
		
		for(Paciente p : atendente.getListaPaciente()){
			pacientes.add(p.toString());
		}
		
		pacientes.setBounds(244, 113, 172, 242);
		contentPanel.add(pacientes);
		
		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setBounds(479, 75, 70, 15);
		contentPanel.add(lblMedico);
		
		final List medicos = new List();
		for(Medico m : atendente.getListaMedico()){
			medicos.add(m.toString());
		}
		
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
						int ident;
						try {
							ident =  Integer.parseInt(id.getValue().toString());
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Digite uma Identificação Valida!!!");
							return;
						}
						for(ConsultaParticular p: atendente.getListaConsultasParticular()){
							if(p.getId() == ident){
								JOptionPane.showMessageDialog(null, "Identificação já existe!!!");
								return;
							}
						}
						
						int min;
						try {
							min = Integer.parseInt(duracao.getValue().toString());
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Digite uma quantidade de minutos valida!!!");
							return;
						}
						LocalDate da;
						try {
							da = LocalDate.parse(dia.getText());
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Digite uma data Valida!!!");
							return;
						}
						LocalTime ho;
						try {
							ho = LocalTime.parse(hora.getText());
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Digite uma hora valida!!!");
							return;
						}
						double pre;
						try {
							pre = Double.parseDouble(preco.getValue().toString());
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Digite um preco Valido!!!");
							return;
						}
						
						String pacienteString = pacientes.getSelectedItem();
						String medicoString = medicos.getSelectedItem();
						
						if(pacienteString == null){
							JOptionPane.showMessageDialog(null, "Selecione um Paciente!!");
							return;
						}
						if(medicoString == null){
							JOptionPane.showMessageDialog(null, "Selecione um Medico!!");
							return;
						}
						int indexPaciente = pacienteString.indexOf("-");
						int indexMedico = medicoString.indexOf("-");
						
						String nomePaciente = pacienteString.substring(0, indexPaciente);
						String nomeMedico = medicoString.substring(0, indexMedico);
						long cpf = Long.parseLong(pacienteString.substring(indexPaciente+1, pacienteString.length()));
						long crm = Long.parseLong(medicoString.substring(indexMedico+1, medicoString.length()));
						
						Paciente p = new Paciente(nomePaciente, cpf);
						Medico m = new Medico(nomeMedico, crm);
						
						atendente.cadastrarConsultaParticular(ident, min, da, ho, p, m, pre);
						JOptionPane.showMessageDialog(null, "Consulta cadastrada com Sucesso!!!");
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
		}
		setModal(true);
		setVisible(true);
	}
}
