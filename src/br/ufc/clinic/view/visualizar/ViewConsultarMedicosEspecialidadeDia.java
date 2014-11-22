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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufc.clinic.classes.Atendente;
import br.ufc.clinic.classes.DiaSemana;
import br.ufc.clinic.classes.Especialidade;
import br.ufc.clinic.classes.Medico;
import br.ufc.clinic.ferramentas.Ferramentas;

public class ViewConsultarMedicosEspecialidadeDia extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			ViewConsultarMedicosEspecialidadeDia dialog = new ViewConsultarMedicosEspecialidadeDia(new Atendente("dssds"));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewConsultarMedicosEspecialidadeDia(final Atendente atendente) {
		setBounds(100, 100, 569, 383);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEscolharUmaEspecialidade = new JLabel("Escolhar uma Especialidade");
			lblEscolharUmaEspecialidade.setFont(new Font("Dialog", Font.BOLD, 15));
			lblEscolharUmaEspecialidade.setBounds(5, 10, 232, 30);
			contentPanel.add(lblEscolharUmaEspecialidade);
		}
		{
			JLabel lblEscolharUmaEspecialidade = new JLabel("Escolhar um Dia");
			lblEscolharUmaEspecialidade.setFont(new Font("Dialog", Font.BOLD, 15));
			lblEscolharUmaEspecialidade.setBounds(340, 10, 232, 30);
			contentPanel.add(lblEscolharUmaEspecialidade);
		}
		
		final List especialidades = new List();
		for(Especialidade e : atendente.getListaEspecialidade()){
			especialidades.add(e.toString());
		}
		especialidades.setBounds(10, 42, 245, 249);
		contentPanel.add(especialidades);
		
		final List dias = new List();
		dias.add(DiaSemana.SEGUNDA.toString());
		dias.add(DiaSemana.TERCA.toString());
		dias.add(DiaSemana.QUARTA.toString());
		dias.add(DiaSemana.QUINTA.toString());
		dias.add(DiaSemana.SEXTA.toString());
		dias.add(DiaSemana.SABADO.toString());
		dias.add(DiaSemana.DOMINGO.toString());
		
		dias.setBounds(270, 42, 269, 249);
		contentPanel.add(dias);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton visualizar = new JButton("Visualizar");
				visualizar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String select = especialidades.getSelectedItem();
						if(select == null){
							JOptionPane.showMessageDialog(null, "Selecione uma Especialidade!!!");
							return;
						}
						
						int index = select.indexOf("-");
						int id = Integer.parseInt(select.substring(0, index));
						String nome = select.substring(index+1, select.length());
						System.out.println("Ainda: " + id + " == " + nome);
						
						String diaSemana = dias.getSelectedItem();
						
						java.util.List<Medico> listaMedicos = atendente.getMedicoEspecialidadeDia(new Especialidade(id, nome), Ferramentas.StringToDiaSemana(diaSemana) );
						@SuppressWarnings("unused")
						ViewVisualizarMedico verMedicos = new ViewVisualizarMedico(atendente, listaMedicos);
					}
				});
				
				visualizar.setActionCommand("OK");
				buttonPane.add(visualizar);
				getRootPane().setDefaultButton(visualizar);
			}
			{
				JButton sair = new JButton("Sair");
				sair.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				sair.setActionCommand("Sair");
				buttonPane.add(sair);
			}
		}
		setModal(true);
		setVisible(true);
	}
}
