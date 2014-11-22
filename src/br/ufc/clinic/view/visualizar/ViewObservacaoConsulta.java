package br.ufc.clinic.view.visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Consulta;
import br.ufc.clinic.classes.Observacao;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewObservacaoConsulta extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public ViewObservacaoConsulta(Consulta consulta) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblObservao = new JLabel("Observação:");
			lblObservao.setFont(new Font("Dialog", Font.BOLD, 18));
			lblObservao.setBounds(178, 12, 135, 15);
			contentPanel.add(lblObservao);
		}
		
		List listObservacoes = new List();
		for(Observacao o : consulta.getObservacao()){
			listObservacoes.add(o.toString());
		}
		
		listObservacoes.setBounds(10, 26, 410, 181);
		contentPanel.add(listObservacoes);
		
		{
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
				sairButton.setActionCommand("Cancel");
				buttonPane.add(sairButton);
			}
		}
		setModal(true);
		setVisible(true);
	}
}
