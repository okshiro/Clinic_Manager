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
import br.ufc.clinic.classes.PlanoSaude;

public class ViewVisualizarPlanosSaude extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public ViewVisualizarPlanosSaude(final Atendente atendente) {
		setBounds(100, 100, 516, 486);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
			JLabel lblPlanosDeSade = new JLabel("Planos de Saúde");
			lblPlanosDeSade.setFont(new Font("Dialog", Font.BOLD, 18));
			lblPlanosDeSade.setBounds(161, 12, 185, 22);
			contentPanel.add(lblPlanosDeSade);
			
			final List listPlanos = new List();
			for(PlanoSaude p : atendente.getListaPlanoSaude()){
				listPlanos.add(p.toString());
			}
			
			listPlanos.setBounds(10, 53, 476, 340);
			contentPanel.add(listPlanos);
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				JButton sairButton = new JButton("Sair");
				sairButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				sairButton.setActionCommand("SAIR");
				buttonPane.add(sairButton);
				getRootPane().setDefaultButton(sairButton);
			
				{
					JButton excluirButton = new JButton("Excluir");
					excluirButton.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							String select = listPlanos.getSelectedItem();
							if(select == null){
								JOptionPane.showMessageDialog(null, "Selecione um Plano de Saude!!");
								return;
							}
							int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente Excluir esse PLano de Saude?");
							if(opcao > 0){
								return;
							}
							
							int index = select.indexOf("-");
							
							String razao = select.substring(0, index);
							long cnpj = Long.parseLong(select.substring(index+1, select.length()));
							listPlanos.remove(listPlanos.getSelectedIndex());
							atendente.removerPlanoDeSaude(new PlanoSaude(razao, cnpj));
							JOptionPane.showMessageDialog(null, "Plano de Saude Removido com Sucesso!!!");
						}
					});
					excluirButton.setActionCommand("Excluir");
					buttonPane.add(excluirButton);
					getRootPane().setDefaultButton(excluirButton);
				}
				
			
				JButton detalhesButton = new JButton("Detalhes");
				detalhesButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String select = listPlanos.getSelectedItem();
						if(select == null){
							JOptionPane.showMessageDialog(null, "Selecione um Plano de Saúde!!");
							return;
						}
						int index = select.indexOf("-");
						
						String razaoSocial = select.substring(0, index);
						long cnpj = Long.parseLong(select.substring(index+1, select.length()));
						PlanoSaude p = new PlanoSaude(razaoSocial, cnpj);
						for (PlanoSaude plan  : atendente.getListaPlanoSaude()) {
							if(plan.equals(p)){
								@SuppressWarnings("unused")
								ViewPlanoSaude viewPlano = new ViewPlanoSaude(plan);
								break;
							}
						}
					}
				});
				detalhesButton.setActionCommand("Detalhes");
				buttonPane.add(detalhesButton);
				
				setModal(true);
				setVisible(true);
			}
	}
