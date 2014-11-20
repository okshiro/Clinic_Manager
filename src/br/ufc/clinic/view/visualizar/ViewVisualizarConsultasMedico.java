package br.ufc.clinic.view.visualizar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Consulta;
import br.ufc.clinic.classes.ConsultaParticular;
import br.ufc.clinic.classes.ConsultaPorPlano;
import br.ufc.clinic.classes.Medico;
import br.ufc.clinic.view.cadastros.ViewCadastrarObservacao;
import br.ufc.clinic.view.opcoes.ViewOptionAdicaoOuVisualizacaoObservacao;

public class ViewVisualizarConsultasMedico extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			ViewVisualizarConsultasMedico dialog = new ViewVisualizarConsultasMedico(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewVisualizarConsultasMedico(final Medico medico, final List<Consulta> consultas) {
		setBounds(100, 100, 450, 433);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblSuasConsultas = new JLabel("Suas Consultas");
		lblSuasConsultas.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSuasConsultas.setBounds(138, 12, 180, 15);
		contentPanel.add(lblSuasConsultas);
		
		final java.awt.List listConsultas = new java.awt.List();
		if(consultas != null){
			for(Consulta c : consultas){
				listConsultas.add(c.toString());
				System.out.println("sd");
			}
		}
		
		
		listConsultas.setBounds(10, 33, 417, 307);
		contentPanel.add(listConsultas);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton sairButton = new JButton("sair");
				sairButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				sairButton.setActionCommand("OK");
				buttonPane.add(sairButton);
				getRootPane().setDefaultButton(sairButton);
			}
			
			JButton btnObservacoes = new JButton("Observações");
			btnObservacoes.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String select = listConsultas.getSelectedItem();
					if(select == null){
						JOptionPane.showMessageDialog(null, "Selecione uma Consulta!!!");
						return;
					}
					int i = select.indexOf(":");
					int id;
					try {
						id = Integer.parseInt( select.substring(0, i-1));
					} catch (Exception e2) {
						e2.printStackTrace();
						return;
					}

					Consulta con = null;
					for(Consulta c : consultas){
						if(c.getId() == id){
							con = c;
						}
					}
					
					if(con == null){
						return;
					}
					
					ViewOptionAdicaoOuVisualizacaoObservacao opcaoObservacao = new ViewOptionAdicaoOuVisualizacaoObservacao();
					int opt = opcaoObservacao.getOpcao();
					if(!(opt == -1)){
						if(opt == 1){
							@SuppressWarnings("unused")
							ViewCadastrarObservacao cadastrarObservacao  = new ViewCadastrarObservacao(medico,con);
						}else if(opt == 2){
							@SuppressWarnings("unused")
							ViewObservacaoConsulta observacao = new ViewObservacaoConsulta(con);
						}
					}
				}
			});
			
			buttonPane.add(btnObservacoes);
			{
				JButton visualizarButton = new JButton("Visualizar");
				visualizarButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String select = listConsultas.getSelectedItem();
						if(select == null){
							JOptionPane.showMessageDialog(null, "Selecione uma Consulta!!!");
							return;
						}
						int i = select.indexOf(":");
						int id;
						try {
							id = Integer.parseInt( select.substring(0, i-1));
						} catch (Exception e2) {
							e2.printStackTrace();
							return;
						}
						for(Consulta c : consultas){
							if(c.getId() == id){
								if(c instanceof ConsultaParticular){
									@SuppressWarnings("unused")
									ViewConsultaParticular consPart = new ViewConsultaParticular((ConsultaParticular) c);
								}else if(c instanceof ConsultaPorPlano){
									@SuppressWarnings("unused")
									ViewConsultaPorPlano consPlano = new ViewConsultaPorPlano((ConsultaPorPlano) c);
								}
							};
						}
					}
				});
				visualizarButton.setActionCommand("Cancel");
				buttonPane.add(visualizarButton);
			}
		}
		setModal(true);
		setVisible(true);
	}
}
