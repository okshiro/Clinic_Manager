package br.ufc.clinic.view.cadastros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
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

import br.ufc.clinic.classes.Consulta;
import br.ufc.clinic.classes.ConsultaParticular;
import br.ufc.clinic.classes.ConsultaPorPlano;
import br.ufc.clinic.classes.Observacao;
import br.ufc.clinic.classes.TipoObservacao;
import br.ufc.clinic.repository.GenericRepository;

public class ViewCadastrarObservacao extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	
	public static void main(String[] args) {
		try {
			ViewCadastrarObservacao dialog = new ViewCadastrarObservacao(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public ViewCadastrarObservacao(final Consulta consulta) {
		setBounds(100, 100, 450, 448);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAdicionarUmaObervao = new JLabel("Adicionar uma Obervação");
			lblAdicionarUmaObervao.setBounds(144, 12, 221, 15);
			contentPanel.add(lblAdicionarUmaObervao);
		}
			final JRadioButton queixas = new JRadioButton("Queixas Paciente");
			queixas.setBounds(8, 75, 277, 23);
			contentPanel.add(queixas);
		
			final JRadioButton preescricoes = new JRadioButton("Preescrições Medicas");
			preescricoes.setBounds(8, 111, 231, 23);
			contentPanel.add(preescricoes);
		
			final JRadioButton resultados = new JRadioButton("Resultados dos Exames e Respotas aos Tratamentos");
			resultados.setBounds(8, 35, 390, 23);
			contentPanel.add(resultados);
		
			ButtonGroup group = new ButtonGroup();
			group.add(queixas);
			group.add(preescricoes);
			group.add(resultados);
		
		
		{
			JLabel lblDescrio = new JLabel("Descrição:");
			lblDescrio.setBounds(18, 142, 98, 15);
			contentPanel.add(lblDescrio);
		}
		
		final TextArea descricao = new TextArea();
		descricao.setBounds(8, 163, 412, 202);
		contentPanel.add(descricao);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cadastrarButton = new JButton("Cadastrar");
				cadastrarButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						boolean adicionada = false;
						if(queixas.isSelected()){
							Observacao o = new Observacao(descricao.getText(), TipoObservacao.QUEIXAS);
							consulta.setObservacao(o);
							adicionada = true;
						}else if(preescricoes.isSelected()){
							Observacao o = new Observacao(descricao.getText(), TipoObservacao.PREESCRIOES);
							consulta.setObservacao(o);
							adicionada = true;
						}else if(resultados.isSelected()){
							Observacao o = new Observacao(descricao.getText(), TipoObservacao.RESULTAS);
							consulta.setObservacao(o);
							adicionada = true;
						}else{
							JOptionPane.showMessageDialog(null, "Por Favor, selecione uma Opção!!!");
						}
						if(adicionada){
							JOptionPane.showMessageDialog(null, "Observação Adicionada Com Sucesso!!!");
							if(consulta  instanceof ConsultaPorPlano){
								GenericRepository<ConsultaPorPlano> repConsulta = new GenericRepository<ConsultaPorPlano>("consulta_plano");
								repConsulta.create();
								repConsulta.load();
								repConsulta.pull();
								repConsulta.rem((ConsultaPorPlano) consulta);
								repConsulta.add((ConsultaPorPlano) consulta);
								dispose();
							}else{
								GenericRepository<ConsultaParticular> repConsulta = new GenericRepository<ConsultaParticular>("consulta_particular");
								repConsulta.create();
								repConsulta.load();
								repConsulta.pull();
								repConsulta.rem((ConsultaParticular) consulta);
								repConsulta.add((ConsultaParticular) consulta);
								dispose();
							}
							
						}
						
					}
				});
				
				buttonPane.add(cadastrarButton);
				getRootPane().setDefaultButton(cadastrarButton);
			}
			{
				JButton sairButton = new JButton("Sair");
				sairButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				sairButton.setActionCommand("Cancel");
				buttonPane.add(sairButton);
			}
			setModal(true);
			setVisible(true);
		}
	}
}
