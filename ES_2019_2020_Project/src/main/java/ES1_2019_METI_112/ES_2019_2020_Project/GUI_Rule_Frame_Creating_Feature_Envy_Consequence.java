package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JButton;

public class GUI_Rule_Frame_Creating_Feature_Envy_Consequence {

	private JFrame frame;
	private GUI_Rule_Frame_Creating_Feature_Envy_Condition GRFCFE;
	private GUI_Rule_Frame_Creating_Feature_Envy_Consequence GRFCFEC;
	private JLabel ifConsequence;
	private JPanel panelCenterResultComponent;
	private boolean needBoolean=true;
	private GUI_Rule_Frame_Creating_Feature_Envy_Final_Result GRFCFEFR;
	private boolean isGuiRuleFrameCreatingFeatureEnvyFinalResultOpen = false;
	private String consequence;


	/**
	 * Método construtor da classe
	 * 
	 * @param g
	 */
	public GUI_Rule_Frame_Creating_Feature_Envy_Consequence(
			GUI_Rule_Frame_Creating_Feature_Envy_Condition g) {
		this.GRFCFE = g;
		GRFCFEC = this;
		init();
	}
	
	
	// gets e sets respectivos aos atributos gerais da classe
	
	public GUI_Rule_Frame_Creating_Feature_Envy_Condition getGRFCFE() {
		return GRFCFE;
	}
	
	
	public boolean isOpenGRFCFEFR() {
		return isGuiRuleFrameCreatingFeatureEnvyFinalResultOpen;
	}
	
	
	public void setIsOpenGRFCFEFR(boolean state) {
		isGuiRuleFrameCreatingFeatureEnvyFinalResultOpen = state;
	}
	
	
	public GUI_Rule_Frame_Creating_Feature_Envy_Final_Result getGRFCFEFR() {
		return GRFCFEFR;
	}
	
	
	public String getConsequece() {
		return consequence;
	}
	
	
	/**
	 * Método para inicializar a janela
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
	 * Este  método tem como objetivo estabelecer as definições da janela, 
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
	 * Este método serve para adicionar conteúdo à janela (diversos paineis)
	 */
	private void addFrameContent() {
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelCenterComponent01 = new JPanel();
		JPanel panelCenterComponent02 = new JPanel();
		JPanel panelCenterComponent03 = new JPanel();
		panelCenterResultComponent = new JPanel();
		JPanel panelSouth = new JPanel();
		
		buildPanelNorth(panelNorth);
		buildPanelCenter(panelCenter, panelCenterComponent01, panelCenterComponent02, 
				panelCenterComponent03, panelCenterResultComponent);
		buildPanelSouth(panelSouth);
		
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelSouth, BorderLayout.SOUTH);
	}
	
	
	/**
	 * Método para adicionar conteúdo ao painel norte da janela
	 * @param panel - Painel
	 */
	private void buildPanelNorth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("Selection of 'if' consequence: ");
		panel.add(searchText);
	}
	
	
	/**
	 * Método para adicionar conteúdo ao painel central da janela
	 * 
	 * @param c - PainelCentro
	 * @param pc1 - panelCenterComponent01
	 * @param pc2 - panelCenterComponent02
	 * @param pc3 - panelCenterComponent03
	 * @param pc4 - panelCenterResultComponent
	 */
	private void buildPanelCenter(JPanel c, JPanel pc1, JPanel pc2, 
			JPanel pc3, JPanel pc4) {
		
		c.setLayout(new GridLayout(5,2));
		
		JLabel l1 = new JLabel("             ");
		JLabel l2 = new JLabel("             ");
		JLabel l3 = new JLabel("             ");
		JLabel l4 = new JLabel("             ");
		buildMetricsLabel(pc1);
		buildMetricButtons(pc2);
		buildIfConsequenceLabel(pc3);
		buildPanelResult(pc4);
		c.add(l1);
		c.add(l2);
		c.add(pc1);
		c.add(pc2);
		c.add(l3);
		c.add(l4);
		c.add(pc3);
		c.add(pc4);
	}
	
	
	/**
	 * Este método serva para criar a label respectivas às métricas
	 * @param panel - Painel
	 */
	private void buildMetricsLabel(JPanel panel) {
		JLabel metrics = new JLabel("Select value for consequence: ");
		panel.add(metrics);
	}
	
	
	/**
	 * Este método serve para criar os dois botões (true ou false) para a escolha
	 * da consequência da regra
	 * @param panel - painel
	 */
	private void buildMetricButtons(JPanel panel) {
		panel.setLayout(new FlowLayout());
		
		trueButton(panel);
		falseButton(panel);
	}
	
	

	/**
	 * Este método serve para adicionar à regra criada pelo utilizador, uma 
	 * consequência para o boolean "is_feature_envy", sendo este registado 
	 * como TRUE
	 * @param panel - Painel
	 */
	private void trueButton(JPanel panel) {
		final JButton TRUE = new JButton("True");
		TRUE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needBoolean==true) {
					updateConsequence(TRUE.getText());
				} else {
					showBooleanWarning();
				}
			}
		});
		panel.add(TRUE);
	}
	
	
	/**
	 * Este método serve para adicionar à regra criada pelo utilizador, uma 
	 * consequência para o boolean "is_feature_envy", sendo este registado 
	 * como FALSE
	 * @param panel - Painel
	 */
	private void falseButton(JPanel panel) {
		final JButton FALSE = new JButton("False");
		FALSE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needBoolean==true) {
					updateConsequence(FALSE.getText());
				} else {
					showBooleanWarning();
				}
			}
		});
		panel.add(FALSE);
	}
	
	
	/**
	 * Este método serve para fazer update ao texto referente à consequência
	 * da regra criada pelo utilizador
	 * 
	 * @param type - Verdadeiro ou Falso
	 */
	private void updateConsequence(String type) {
		needBoolean=false;
		panelCenterResultComponent.remove(ifConsequence);
		ifConsequence = new JLabel(formatConsequence(type));
		panelCenterResultComponent.add(ifConsequence);
		frame.validate();	
	}
	
	
	/**
	 * Este método serve para enviar uma mensagem de erro ao utilizador, informando
	 * que a consequência já foi escolhida
	 */
	private void showBooleanWarning() {
		 final JPanel warning = new JPanel();
		 JOptionPane.showMessageDialog(warning, "Unable to select consequence! "
		 		+ "Consequence already selected! To select again, first reset!", 
		 		"Warning", JOptionPane.WARNING_MESSAGE);
	}
	
	
	/**
	 * Este método adiciona uma label ao painel central
	 * @param panel - Painel
	 */
	private void buildIfConsequenceLabel(JPanel panel) {
		JLabel result = new JLabel("Metric used as consequence: ");
		panel.add(result);
	}
	
	
	/**
	 * Este método adiciona uma label ao painel central, apresentando a consequência
	 * à regra acabada de definir
	 * @param panel - Painel
	 */
	private void buildPanelResult(JPanel panel) {
		ifConsequence = new JLabel("");
		panel.add(ifConsequence);
	}
	
	
	/**
	 * Este método serve para criar o painel sul da janela, contendo 4 botões
	 * 
	 * RESET - Este botão serve fazer reset à consequência escolhida
	 * 
	 * OK - Este botão serve para guardar as alterações e abrir a janela 
	 * GUI_Rule_Frame_Creating_Feature_Envy_Final_Result
	 * 
	 * BACK - Este botão serve para voltar à janela anterior
	 * 
	 * CANCEL - Este botão serve para cancelar a criação da regra
	 * 
	 * @param panel - Painel
	 */
	private void buildPanelSouth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		
		JButton reset = new JButton("RESET");
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("reset");
				dealWithFinalResultFrame();
				closeRuleConsequenceFrame();
				GRFCFE.openGRFCFE_consequence();
			}
		});
		panel.add(reset);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				openGRFCFEFR();
			}
		});
		panel.add(ok);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dealWithFinalResultFrame();
				closeRuleConsequenceFrame();
			}
		});
		panel.add(back);
		
		JButton cancel = new JButton("CANCEL");
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dealWithFinalResultFrame();
				GRFCFEC.closeRuleConsequenceFrame();
				GRFCFE.closeFrame();
				GRFCFE.getGRFCCT().closeRuleConsequenceFrame();
			}
		});
		panel.add(cancel);
	}
	
	
	/**
	 * Este método serve formatar o texto da consequência, sendo possivel apresentar
	 * correctamente através da label respectiva
	 * @param c - True ou False
	 * @return
	 */
	private String formatConsequence(String c) {
		String aux = "";
		if(c.equals("True")) {
			aux = "is_feature_envy=true";
		}
		if(c.equals("False")) {
			aux = "is_feature_envy=false";
		}
		return aux;
	}
	
	
	/**
	 * Este método serve para fechar a janela posterior, caso esta se encontre aberta
	 */
	private void dealWithFinalResultFrame() {
		if(isGuiRuleFrameCreatingFeatureEnvyFinalResultOpen==true) {
			GRFCFEFR.closeRuleResultFrame();
		}
	}
	
	
	/**
	 * Este método serve para abrir a próxima janela, ou seja, a janela da interface
	 *  GUI_Rule_Frame_Creating_Feature_Envy_Final_Result
	 */
	private void openGRFCFEFR() {
		if(needBoolean==false) {
			if (isGuiRuleFrameCreatingFeatureEnvyFinalResultOpen==true) {
				final JPanel warning = new JPanel();
				JOptionPane.showMessageDialog(warning, "Unable to open the rule"
						+ "check window! Window is already open!", 
						"Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				consequence = ifConsequence.getText();
				isGuiRuleFrameCreatingFeatureEnvyFinalResultOpen=true;
				GRFCFEFR = 
						new GUI_Rule_Frame_Creating_Feature_Envy_Final_Result(GRFCFEC);

			}
		} else {
			 final JPanel warning = new JPanel();
			 JOptionPane.showMessageDialog(warning, "Unable to proceed to "
			 		+ "the rule check window! Please choose a consequence first!", 
			 		"Warning", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	
	/**
	 * Este método serve para fechar a janela atual e janelas posteriores
	 */
	public void closeRuleConsequenceFrame() {
		dealWithFinalResultFrame();
		GRFCFE.setIsOpenGRFCFEC(false);
		frame.dispose();
	}
	
}
