package br.ufc.clinic.view.cadastros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.Conta;
import br.ufc.clinic.classes.DiaSemana;
import br.ufc.clinic.classes.Endereco;
import br.ufc.clinic.classes.Especialidade;
import br.ufc.clinic.classes.Telefone;
import br.ufc.clinic.ferramentas.Ferramentas;
import br.ufc.clinic.repository.GenericRepository;
import br.ufc.clinic.view.components.JTextFieldNumbers;

public class ViewCadastroMedico extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNome;
	private JTextField textCrm;
	private JTextField textEstado;
	private JTextField textCidade;
	private JTextField textBairro;
	private JTextField textRua;
	private JTextField textComplemento;
	private JTextField textNumero;
	private JTextField textTelefone;
	private JTextField textUsuario;
	private JPasswordField textSenha;

	public static void main(String[] args) {
		try {
			ViewCadastroMedico dialog = new ViewCadastroMedico(new Atendente("adojad"));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewCadastroMedico(final Atendente atendente) {
		setBounds(100, 100, 662, 618);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblCadastroMdico = new JLabel("Cadastro Médico");
			lblCadastroMdico.setFont(new Font("Dialog", Font.BOLD, 18));
			lblCadastroMdico.setBounds(241, 12, 197, 15);
			contentPanel.add(lblCadastroMdico);
		
		
			JLabel lblNomeCompleto = new JLabel("Nome Completo");
			lblNomeCompleto.setBounds(33, 49, 131, 15);
			contentPanel.add(lblNomeCompleto);
		
		
			textNome = new JTextField();
			textNome.setBounds(8, 71, 156, 19);
			contentPanel.add(textNome);
			textNome.setColumns(10);
		
		
			JLabel lblCrm = new JLabel("CRM");
			lblCrm.setBounds(68, 102, 70, 15);
			contentPanel.add(lblCrm);
		
		
			textCrm = new JTextFieldNumbers();
			textCrm.setBounds(8, 129, 156, 19);
			contentPanel.add(textCrm);
			textCrm.setColumns(10);
		
		
			JLabel lblEspecialidades = new JLabel("Especialidades");
			lblEspecialidades.setBounds(26, 160, 112, 15);
			contentPanel.add(lblEspecialidades);
			
			JLabel lblDiasQueTrabalha = new JLabel("Dias que Trabalha");
			lblDiasQueTrabalha.setBounds(8, 294, 156, 15);
			contentPanel.add(lblDiasQueTrabalha);
		
		
			JLabel lblEstado = new JLabel("Estado");
			lblEstado.setBounds(292, 49, 70, 15);
			contentPanel.add(lblEstado);
		
		
			
			textEstado = new JTextField();
			textEstado.setBounds(241, 71, 147, 19);
			contentPanel.add(textEstado);
			textEstado.setColumns(10);
		
		
			JLabel lblCidade = new JLabel("Cidade");
			lblCidade.setBounds(292, 102, 70, 15);
			contentPanel.add(lblCidade);
		
		
			textCidade = new JTextField();
			textCidade.setBounds(241, 129, 147, 19);
			contentPanel.add(textCidade);
			textCidade.setColumns(10);
		
		
			JLabel lblBairro = new JLabel("Bairro");
			lblBairro.setBounds(292, 160, 70, 15);
			contentPanel.add(lblBairro);
		
		
			textBairro = new JTextField();
			textBairro.setBounds(241, 187, 147, 19);
			contentPanel.add(textBairro);
			textBairro.setColumns(10);
		
		
			JLabel lblRua = new JLabel("Rua");
			lblRua.setBounds(303, 213, 70, 15);
			contentPanel.add(lblRua);
		
		
			textRua = new JTextField();
			textRua.setBounds(241, 240, 147, 19);
			contentPanel.add(textRua);
			textRua.setColumns(10);
		
		
			JLabel lblComplemento = new JLabel("Complemento");
			lblComplemento.setBounds(259, 271, 114, 15);
			contentPanel.add(lblComplemento);
		
		
			textComplemento = new JTextField();
			textComplemento.setBounds(241, 302, 147, 19);
			contentPanel.add(textComplemento);
			textComplemento.setColumns(10);
		
		
			JLabel lblNumero = new JLabel("Numero");
			lblNumero.setBounds(282, 335, 70, 15);
			contentPanel.add(lblNumero);
		
		
			textNumero = new JTextFieldNumbers();
			textNumero.setBounds(241, 362, 147, 19);
			contentPanel.add(textNumero);
			textNumero.setColumns(10);
		
		
			JLabel lblTelefone = new JLabel("Telefone");
			lblTelefone.setBounds(282, 391, 70, 15);
			contentPanel.add(lblTelefone);
		
		
			textTelefone = new JTextField();
			textTelefone.setBounds(241, 416, 147, 19);
			contentPanel.add(textTelefone);
			textTelefone.setColumns(10);
		
		
			JLabel lblNomeUsurio = new JLabel("Nome Usuário");
			lblNomeUsurio.setBounds(494, 131, 112, 15);
			contentPanel.add(lblNomeUsurio);
		
		
			textUsuario = new JTextField();
			textUsuario.setBounds(478, 158, 131, 19);
			contentPanel.add(textUsuario);
			textUsuario.setColumns(10);
		
		
			JLabel lblSenha = new JLabel("Senha");
			lblSenha.setBounds(516, 189, 70, 15);
			contentPanel.add(lblSenha);
		
		
			textSenha = new JPasswordField();
			textSenha.setBounds(478, 223, 128, 19);
			contentPanel.add(textSenha);
			textSenha.setColumns(10);
			
			Panel panelDias = new Panel();
			panelDias.setLayout(new FlowLayout(FlowLayout.LEFT));
			final JCheckBox domingo = new JCheckBox("DOMINGO");
			final JCheckBox segunda = new JCheckBox("SEGUNDA");
			final JCheckBox terca = new JCheckBox("TERCA");
			final JCheckBox quarta = new JCheckBox("QUARTA");
			final JCheckBox quinta = new JCheckBox("QUINTA");
			final JCheckBox sexta = new JCheckBox("SEXTA");
			final JCheckBox sabado = new JCheckBox("SABADO");
			
			final List<JCheckBox> listaDias = new ArrayList<JCheckBox>();
			listaDias.add(domingo);
			listaDias.add(segunda);
			listaDias.add(terca);
			listaDias.add(quarta);
			listaDias.add(quinta);
			listaDias.add(sexta);
			listaDias.add(sabado);
					
			for (JCheckBox j : listaDias) {
				panelDias.add(j);
			}
			
			panelDias.setBounds(8, 313, 100, 222);
			contentPanel.add(panelDias);
			
			
			GenericRepository<Especialidade> especialidades = new GenericRepository<Especialidade>("especialidade");
			if(!especialidades.exist()){
				especialidades.create();
			}
			especialidades.load();
			especialidades.pull();
			
			
			final java.awt.List listEsp = new java.awt.List();
			for (Especialidade e : especialidades.get()) {
				listEsp.add(e.toString());
			}
			
			
			
			listEsp.setBounds(8, 187, 156, 89);
			contentPanel.add(listEsp);
		
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						int numEndereco;
						try {
							numEndereco = Integer.parseInt(textNumero.getText());
						} catch (Exception e2) {
							numEndereco = 0;
						}
						
						Endereco end = new Endereco(textEstado.getText(), 
								                  textCidade.getText(), 
								                  textBairro.getText(), 
								                  textRua.getText(), 
								                  textComplemento.getText(), 
								                  numEndereco
								                  );
						Telefone tel = new Telefone(textTelefone.getText());
						
						@SuppressWarnings("deprecation")
						Conta con = new Conta(textUsuario.getText(), textSenha.getText());
						
						
						List<DiaSemana> dias = new ArrayList<DiaSemana>();
						for (JCheckBox j : listaDias) {
							if(j.isEnabled()){
								dias.add(Ferramentas.StringToDiaSemana(j.getText()));
							}
						}
						
						Especialidade esp = new Especialidade(0,listEsp.getSelectedItem());
						
						atendente.cadastrarMedico(textNome.getText(),Long.parseLong(textCrm.getText()), con, end, tel, esp, dias);
						
						JOptionPane.showMessageDialog(null, "Medico Cadastrado com sucesso! :) ");
						
						dispose();
						
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			
			
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			
		}
		setVisible(true);
		setModal(true);
	}
}
