package br.ufc.clinic.view.visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Endereco;
import br.ufc.clinic.classes.Paciente;
import br.ufc.clinic.classes.Telefone;

import java.awt.List;

public class ViewPaciente extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public ViewPaciente(Paciente p) {
		setBounds(100, 100, 600, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(181, 0, 70, 15);
		contentPanel.add(lblPaciente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 42, 70, 15);
		contentPanel.add(lblNome);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(12, 76, 70, 15);
		contentPanel.add(lblCpf);
		
		JLabel lblEndereco = new JLabel("Enderecos");
		lblEndereco.setBounds(97, 145, 80, 17);
		contentPanel.add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("Telefones");
		lblTelefone.setBounds(426, 146, 70, 15);
		contentPanel.add(lblTelefone);
		
		JLabel nome = new JLabel(p.getNome());
		nome.setBounds(66, 42, 352, 15);
		contentPanel.add(nome);
		
		
		JLabel cpf = new JLabel(Long.toString(p.getCpf()));
		cpf.setBounds(64, 76, 354, 15);
		contentPanel.add(cpf);
		
		
		
		List listEnderecos = new List();
		
		for(Endereco e : p.getEnderecos()){
			listEnderecos.add(e.toString());
		}
		
		listEnderecos.setBounds(12, 168, 315, 169);
		contentPanel.add(listEnderecos);
		
		
		
		List listTelefones = new List();
		
		for(Telefone t : p.getTelefones()){
			listTelefones.add(t.toString());
		}
		
		
		listTelefones.setBounds(348, 167, 222, 168);
		contentPanel.add(listTelefones);
		
		
		
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
