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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.Especialidade;

public class ViewCadastraEspecialidade extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nome;

	public ViewCadastraEspecialidade(final Atendente atendente) {
		setBounds(100, 100, 404, 228);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNovaEspecialidade = new JLabel("Nova Especialidade");
			lblNovaEspecialidade.setFont(new Font("Dialog", Font.BOLD, 19));
			lblNovaEspecialidade.setBounds(97, 12, 225, 15);
			contentPanel.add(lblNovaEspecialidade);
		}
		{
			JLabel lblId = new JLabel("Identificação:");
			lblId.setBounds(86, 58, 105, 15);
			contentPanel.add(lblId);
		}
		{
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setBounds(86, 88, 70, 15);
			contentPanel.add(lblNome);
		}
		
		final JSpinner identificacao = new JSpinner();
		identificacao.setBounds(192, 56, 64, 20);
		contentPanel.add(identificacao);
		{
			nome = new JTextField();
			nome.setBounds(141, 88, 181, 20);
			contentPanel.add(nome);
			nome.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						int id;
						try {
							id = Integer.parseInt(identificacao.getValue().toString());
						} catch (Exception e2) {
							System.out.println("Digite outro Identificador!!!");
							return;
						}
						String nomeText= nome.getText();
						if(nomeText == null){
							System.out.println("Digite um nome!!!");
							return;
						}
						for(Especialidade e1 : atendente.getListaEspecialidade()){
							if(id == e1.getCodigo()){
								JOptionPane.showMessageDialog(null, "Impossivel Adicionar Especialidade com mesmo Identificador!!!");
								return;
							}
						} 
						
						atendente.cadastraEspecialidade(id, nomeText);
						JOptionPane.showMessageDialog(null, "Especialidade adicionada com Exito!!");
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
