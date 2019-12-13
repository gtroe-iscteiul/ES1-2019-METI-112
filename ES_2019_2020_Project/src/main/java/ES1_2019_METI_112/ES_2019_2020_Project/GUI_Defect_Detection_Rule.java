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

public class GUI_Defect_Detection_Rule {
	
	private JFrame frame;
	private GUI_Defect_Detection GDD;
	private AccessToRuleDatabase database;
	private JList<String> list;


	/**
	 * Método onstrutor da classe
	 * @param g - Parâmetro da classe GUI_Defect_Detection
	 */
	public GUI_Defect_Detection_Rule(GUI_Defect_Detection g) {
		this.GDD = g;
		database = new AccessToRuleDatabase("CreatedRuleDatabase");
		init();
	}


	/**
	 * Método inicializa a janela
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
	 * Este método tem como objetivo estabelecer as definições da janela, 
	 * tais como o seu tamanho, etc
	 */
	@SuppressWarnings("deprecation")
	private void open() {
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(400, 150);		
	}
	

	/**
	 * Método para adicionar conteúdo à janela, sendo esta constituída por 
	 * três paineis (Norte, Sul e Centro)
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
	 * Método usado para construir o painel Norte da janela, 
	 * constituído por uma JLabel
	 * @param panelNorth - Painel
	 */
	private void buildPanelNorth(JPanel panelNorth) {
		panelNorth.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("List of rules created: ");
		panelNorth.add(searchText);
	}
	
	
	/**
	 * Método usado para construir o painel Central da janela, 
	 * constituído por uma JList para visualizar as regras criadas
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
	 * Método usado para construir o painel Sul da janela, 
	 * constituído pelos botões SELECT e BACK
	 * 
	 * SELECT - Serve para escolher qual método a ser executado
	 * BACK - Volta à janela anterior
	 * APPLY - Serve para aplicar as alterações
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
		
		JButton apply = new JButton("Apply");
		apply.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setRuleInformation();
			}
		});
		panelSouth.add(apply);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GDD.setIsOpenGDDR(false);
				frame.dispose();
			}
		});
		panelSouth.add(back);
	}
	
	
	/**
	 * Método usado para obter a informação sobre a regra selecionada
	 */
	private void getRuleInformation() {
		String[] vector = list.getSelectedValue().toString().split(" ");
		String id = "Rule: " + vector[0];
		String condition = "Condition (if): " + vector[1];
		String consequence = "Consequence (then): " + vector[2];
		String result = id + "\n" + "\n" + condition + "\n" + "\n" + consequence;
		
		final JPanel warning = new JPanel();
		JOptionPane.showMessageDialog(warning, result, "Information",
				 JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	/**
	 * Método usado para executar o calculo dos defeitos atarvés da regra escolhida
	 */
	private void setRuleInformation() {
		String[] vector = list.getSelectedValue().toString().split(" ");
		String rule = vector[0] + " " + vector[1] + " " + vector[2];
		
		GDD.setChosenRule(rule);
		
		closeFrame();
		
		GDD.defectDetectionForRule();
	}
	
	
	/**
	 * Método utilizado para fechar a janela
	 */
	public void closeFrame() {
		GDD.setIsOpenGDDR(false);
		frame.dispose();
	}
	
}