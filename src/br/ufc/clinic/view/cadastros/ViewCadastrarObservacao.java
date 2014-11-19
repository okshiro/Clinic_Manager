package br.ufc.clinic.view.cadastros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Consulta;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCadastrarObservacao extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	
	public static void main(String[] args) {
		try {
			ViewCadastrarObservacao dialog = new ViewCadastrarObservacao(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public ViewCadastrarObservacao(Consulta consulta) {
		setBounds(100, 100, 450, 448);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAdicionarUmaObervao = new JLabel("Adicionar uma Obervação");
			lblAdicionarUmaObervao.setBounds(144, 12, 221, 15);
			contentPanel.add(lblAdicionarUmaObervao);
		}
		{
			JRadioButton queixas = new JRadioButton("Queixas Paciente");
			queixas.setBounds(8, 75, 277, 23);
			contentPanel.add(queixas);
		}
		{
			JRadioButton preescricoes = new JRadioButton("Preescrições Medicas");
			preescricoes.setBounds(8, 111, 231, 23);
			contentPanel.add(preescricoes);
		}
		{
			JRadioButton resultados = new JRadioButton("Resultados dos Exames e Respotas aos Tratamentos");
			resultados.setBounds(8, 35, 390, 23);
			contentPanel.add(resultados);
		}
		{
			JLabel lblDescrio = new JLabel("Descrição:");
			lblDescrio.setBounds(18, 142, 98, 15);
			contentPanel.add(lblDescrio);
		}
		
		List list = new List();
		list.setBounds(8, 166, 412, 189);
		contentPanel.add(list);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cadastrarButton = new JButton("Cadastrar");
				cadastrarButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				
				cadastrarButton.setActionCommand("OK");
				buttonPane.add(cadastrarButton);
				getRootPane().setDefaultButton(cadastrarButton);
			}
			{
				JButton sairButton = new JButton("Sair");
				sairButton.setActionCommand("Cancel");
				buttonPane.add(sairButton);
			}
		}
	}
}
