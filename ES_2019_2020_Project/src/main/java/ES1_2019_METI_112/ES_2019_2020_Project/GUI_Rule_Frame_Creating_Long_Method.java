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

public class GUI_Rule_Frame_Creating_Long_Method {
	
	private JFrame frame;
	private GUI_Rule_Frame_Choosing_Consequence_Type GRFCCT;
	private AccessToRuleDatabase database;
	private String condicion;
	private String consequence;
	
	
	/**
	 * Construtor da classe
	 * @param g - Recebe o GUI_Rule_Frame_Choosing_Consequence_Type como parâmetro
	 */
	public GUI_Rule_Frame_Creating_Long_Method (
			GUI_Rule_Frame_Choosing_Consequence_Type g) {
		this.GRFCCT = g;
		database = new AccessToRuleDatabase("CreatedRuleDatabase");
		init();
	}
	
	
	/**
	 * Este método inicializa a janela
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
	 * Este método tem como objetivo estabelecer definições da janela, 
	 * tais como o seu tamanho, etc
	 */
	@SuppressWarnings("deprecation")
	private void open(){
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(400, 150);
	}
	
	
	/**
	 * Este método adiciona 3 paineis à janela (Norte, Sul e Centro)
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
	 * Este método serve para adicionar uma label ao painel Norte
	 * @param panel - Painel Norte
	 */
	private void buildPanelNorth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("Rule summary: ");
		panel.add(searchText);
	}
	
	
	/**
	 * Este método serve para adicionar 4 labels ao painel central
	 * @param panel - Painel Centro
	 */
	private void buildPanelCenter(JPanel panel) {
		panel.setLayout(new GridLayout(2,2));
		
		JLabel null_1 = new JLabel("                           "
				+ "   Condition (if): ");
		panel.add(null_1);
	
		JLabel ifRule = new JLabel();
		condicion = "if(LOC>" + GRFCCT.getGRF().getGOF().getMD().getLOC() + "&&" 
				+ "CYCLO>" + GRFCCT.getGRF().getGOF().getMD().getCYCLO() + ")";
		ifRule.setText(condicion);
		panel.add(ifRule);
		
		JLabel null_2 = new JLabel("                            "
				+ "  Consequence (then): ");
		panel.add(null_2);
		
		JLabel thenRule = new JLabel();
		consequence = "is_long_method=true";
		thenRule.setText(consequence);
		panel.add(thenRule);
	}
	
	
	/**
	 * Este método serve para adicionar 3 botões ao painel sul
	 * 
	 * CONFIRM - Este botão guarda a regra criada
	 * 
	 * BACK - Este botão fecha a janela atual e volta à anterior
	 * 
	 * CANCEL - Este botão cancela a criação das regras e fecha todas as janelas 
	 * que estejam ligadas à criação desta regra
	 * 
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
				closeFrame();
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
	 * Este método guarda a regra criada pelo utilizador na Database
	 * @throws IOException
	 */
	private void saveRule() throws IOException {
		try {
			if(ruleDoesNotExists()==true) {
				database.writeToFile("Rule_" + (GRFCCT.generateRuleID()) + " " +
						condicion + " " + consequence, true);
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
	 * Este método verifica se já existe uma regra igual na database
	 * 
	 * @return Retorna um boolean em que retorna TRUE se não existir uma regra igual na database e FALSE se já existir
	 * @throws IOException
	 */
	private boolean ruleDoesNotExists() throws IOException {
		boolean response;
		String[] vector = database.readFile();
		int count = 0;
		for (int i=0; i<vector.length; i++) {
			String[] aux = vector[i].split(" ");
			if(aux[1].equals(condicion)) {
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
	 * Este método fecha a janela atual
	 */
	public void closeFrame() {
		GRFCCT.setIsOpenGRFCLM(false);
		frame.dispose();
	}
	
	
	/**
	 * Este método gera uma mensagem para informar o utilizador que a regra foi
	 * registada/criada com sucesso
	 */
	private void showInformationMessage() {
		final JPanel warning = new JPanel();
		JOptionPane.showMessageDialog(warning, "Successfully saved!"
		 		, "Information",
				 JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	/**
	 * Este método fecha todas as janelas que estejam ligadas à criação da 
	 * respectiva regra (anteriores ou posteriores)
	 */
	private void closeAllRuleFrameCreating() {
		closeFrame();
		GRFCCT.closeRuleConsequenceFrame();
	}
	
}