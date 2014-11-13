package br.ufc.clinic.view.cadastros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.Endereco;
import br.ufc.clinic.classes.Telefone;
import br.ufc.clinic.view.components.JTextFieldNumbers;

public class ViewCadastraPaciente extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textEstado;
	private JTextField textCidade;
	private JTextField textBairro;
	private JTextField textRua;
	private JTextField textComplemento;
	private JTextField textNumero;
	private JTextField textTelefone;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ViewCadastraPaciente v = new ViewCadastraPaciente(new Atendente("sds"));
	}
	
	public ViewCadastraPaciente(final Atendente atendente) {
		setVisible(true);
		setModal(true);
		setBounds(100, 100, 659, 506);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNovoPaciente = new JLabel("Novo Paciente");
		lblNovoPaciente.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblNovoPaciente.setBounds(278, 12, 117, 15);
		contentPanel.add(lblNovoPaciente);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(117, 62, 45, 15);
		contentPanel.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(12, 89, 269, 27);
		contentPanel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(128, 137, 26, 15);
		contentPanel.add(lblCpf);
		
		textCpf = new JTextFieldNumbers();
		textCpf.setBounds(12, 167, 269, 27);
		contentPanel.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(493, 29, 70, 15);
		contentPanel.add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setBounds(428, 66, 187, 27);
		contentPanel.add(textEstado);
		textEstado.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(493, 95, 70, 15);
		contentPanel.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setBounds(428, 128, 187, 27);
		contentPanel.add(textCidade);
		textCidade.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(493, 167, 70, 15);
		contentPanel.add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setBounds(428, 191, 187, 27);
		contentPanel.add(textBairro);
		textBairro.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(505, 220, 45, 19);
		contentPanel.add(lblRua);
		
		textRua = new JTextField();
		textRua.setBounds(428, 258, 187, 27);
		contentPanel.add(textRua);
		textRua.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(476, 289, 117, 15);
		contentPanel.add(lblComplemento);
		
		textComplemento = new JTextField();
		textComplemento.setBounds(428, 326, 187, 27);
		contentPanel.add(textComplemento);
		textComplemento.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(493, 355, 70, 15);
		contentPanel.add(lblNumero);
		
		textNumero = new JTextFieldNumbers();
		textNumero.setBounds(428, 382, 187, 29);
		contentPanel.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(105, 222, 97, 15);
		contentPanel.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(12, 249, 269, 23);
		contentPanel.add(textTelefone);
		textTelefone.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						Telefone telefone = new Telefone(textTelefone.getText());
						Endereco endereco = new Endereco(textEstado.getText(), 
												  textCidade.getText(), 
												  textBairro.getText(), 
												  textRua.getText(), 
												  textComplemento.getText(), 
												  Integer.parseInt(textNumero.getText()));
						atendente.cadastrarPaciente(textNome.getText(),Long.parseLong(textCpf.getText()), endereco, telefone);
						JOptionPane.showMessageDialog(null, "Paciente cadastrado com Sucesso!!!");
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
