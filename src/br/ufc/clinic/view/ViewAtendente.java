package br.ufc.clinic.view;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.ufc.clinic.classes.Atendente;

public class ViewAtendente extends JDialog {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Atendente atendente;
	
	public ViewAtendente(Atendente a) {
		initialize();
		this.atendente = a;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 581, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 0, 0, 1));
		
		JMenu Menu = new JMenu("Menu");
		menuBar.add(Menu);
		
		JMenuItem Salvar = new JMenuItem("Salvar");
		Menu.add(Salvar);
		
		JMenuItem Sair = new JMenuItem("Sair");
		Sair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 int option = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?","Sair", JOptionPane.YES_NO_OPTION);
				 if(option == 0){
					 System.exit(0);
				 }
			}
		});
		Menu.add(Sair);
		
		JMenu Cadastros = new JMenu("Cadastros");
		menuBar.add(Cadastros);
		
		JMenuItem CadastrarPaciente = new JMenuItem("Cadastrar Paciente");
		CadastrarPaciente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				ViewCadastraPaciente cadastroPaciente = new ViewCadastraPaciente(atendente);
			}
		});
		
		
		Cadastros.add(CadastrarPaciente);
		
		JMenuItem CadastrarMedico = new JMenuItem("Cadastrar Médico");
		CadastrarMedico.addActionListener(new ActionListener(
				) {
			
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				ViewCadastroMedico cadastroMedico = new ViewCadastroMedico(atendente);
			}
		});
		Cadastros.add(CadastrarMedico);
		
		JMenuItem CadastrarGerente = new JMenuItem("Cadastrar Gerente");
		CadastrarGerente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				ViewCadastroGerente cadastroGerente = new ViewCadastroGerente(atendente);
			}
		});
		
		Cadastros.add(CadastrarGerente);
		
		JMenu mnVisualizar = new JMenu("Visualizar");
		menuBar.add(mnVisualizar);
		
		JMenuItem mntmPacientes = new JMenuItem("Pacientes");
		mntmPacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				ViewVisualizarPaciente viewPaciente = new ViewVisualizarPaciente();
			}
		});
		
		mnVisualizar.add(mntmPacientes);
		
		JMenuItem mntmMedicos = new JMenuItem("Medicos");
		mntmMedicos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				ViewVisualizarMedico viewMedico = new ViewVisualizarMedico();
			}
		});
		
		mnVisualizar.add(mntmMedicos);
		
		JMenuItem mntmGerentes = new JMenuItem("Gerentes");
		mntmGerentes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				ViewVisualizarGerente viewGerente = new ViewVisualizarGerente();
			}
		});
		
		mnVisualizar.add(mntmGerentes);
		
		JMenuItem mntmConsultas = new JMenuItem("Consultas");
		mnVisualizar.add(mntmConsultas);
		
		JMenu Consultas = new JMenu("Consultas");
		menuBar.add(Consultas);
		
		JMenuItem MarcarConsulta = new JMenuItem("Marcar Consulta");
		Consultas.add(MarcarConsulta);
		
		JMenuItem DesmarcaConsulta = new JMenuItem("Desmarca Consulta");
		Consultas.add(DesmarcaConsulta);
		
		JMenu Relatrios = new JMenu("Relatórios");
		menuBar.add(Relatrios);
		
		JMenuItem HorariosLivresMdicos = new JMenuItem("Horários Livres Médicos ");
		Relatrios.add(HorariosLivresMdicos);
		
		JMenuItem ConsultarMdico = new JMenuItem("Consultar Médico");
		Relatrios.add(ConsultarMdico);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(317, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}
}
