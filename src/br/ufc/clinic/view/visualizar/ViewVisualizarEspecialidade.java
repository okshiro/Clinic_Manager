package br.ufc.clinic.view.visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Especialidade;
import br.ufc.clinic.repository.GenericRepository;

public class ViewVisualizarEspecialidade extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static void main(String[] args) {
		try {
			ViewVisualizarEspecialidade dialog = new ViewVisualizarEspecialidade();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewVisualizarEspecialidade() {
		setBounds(100, 100, 428, 342);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEspecialidades = new JLabel("Especialidades");
			lblEspecialidades.setFont(new Font("Dialog", Font.BOLD, 19));
			lblEspecialidades.setBounds(124, 12, 178, 23);
			contentPanel.add(lblEspecialidades);
		}
		{
			
			GenericRepository<Especialidade> esp = new GenericRepository<Especialidade>("especialidade");
			esp.create();
			esp.pull();
			List especialidades = new List();
			for(Especialidade e : esp.get()){
				especialidades.add(e.toString());
			}
			
			especialidades.setBounds(10, 46, 388, 213);
			contentPanel.add(especialidades);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
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
