package br.ufc.clinic.view.visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Endereco;
import br.ufc.clinic.classes.PlanoSaude;
import br.ufc.clinic.classes.Telefone;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPlanoSaude extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			ViewPlanoSaude dialog = new ViewPlanoSaude(new PlanoSaude("sidisjd"));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ViewPlanoSaude(PlanoSaude planoSaude) {
		setBounds(100, 100, 602, 494);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPlanoSaude = new JLabel("Plano Saude");
			lblPlanoSaude.setFont(new Font("Dialog", Font.BOLD, 18));
			lblPlanoSaude.setBounds(247, 12, 147, 15);
			contentPanel.add(lblPlanoSaude);
		}
		{
			JLabel lblRazoSocial = new JLabel("Razão Social:");
			lblRazoSocial.setBounds(33, 46, 114, 15);
			contentPanel.add(lblRazoSocial);
		}
		{
			JLabel lblCnpj = new JLabel("CNPJ:");
			lblCnpj.setBounds(33, 73, 70, 15);
			contentPanel.add(lblCnpj);
		}
		{
			JLabel lblEnderecos = new JLabel("Enderecos");
			lblEnderecos.setBounds(114, 160, 87, 15);
			contentPanel.add(lblEnderecos);
		}
		{
			List listEnderecos = new List();
			for(Endereco e: planoSaude.getEnderecos()){
				listEnderecos.add(e.toString());
			}
			
			listEnderecos.setBounds(10, 181, 313, 220);
			contentPanel.add(listEnderecos);
		}
		{
			JLabel lblTelefones = new JLabel("Telefones");
			lblTelefones.setBounds(421, 160, 70, 15);
			contentPanel.add(lblTelefones);
		}
		{
			List listTelefones = new List();
			for (Telefone t : planoSaude.getTelefones()) {
				listTelefones.add(t.toString());
			}
			listTelefones.setBounds(329, 181, 243, 220);
			contentPanel.add(listTelefones);
		}
		
		JLabel labelRazaoSocial = new JLabel(planoSaude.getRazaoSocial());
		labelRazaoSocial.setBounds(136, 46, 434, 15);
		contentPanel.add(labelRazaoSocial);
		
		JLabel labelCnpj = new JLabel(Long.toString(planoSaude.getCnpj()));
		labelCnpj.setBounds(75, 73, 495, 15);
		contentPanel.add(labelCnpj);
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
				sairButton.setActionCommand("OK");
				buttonPane.add(sairButton);
				getRootPane().setDefaultButton(sairButton);
			}
		}
		setModal(true);
		setVisible(true);
	}
}
