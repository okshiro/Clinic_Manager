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

import br.ufc.clinic.classes.Gerente;
import br.ufc.clinic.repository.GenericRepository;

public class ViewVisualizarGerente extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			ViewVisualizarGerente dialog = new ViewVisualizarGerente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ViewVisualizarGerente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblGerentes = new JLabel("Gerentes");
			lblGerentes.setFont(new Font("Dialog", Font.BOLD, 18));
			lblGerentes.setBounds(179, 12, 114, 15);
			contentPanel.add(lblGerentes);
		}
			
			final GenericRepository<Gerente> gerentes = new GenericRepository<Gerente>("gerente");
			gerentes.create();
			gerentes.load();
			gerentes.pull();
			final List listGerentes = new List();
			for(Gerente g : gerentes.get()){
				listGerentes.add(g.toString());
			}
			
			
			listGerentes.setBounds(10, 39, 410, 168);
			contentPanel.add(listGerentes);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton sairButton = new JButton("Sair");
				sairButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				{
					JButton excluirButton = new JButton("Excluir");
					excluirButton.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							String nome = listGerentes.getSelectedItem();
							if(nome == null){
								JOptionPane.showMessageDialog(null, "Selecione um Gerente!!");
								return;
							}
							int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente Excluir esse Gerente?");
							if(opcao > 0){
								return;
							}
							listGerentes.remove(listGerentes.getSelectedIndex());
							gerentes.rem(new Gerente(nome));
							JOptionPane.showMessageDialog(null, "Gerente Removido com Sucesso!!!");
						}
					});
					excluirButton.setActionCommand("Excluir");
					buttonPane.add(excluirButton);
					getRootPane().setDefaultButton(excluirButton);
				}
				
				
				sairButton.setActionCommand("Cancel");
				buttonPane.add(sairButton);
			}
		}
		setModal(true);
		setVisible(true);
	}

}
