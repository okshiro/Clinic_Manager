package br.ufc.clinic.view.opcoes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class ViewOptionAdicaoOuVisualizacaoObservacao extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private int opcao;
	
	
	public static void main(String[] args) {
		try {
			ViewOptionAdicaoOuVisualizacaoObservacao dialog = new ViewOptionAdicaoOuVisualizacaoObservacao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewOptionAdicaoOuVisualizacaoObservacao() {
		opcao = -1;
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEscolhaUmaOpco = new JLabel("Escolha uma opcão:");
		lblEscolhaUmaOpco.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEscolhaUmaOpco.setBounds(140, 41, 192, 15);
		contentPanel.add(lblEscolhaUmaOpco);
		
		final JRadioButton rdbtnVisualizarObservao = new JRadioButton("Visualizar Observação");
		rdbtnVisualizarObservao.setBounds(22, 73, 204, 23);
		contentPanel.add(rdbtnVisualizarObservao);
		
		final JRadioButton rdbtnAdicionarObservao = new JRadioButton("Adicionar Observação");
		rdbtnAdicionarObservao.setBounds(230, 73, 181, 23);
		contentPanel.add(rdbtnAdicionarObservao);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						if(rdbtnAdicionarObservao.isSelected()){
							opcao = 1;
							dispose();
						}else if(rdbtnVisualizarObservao.isSelected()){
								opcao=2;
						}
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAdicionarObservao);
		group.add(rdbtnVisualizarObservao);
		
	}

	/**
	 * @return the opcao
	 */
	public int getOpcao() {
		return opcao;
	}

	/**
	 * @param opcao the opcao to set
	 */
	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}
}
