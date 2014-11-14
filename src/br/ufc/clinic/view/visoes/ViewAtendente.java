package br.ufc.clinic.view.visoes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.view.cadastros.ViewCadastraConsultaParticular;
import br.ufc.clinic.view.cadastros.ViewCadastraEspecialidade;
import br.ufc.clinic.view.cadastros.ViewCadastraPaciente;
import br.ufc.clinic.view.cadastros.ViewCadastrarConsultaPlano;
import br.ufc.clinic.view.cadastros.ViewCadastroGerente;
import br.ufc.clinic.view.cadastros.ViewCadastroMedico;
import br.ufc.clinic.view.cadastros.viewCadastrarPlanoSaude;
import br.ufc.clinic.view.opcoes.ViewEscolherConsulta;
import br.ufc.clinic.view.visualizar.ViewVisualizarConsultaParticular;
import br.ufc.clinic.view.visualizar.ViewVisualizarConsultaPorPlano;
import br.ufc.clinic.view.visualizar.ViewVisualizarEspecialidade;
import br.ufc.clinic.view.visualizar.ViewVisualizarGerente;
import br.ufc.clinic.view.visualizar.ViewVisualizarMedico;
import br.ufc.clinic.view.visualizar.ViewVisualizarPaciente;
import br.ufc.clinic.view.visualizar.ViewVisualizarPlanosSaude;

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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 581, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 0, 0, 0));
		
		JMenu Menu = new JMenu("Menu");
		menuBar.add(Menu);
		
		JPanel panel = new JPanel() {
			private static final long serialVersionUID = 1L;
			ImageIcon bg = new ImageIcon(getClass().getResource("/resources/background.jpg"));
			protected void paintComponent(Graphics g) {
				g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this);
			}
		};
		frame.setContentPane(panel);
		
		
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
		
		JMenuItem mntmCadastroPlanoDe = new JMenuItem("Cadastrar Plano de Saúde");
		mntmCadastroPlanoDe.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				viewCadastrarPlanoSaude cadastroPlano = new viewCadastrarPlanoSaude(atendente);
			}
		});
		
		Cadastros.add(mntmCadastroPlanoDe);
		
		JMenuItem mntmCadastrarEspecialidade = new JMenuItem("Cadastrar Especialidade");
		mntmCadastrarEspecialidade.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				ViewCadastraEspecialidade viewCadastraEspecialidade = new ViewCadastraEspecialidade(atendente);
			}
		});
		
		
		Cadastros.add(mntmCadastrarEspecialidade);
		
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
		
		JMenuItem mntmPlanosDeSade = new JMenuItem("Planos de Saúde");
		mntmPlanosDeSade.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				ViewVisualizarPlanosSaude viewPlanoSaude = new ViewVisualizarPlanosSaude();
			}
		});
		
		mnVisualizar.add(mntmPlanosDeSade);
		
		JMenuItem mntmConsultas = new JMenuItem("Consultas");
		mntmConsultas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ViewEscolherConsulta escolha = new ViewEscolherConsulta();
				if(escolha.getTipoConsulta() == 1){
					@SuppressWarnings("unused")
					ViewVisualizarConsultaParticular viewConsultaParticular = new ViewVisualizarConsultaParticular();
				}else if(escolha.getTipoConsulta() == 2){
					@SuppressWarnings("unused")
					ViewVisualizarConsultaPorPlano viewConsultaPorPlano = new ViewVisualizarConsultaPorPlano();
				}else{
					return;
				}
			}
		});
		
		mnVisualizar.add(mntmConsultas);
		
		JMenuItem mntmEspecialidades = new JMenuItem("Especialidades");
		mntmEspecialidades.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				ViewVisualizarEspecialidade viewEspecialidades = new ViewVisualizarEspecialidade();
			}
		});
		
		mnVisualizar.add(mntmEspecialidades);
		
		JMenu Consultas = new JMenu("Consultas");
		menuBar.add(Consultas);
		
		JMenuItem MarcarConsulta = new JMenuItem("Marcar Consulta");
		MarcarConsulta.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ViewEscolherConsulta escolha = new ViewEscolherConsulta();
				if(escolha.getTipoConsulta() == 1){
					@SuppressWarnings("unused")
					ViewCadastraConsultaParticular viewCConsultaParticular = new ViewCadastraConsultaParticular(atendente);
				}else if(escolha.getTipoConsulta() == 2){
					@SuppressWarnings("unused")
					ViewCadastrarConsultaPlano viewCConsultaPorPlano = new ViewCadastrarConsultaPlano(atendente);
				}else{
					return;
				}
				
			}
		});
		
		Consultas.add(MarcarConsulta);
		
		JMenuItem DesmarcaConsulta = new JMenuItem("Desmarca Consulta");
		Consultas.add(DesmarcaConsulta);
		
		JMenu Relatorios = new JMenu("Relatórios");
		menuBar.add(Relatorios);
		
		JMenuItem HorariosLivresMdicos = new JMenuItem("Horários Livres Médicos ");
		Relatorios.add(HorariosLivresMdicos);
		
		JMenuItem ConsultarMdico = new JMenuItem("Consultar Médico");
		Relatorios.add(ConsultarMdico);
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}
}
