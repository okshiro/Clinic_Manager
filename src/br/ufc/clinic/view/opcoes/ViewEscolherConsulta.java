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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class ViewEscolherConsulta extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private int tipoConsulta;
	public static void main(String[] args) {
		try {
			ViewEscolherConsulta dialog = new ViewEscolherConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewEscolherConsulta() {
		this.tipoConsulta = -1;
		setBounds(100, 100, 438, 247);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEscolhaUmaOpo = new JLabel("Escolha uma Opção!");
		lblEscolhaUmaOpo.setFont(new Font("Dialog", Font.BOLD, 19));
		lblEscolhaUmaOpo.setBounds(87, 24, 257, 28);
		contentPanel.add(lblEscolhaUmaOpo);
		
		final JRadioButton cParticular = new JRadioButton("Consulta Particular");
		cParticular.setBounds(46, 77, 169, 23);
		contentPanel.add(cParticular);
		
		final JRadioButton cPlano = new JRadioButton("Consulta Por Plano");
		cPlano.setBounds(219, 77, 211, 23);
		contentPanel.add(cPlano);
		
		ButtonGroup group = new ButtonGroup();
		group.add(cParticular);
		group.add(cPlano);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						if(cParticular.isSelected() || cPlano.isSelected() ){
							if(cParticular.isSelected()){
								tipoConsulta = 1;
								dispose();
							}else{
								tipoConsulta = 2;
								dispose();
							}
						}else{
							JOptionPane.showMessageDialog(null, "Marque uma das Opções!!!");
						}
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
			setModal(true);
			setVisible(true);
		}
	}

	public int getTipoConsulta() {
		return tipoConsulta;
	}
}
