package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JButton;

public class GUI_Rule_Frame_Choosing_Consequence_Type {

	private JFrame frame;
	private GUI_Rules_Frame GRF;
	private GUI_Rule_Frame_Choosing_Consequence_Type GRFCCT;	
	private GUI_Rule_Frame_Creating_Long_Method GRCLM;
	private GUI_Rule_Frame_Creating_Feature_Envy_Condition GRCFE;
	private boolean isGuiRuleFrameCreatingLongMethodOpen = false;
	private boolean isGuiRuleFrameCreatingFeatureEnvy = false;
	
	/**
	 * Construtor da classe GUI_Rule_Frame_Choosing_Consequence_Type
	 * @param grf - GUI_Rules_Frame
	 */
	public GUI_Rule_Frame_Choosing_Consequence_Type(GUI_Rules_Frame grf) {
		this.GRF = grf;
		GRFCCT = this;
		init();
	}	
	
	/**
	 * Conjunto de getters  
	 * @return das seguintes variáveis: GRFCCT, GRF, GRCLM, GRCFE
	 */
	public GUI_Rule_Frame_Choosing_Consequence_Type getGRFCCT() {
		return GRFCCT;
	}
	
	
	public GUI_Rules_Frame getGRF() {
		return GRF;
	}
	
	
	public GUI_Rule_Frame_Creating_Long_Method getGRFCLM() {
		return GRCLM;
	}
	
	
	public GUI_Rule_Frame_Creating_Feature_Envy_Condition getGRFCFE() {
		return GRCFE;
	}
	
	/**
	 * Método que verifica o estado da variável isGuiRuleFrameCreatingFeatureEnvy
	 * @return da variável isGuiRuleFrameCreatingFeatureEnvy (true ou false)
	 */
	public boolean isOpenGRFCFE() {
		return isGuiRuleFrameCreatingFeatureEnvy;
	}
	
	/**
	 * Setter da variável isGuiRuleFrameCreatingFeatureEnvy
	 * @param state - Estado da variável isGuiRuleFrameCreatingFeatureEnvy (true ou false)
	 */
	public void setIsOpenGRFCFE(boolean state) {
		isGuiRuleFrameCreatingFeatureEnvy = state;
	}
	
	/**
	 * Método que verifica o estado da variável isGuiRuleFrameCreatingLongMethodOpen
	 * @return da variável isGuiRuleFrameCreatingLongMethodOpen (true ou false)
	 */
	public boolean isOpenGRFCLM() {
		return isGuiRuleFrameCreatingLongMethodOpen;
	}
	
	/**
	 * Setter da variável isGuiRuleFrameCreatingLongMethodOpen
	 * @param state - Estado da variável isGuiRuleFrameCreatingLongMethodOpen (true ou false)
	 */
	public void setIsOpenGRFCLM(boolean state) {
		isGuiRuleFrameCreatingLongMethodOpen = state;
	}
	
	/**
	 * Método que inicializa a JFrame
	 */
	private void init () {
		frame = new JFrame("Software Quality Assessment");
		frame.setLayout(new BorderLayout());
		addFrameContent();
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.pack();
		open();
	}
	
