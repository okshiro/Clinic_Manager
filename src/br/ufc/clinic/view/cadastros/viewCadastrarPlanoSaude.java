package br.ufc.clinic.view.cadastros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.Endereco;
import br.ufc.clinic.classes.Telefone;
import br.ufc.clinic.view.components.JTextFieldNumbers;

public class viewCadastrarPlanoSaude extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField razaoSocial;
	private JTextField cnpj;
	private JTextField estado;
	private JTextField cidade;
	private JTextField bairro;
	private JTextField complemento;
	private JTextField numero;
	private JTextField telefone;
	private JTextField rua;

	public static void main(String[] args) {
		try {
			viewCadastrarPlanoSaude dialog = new viewCadastrarPlanoSaude(new Atendente("saad"));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public viewCadastrarPlanoSaude(final Atendente atendente) {
		setBounds(100, 100, 702, 516);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNovoPlanoDe = new JLabel("Novo Plano de Saúde");
			lblNovoPlanoDe.setFont(new Font("Dialog", Font.BOLD, 18));
			lblNovoPlanoDe.setBounds(238, 12, 231, 15);
			contentPanel.add(lblNovoPlanoDe);
		}
		{
			JLabel lblRazoSocial = new JLabel("Razão Social");
			lblRazoSocial.setBounds(65, 54, 107, 15);
			contentPanel.add(lblRazoSocial);
		}
		{
			razaoSocial = new JTextField();
			razaoSocial.setBounds(12, 81, 200, 30);
			contentPanel.add(razaoSocial);
			razaoSocial.setColumns(10);
		}
		{
			JLabel lblCnpj = new JLabel("CNPJ");
			lblCnpj.setBounds(90, 123, 70, 15);
			contentPanel.add(lblCnpj);
		}
		{
			cnpj = new JTextFieldNumbers();
			cnpj.setBounds(12, 149, 200, 30);
			contentPanel.add(cnpj);
			cnpj.setColumns(10);
		}
		{
			JLabel lblEstado = new JLabel("Estado");
			lblEstado.setBounds(484, 54, 70, 15);
			contentPanel.add(lblEstado);
		}
		{
			estado = new JTextField();
			estado.setBounds(414, 82, 200, 27);
			contentPanel.add(estado);
			estado.setColumns(10);
		}
		{
			JLabel lblCidade = new JLabel("Cidade");
			lblCidade.setBounds(484, 123, 70, 15);
			contentPanel.add(lblCidade);
		}
		{
			cidade = new JTextField();
			cidade.setBounds(414, 149, 200, 30);
			contentPanel.add(cidade);
			cidade.setColumns(10);
		}
		{
			JLabel lblBairro = new JLabel("Bairro");
			lblBairro.setBounds(484, 191, 70, 15);
			contentPanel.add(lblBairro);
		}
		{
			bairro = new JTextField();
			bairro.setBounds(414, 218, 200, 30);
			contentPanel.add(bairro);
			bairro.setColumns(10);
		}
		{
			JLabel lblComplemento = new JLabel("Complemento");
			lblComplemento.setBounds(467, 310, 107, 15);
			contentPanel.add(lblComplemento);
		}
		{
			complemento = new JTextField();
			complemento.setBounds(414, 337, 200, 30);
			contentPanel.add(complemento);
			complemento.setColumns(10);
		}
		{
			JLabel lblNumero = new JLabel("Numero");
			lblNumero.setBounds(484, 379, 70, 15);
			contentPanel.add(lblNumero);
		}
		{
			numero = new JTextFieldNumbers();
			numero.setBounds(414, 406, 200, 27);
			contentPanel.add(numero);
			numero.setColumns(10);
		}
		{
			JLabel lblTelefone = new JLabel("Telefone");
			lblTelefone.setBounds(77, 251, 86, 15);
			contentPanel.add(lblTelefone);
		}
		{
			telefone = new JTextField();
			telefone.setBounds(12, 272, 200, 27);
			contentPanel.add(telefone);
			telefone.setColumns(10);
		}
		{
			JLabel lblRua = new JLabel("Rua");
			lblRua.setBounds(504, 260, 70, 15);
			contentPanel.add(lblRua);
		}
		{
			rua = new JTextField();
			rua.setBounds(414, 277, 210, 27);
			contentPanel.add(rua);
			rua.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String razao = razaoSocial.getText();
						long cnp = Long.parseLong(cnpj.getText());
						Telefone tel = new Telefone(telefone.getText());
						Endereco end = new Endereco(estado.getText(), cidade.getText(), bairro.getText(),rua.getText(),complemento.getText(),Integer.parseInt(numero.getText()));
						atendente.cadastrarPlanoDeSaude(razao, cnp, end, tel);
						JOptionPane.showMessageDialog(null, "Plano de Saúde Adicionado com Sucesso!!!");
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
