package br.ufc.clinic.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Paciente;

public class ViewPaciente extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewPaciente dialog = new ViewPaciente(new Paciente("d"));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ViewPaciente(Paciente p) {
		setBounds(100, 100, 450, 300);
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
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setBounds(12, 110, 80, 17);
		contentPanel.add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(12, 150, 70, 15);
		contentPanel.add(lblTelefone);
		
		JLabel nome = new JLabel(p.getNome());
		nome.setBounds(66, 42, 352, 15);
		contentPanel.add(nome);
		
		JLabel cpf = new JLabel(Long.toString(p.getCpf()));
		cpf.setBounds(64, 76, 354, 15);
		contentPanel.add(cpf);
		JLabel endereco;
		if(p.getEnderecos().size() > 0){
			 endereco= new JLabel(p.getEnderecos().get(0).toString());
		}else{
			endereco= new JLabel("Vazio");
		}
		
		endereco.setBounds(88, 111, 330, 15);
		contentPanel.add(endereco);
		
		
		
		JLabel telefone; 
		if(p.getTelefones().size() > 0){
			telefone = new JLabel(p.getTelefones().get(0).toString());
		}else{
			telefone = new JLabel("Vazio");
		}
		telefone.setBounds(88, 150, 330, 15);
		contentPanel.add(telefone);
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
