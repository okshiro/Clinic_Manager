package br.ufc.clinic.view.visoes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Gerente;
import br.ufc.clinic.view.visualizar.ViewVisualizarConsultasDia;

public class ViewGerente extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			ViewGerente dialog = new ViewGerente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ViewGerente(Gerente gerente) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				JMenu mnMenu = new JMenu("Menu");
				menuBar.add(mnMenu);
				{
					JMenuItem mntmSair = new JMenuItem("Sair");
					mntmSair.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							int option = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?","Sair", JOptionPane.YES_NO_OPTION);
							 if(option == 0){
								 System.exit(0);
							 }
						}
					});
					mnMenu.add(mntmSair);
				}
			}
			{
				JMenu mnConsultas = new JMenu("Consultas");
				menuBar.add(mnConsultas);
				{
					JMenuItem mntmVisualizarConsultas = new JMenuItem("Visualizar Consultas");
					mntmVisualizarConsultas.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							@SuppressWarnings("unused")
							ViewVisualizarConsultasDia viewConsultas = new ViewVisualizarConsultasDia(LocalDate.now());
						}
					});
					mnConsultas.add(mntmVisualizarConsultas);
				}
			}
		}
		
		setModal(true);
		setVisible(true);
	}

}
