package br.ufc.clinic.view.visoes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Consulta;
import br.ufc.clinic.classes.ConsultaParticular;
import br.ufc.clinic.classes.ConsultaPorPlano;
import br.ufc.clinic.classes.Medico;
import br.ufc.clinic.repository.GenericRepository;
import br.ufc.clinic.view.visualizar.ViewVisualizarConsultasMedico;

public class ViewMedico extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewMedico dialog = new ViewMedico(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewMedico(final Medico medico) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
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
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmVisualizar = new JMenuItem("Visualizar");
		mntmVisualizar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				GenericRepository<ConsultaPorPlano> cplano = new GenericRepository<ConsultaPorPlano>("consulta_plano");
				GenericRepository<ConsultaParticular> cparticular = new GenericRepository<ConsultaParticular>("consulta_particular");
				cplano.create();
				cplano.load();
				cplano.pull();
				
				cparticular.create();
				cparticular.load();
				cparticular.pull();
				
				
				
				List<Consulta> consultas = new ArrayList<Consulta>();
				for(ConsultaParticular cp: cparticular.get()){
					consultas.add((Consulta)cp);
				}
				for(ConsultaPorPlano cp: cplano.get()){
					consultas.add((Consulta)cp);
				}
				
				
				System.out.println(consultas.size());
				for(int i =0 ; i< consultas.size(); i++){
					if(consultas.get(i).getMedico() != null){
						if(!consultas.get(i).getMedico().equals(medico)){
							consultas.remove(consultas.get(i));
						}
					}
				}
				@SuppressWarnings("unused")
				ViewVisualizarConsultasMedico viewConsulta = new ViewVisualizarConsultasMedico(medico, consultas);
				
				
			}
		});
		
		mnConsultas.add(mntmVisualizar);
		
		setModal(true);
		setVisible(true);
	}
}