	/**
	 * Este  método tem como objetivo definir características da janela, tais como o seu tamanho 
	 */
	@SuppressWarnings("deprecation")
	private void open(){
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
		JPanel panelCenterComponent = new JPanel();
		JPanel panelSouth = new JPanel();
		
		buildPanelNorth(panelNorth);
		buildPanelCenter(panelCenter, panelCenterComponent);
		buildPanelSouth(panelSouth);
		
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelSouth, BorderLayout.SOUTH);
	}
	
	/**
	 * Método referente à crição do painel norte da classe GUI_Rule_Frame_Choosing_Consequence_Type
	 * @param panel - Painel da janela 
	 */
	private void buildPanelNorth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		JLabel searchText = new JLabel(
				"Select a metric to define as 'if' consequence: ");
		panel.add(searchText);
	}
	
	/**
	 * Método referente à crição do painel central da classe GUI_Rule_Frame_Choosing_Consequence_Type
	 * @param c - Painel da janela
	 * @param pc - Painel central da janela
	 */
	private void buildPanelCenter(JPanel c, JPanel pc) {
		c.setLayout(new GridLayout(1,2));
		buildMetricButtons(pc);
		c.add(pc);
	}
	
	/**
	 * Método referente à criação de botões das métricas
	 * @param panel - Painel da janela
	 */	
	private void buildMetricButtons(JPanel panel) {
		panel.setLayout(new GridLayout(2,1));
		longMethodButton(panel);
		featureEnvyButton(panel);
	}
	
	/**
	 * Método referente à criação do botão correspondente ao longMethod
	 * @param panel - Painel da janela
	 */
	private void longMethodButton(JPanel panel) {
		final JButton longM = new JButton("Long Method");
		longM.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				openLongMethodFrame();
			}
		});
		panel.add(longM);
	}
	
	/**
	 * Método responsável pela criação da janela do longMethod
	 */
	private void openLongMethodFrame() {
		if (isGuiRuleFrameCreatingLongMethodOpen==true 
				|| isGuiRuleFrameCreatingFeatureEnvy==true) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Unable to open new window for "
					+ "the metric selected! One metric windows is already open!", 
					"Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "The method for this "
					+ "metric is predefined and will only update previously "
					+ "defined threshold limits!", "Information",
					 JOptionPane.INFORMATION_MESSAGE);
			
			this.isGuiRuleFrameCreatingLongMethodOpen = true;
			GRCLM = new GUI_Rule_Frame_Creating_Long_Method(GRFCCT);
		}
	}
	
	/**
	 * Método referente à criação do botão correspondente ao featureEnvy
	 * @param panel - Painel da janela
	 */
	private void featureEnvyButton(JPanel panel) {
		final JButton featureE = new JButton("Feature Envy");
		featureE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				openFeatureEnvyFrame();
			}
		});
		panel.add(featureE);
	}
	
	/**
	 * Método responsável pela criação da janela featureEnvy
	 */
	public void openFeatureEnvyFrame() {
		if (isGuiRuleFrameCreatingLongMethodOpen==true 
				|| isGuiRuleFrameCreatingFeatureEnvy==true) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Unable to open new window for "
					+ "the metric selected! One metric windows is already open!", 
					"Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			this.isGuiRuleFrameCreatingFeatureEnvy = true;
			GRCFE = new GUI_Rule_Frame_Creating_Feature_Envy_Condition(GRFCCT);
		}
	}
	
	/**
	 * Método referente à crição do painel sul da classe GUI_Rule_Frame_Choosing_Consequence_Type
	 * @param panel - Painel da janela
	 */
	private void buildPanelSouth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dealWithAfterFrame();
				closeRuleConsequenceFrame();
			}
		});
		panel.add(back);
		
	}
	
	/**
	 * Método responsável por fechar as janelas GRCLM e GRCFE, no caso da janela GUI_Rule_Frame_Choosing_Consequence_Type 
	 * ter aberto uma das mesmas e se quiser fechar a GUI_Rule_Frame_Choosing_Consequence_Type
	 */	
	public void dealWithAfterFrame() {
		if(isGuiRuleFrameCreatingLongMethodOpen==true) {
			GRCLM.closeFrame();
		}
		if(isGuiRuleFrameCreatingFeatureEnvy==true) {
			GRCFE.closeFrame();
		}
	}
		
	/**
	 * Método responsável por fechar a janela GUI_Rule_Frame_Choosing_Consequence_Type
	 */
	public void closeRuleConsequenceFrame() {
		GRF.setIsOpenGRFCCT(false);
		frame.dispose();
	}
	
	/**
	 * Método responsável por gerar IDs para cada regra
	 * @return result - soma das váriaveis aux01, aux02 e aux03
	 */
	public String generateRuleID() {
		Random generator01 = new Random();
		int aux01 = generator01.nextInt(99);

		Random generator02 = new Random();
		char aux02 = (char) ('a' + Math.abs(generator02.nextInt() % 26));

		Random generator03 = new Random();
		int aux03 = generator03.nextInt(9);

		String result = "" + aux01 + aux02 + aux03;
		
		return result;
	}
	
}