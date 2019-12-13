package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI_Rule_Frame_Creating_Feature_Envy_Final_Result {
	
	private JFrame frame;
	private GUI_Rule_Frame_Creating_Feature_Envy_Consequence GRFC_consequence;
	private AccessToRuleDatabase database;
	
	
	/**
	 * Construtor da classe
	 * @param g - Recebe o GUI_Rule_Frame_Creating_Feature_Envy_Consequence como parâmetro
	 */
	public GUI_Rule_Frame_Creating_Feature_Envy_Final_Result(GUI_Rule_Frame_Creating_Feature_Envy_Consequence g) {
		this.GRFC_consequence = g;
		database = new AccessToRuleDatabase("CreatedRuleDatabase");
		init();
	}
	
	
	/**
	 * Método utilizado para inicializar a janela
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
	private void open(){
		frame.setSize(500, 400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(400, 150);
	}
	
	
	/**
	 * Método usado para adicionar os 3 painéis (Norte, Sul e Centro) à janela
	 */
	private void addFrameContent() {
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelSouth = new JPanel();
		
		buildPanelNorth(panelNorth);
		buildPanelCenter(panelCenter);
		buildPanelSouth(panelSouth);
		
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelSouth, BorderLayout.SOUTH);
	}
	
	
	/**
	 * Método para adiciona a label ao painel Norte
	 * @param panel - Painel Norte
	 */
	private void buildPanelNorth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("Rule summary: ");
		panel.add(searchText);
	}
	
	
	/**
	 * Método que adiciona 4 labels (condição (2) e consequência (2)) ao painel Centro
	 * @param panel - Painel Centro
	 */
	private void buildPanelCenter(JPanel panel) {
		panel.setLayout(new GridLayout(2,2));
		
		JLabel null_1 = new JLabel("                           "
				+ "   Condition (if): ");
		panel.add(null_1);
	
		JLabel ifRule = new JLabel();
		ifRule.setText(GRFC_consequence.getGRFCFE().getCondition());
		panel.add(ifRule);
		
		JLabel null_2 = new JLabel("                            "
				+ "  Consequence (then): ");
		panel.add(null_2);
		
		JLabel thenRule = new JLabel();
		thenRule.setText(GRFC_consequence.getConsequece());
		panel.add(thenRule);
	}
	
	
	/**
	 * Método que adiciona 3 botões ao painel Sul
	 * 
	 * CONFIRM - Este botão serve para guardar a regra criada
	 * BACK - Este botão serve para voltar à janela anterior
	 * CANCEL - Este botão serve para cancelar a criação da regra
	 * @param panel - Painel Sul
	 */
	private void buildPanelSouth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		
		JButton confirm = new JButton("CONFIRM");
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					saveRule();
					closeAllRuleFrameCreating();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(confirm);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				closeRuleResultFrame();
			}
		});
		panel.add(back);
		
		JButton cancel = new JButton("CANCEL");
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				closeAllRuleFrameCreating();
			}
		});
		panel.add(cancel);
	}
	
	
	/**
	 * Este método serve para guardar a regra criada pelo utilizador
	 * @throws IOException
	 */
	private void saveRule() throws IOException {	
		try {
			if(ruleDoesNotExists()==true) {
				database.writeToFile("Rule_" + (GRFC_consequence.
						getGRFCFE().getGRFCCT().generateRuleID()) + " " +
						GRFC_consequence.getGRFCFE().getCondition()
						+ " " + GRFC_consequence.getConsequece(), true);
				showInformationMessage();
			} else {
				 final JPanel warning = new JPanel();
				 JOptionPane.showMessageDialog(warning, "Unable to add rule on "
				 		+ "database! The rule already exists!", 
				 		"Warning", JOptionPane.WARNING_MESSAGE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Método usado para verificar se a regra criada pelo utilizador já existe 
	 * na database
	 * 
	 * @return Retorna TRUE se não existir nenhuma regra igual na database e FALSE 
	 * se já existir 
	 * @throws IOException
	 */
	private boolean ruleDoesNotExists() throws IOException {
		boolean response;
		String[] vector = database.readFile();
		int count = 0;
		for (int i=0; i<vector.length; i++) {
			String[] aux = vector[i].split(" ");
			if(aux[1].equals(GRFC_consequence.getGRFCFE().getCondition())) {
				count++;
			}
		}
		if(count>0) {
			response = false;
		} else {
			response = true;
		}
		return response;
	}
	
	
	/**
	 * Método usado para fechar esta janela
	 */
	public void closeRuleResultFrame() {
		GRFC_consequence.setIsOpenGRFCFEFR(false);
		frame.dispose();
	}
	
	
	/**
	 * Este método informa o utilizador que a regra foi criada/guardada com sucesso
	 */
	private void showInformationMessage() {
		final JPanel warning = new JPanel();
		JOptionPane.showMessageDialog(warning, "Successfully saved!"
		 		, "Information",
				 JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	/**
	 * Método utilizado para fechar todas as janelas que involvam a criação
	 *  da regra, sejam elas anteriores ou posteriores
	 */
	private void closeAllRuleFrameCreating() {
		closeRuleResultFrame();
		GRFC_consequence.closeRuleConsequenceFrame();
		GRFC_consequence.getGRFCFE().closeFrame();
		GRFC_consequence.getGRFCFE().getGRFCCT().closeRuleConsequenceFrame();
	}
	
}