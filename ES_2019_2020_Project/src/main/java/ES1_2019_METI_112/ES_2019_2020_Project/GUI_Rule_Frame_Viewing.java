package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI_Rule_Frame_Viewing {

	private JFrame frame;
	private GUI_Rules_Frame GRF;
	private AccessToRuleDatabase database;
	private JList<String> list;


	/**
	 * Construtor da classe
	 * @param grf - Recebe a GUI_Rules_Frame como parâmetro
	 */
	public GUI_Rule_Frame_Viewing(GUI_Rules_Frame grf) {
		this.GRF = grf;
		database = new AccessToRuleDatabase("CreatedRuleDatabase");
		init();
	}


	/**
	 * Método que serve para inicializar a janela
	 */
	private void init() {
		frame = new JFrame("Software Quality Assessment");
		frame.setLayout(new BorderLayout());
		addFrameContent();
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.pack();
		open();
	}
	

	/**
	 * Este  método tem como objetivo definir definições da janela, tais como o seu tamanho 
	 */
	@SuppressWarnings("deprecation")
	private void open() {
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(400, 150);		
	}
	

	/**
	 * Este método tem como objetivo adicionar componentes à janela
	 */
	private void addFrameContent() {
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelSouth = new JPanel();
		
		buildPanelNorth(panelNorth);
		buildPanelSouth(panelSouth);
		buildPanelCenter(panelCenter);
		
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.add(panelCenter, BorderLayout.CENTER);
	}
	
	
	/**
	 * Este método adiciona componentes ao painel norte da janela
	 * @param panelNorth - Painel
	 */
	private void buildPanelNorth(JPanel panelNorth) {
		panelNorth.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("List of rules created: ");
		panelNorth.add(searchText);
	}
	
	
	/**
	 * Este método adiciona componentes ao painel central da janela
	 * @param panelCenter - Painel
	 */
	private void buildPanelCenter(JPanel panelCenter) {
		panelCenter.setLayout(new FlowLayout());
		String[] conteudo;
	    DefaultListModel<String> listModel = new DefaultListModel<>();
	    try {
			conteudo = database.readFile();
			for (int i = 0; i < conteudo.length; i++) {
				listModel.addElement(conteudo[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    list = new JList<String>(listModel);
	    panelCenter.add(list);
	}	
	
	
	/**
	 * Este método adiciona componentes ao painel sul da janela
	 * SELECT - Mostra informação sobre a regra criada
	 * DELETE - Apaga a regra
	 * BACK - Volta para a janela anterior
	 * @param panelSouth - Painel
	 */
	private void buildPanelSouth(JPanel panelSouth) {
		panelSouth.setLayout(new FlowLayout());
		
		JButton select = new JButton("SELECT");
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				getRuleInformation();
			}
		});
		panelSouth.add(select);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				deleteRuleFromDatabase(); 
			}
		});
		panelSouth.add(delete);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GRF.setIsOpenGRFV(false);
				frame.dispose();
			}
		});
		panelSouth.add(back);
	}
	
	
	/**
	 * Este método apresenta a informação sobre as regras
	 */
	private void getRuleInformation() {
		String[] vector = list.getSelectedValue().toString().split(" ");
		String condition = "Condition (if): " + vector[0];
		String consequence = "Consequence (then): " + vector[1];
		String result = condition + "\n" + "\n" + consequence;
		
		final JPanel warning = new JPanel();
		JOptionPane.showMessageDialog(warning, result, "Information",
				 JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	/**
	 * Este método apaga a regra da database
	 */
	private void deleteRuleFromDatabase() {
		try {
			database.deleteRule(list.getSelectedValue().toString());
			int index = list.getSelectedIndex();
			((DefaultListModel<String>) list.getModel()).remove(index);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		final JPanel warning = new JPanel();
		JOptionPane.showMessageDialog(warning, "Rule deleted successfully!", 
				"Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
}