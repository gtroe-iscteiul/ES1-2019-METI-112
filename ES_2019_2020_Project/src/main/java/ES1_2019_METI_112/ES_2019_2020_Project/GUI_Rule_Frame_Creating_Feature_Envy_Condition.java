package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI_Rule_Frame_Creating_Feature_Envy_Condition {
	
	private JFrame frame;
	private GUI_Rule_Frame_Choosing_Consequence_Type GRFCCT;
	private GUI_Rule_Frame_Creating_Feature_Envy_Condition GRFCFE;
	private JLabel ifCondition;
	private JPanel panelCenterResultComponent;
	private boolean needOperator=false;
	private boolean needSignal = true;
	private GUI_Rule_Frame_Creating_Feature_Envy_Consequence GRFCFEC;
	private boolean isGuiRuleFrameCreatingFeatureEnvyConsequenceOpen;
	private String condition;
	private String signal;
	private boolean isLocUsed;
	private boolean isCycloUsed;
	private boolean isAtfdUsed;
	private boolean isLaaUsed;
	private boolean needCondition;
	
	
	/**
	 * Construtor da classe 
	 * @param g - GUI_Rule_Frame_Choosing_Consequence_Type
	 */
	public GUI_Rule_Frame_Creating_Feature_Envy_Condition(
			GUI_Rule_Frame_Choosing_Consequence_Type g) {
		this.GRFCCT = g;
		GRFCFE = this;
		this.isGuiRuleFrameCreatingFeatureEnvyConsequenceOpen = false;
		this.isLocUsed = false;
		this.isCycloUsed = false;
		this.isAtfdUsed = false;
		this.isLaaUsed = false;
		this.needCondition = true;
		init();
		
	}
	
	//Getters e setters da classe
	
	public GUI_Rule_Frame_Choosing_Consequence_Type getGRFCCT() {
		return GRFCCT;
	}
	
	
	public boolean isOpenGRFCFEC() {
		return isGuiRuleFrameCreatingFeatureEnvyConsequenceOpen;
	}
	
	
	public void setIsOpenGRFCFEC(boolean state) {
		isGuiRuleFrameCreatingFeatureEnvyConsequenceOpen = state;
	}
	
	
	public GUI_Rule_Frame_Creating_Feature_Envy_Consequence getGRFCFEC() {
		return GRFCFEC;
	}
	
	
	public String getCondition() {
		return condition;
	}
	
	
	/**
	 * Este método serve para inicializar a janela
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
	 * Este  método tem como objetivo definir atributos da janela, tais como 
	 * o seu tamanho 
	 */
	@SuppressWarnings("deprecation")
	private void open(){
		frame.setSize(500, 400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(400, 150);
	}
	
	
	/**
	 * Este método tem como objetivo adicionar os paineis à janela
	 */
	private void addFrameContent() {
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelCenterComponentThresholdLabel = new JPanel();
		JPanel panelCenterComponentTreshlodButtons = new JPanel();
		JPanel panelCenterComponentOperatorsLabel = new JPanel();
		JPanel panelCenterComponentOperatorsButtons = new JPanel();
		JPanel panelCenterComponentSignalsLabel = new JPanel();
		JPanel panelCenterComponentSignalsButtons = new JPanel();
		JPanel panelCenterComponentResultLabel = new JPanel();
		panelCenterResultComponent = new JPanel();
		JPanel panelSouth = new JPanel();
		
		buildPanelNorth(panelNorth);
		buildPanelCenter(panelCenter, panelCenterComponentThresholdLabel, 
				panelCenterComponentTreshlodButtons, panelCenterComponentOperatorsLabel,
				panelCenterComponentOperatorsButtons, panelCenterComponentResultLabel,
				panelCenterResultComponent, panelCenterComponentSignalsLabel, 
				panelCenterComponentSignalsButtons);
		buildPanelSouth(panelSouth);
		
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelSouth, BorderLayout.SOUTH);	
	}
	
	
	/**
	 * Este método adiciona uma label ao painel norte da janela
	 * @param panel - Painel
	 */
	private void buildPanelNorth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("Selection of 'if' condition: ");
		panel.add(searchText);
	}
	
	

	/**
	 * Este método tem como objetivo adicionar labels e métodos para a construção 
	 * do painel centro da janela
	 * @param c - Painel Centro
	 * @param pc1 - Painel Treshold
	 * @param pc2 - Painel Treshold buttons
	 * @param pc3 - Painel Operators Label
	 * @param pc4 - Painel Operators buttons
	 * @param pc5 - Painel Result Label
	 * @param pc6 - Painel Result Component
	 * @param sl - Painel Signal Label
	 * @param sb - Painel Signal Buttons
	 */
	private void buildPanelCenter(JPanel c, JPanel pc1, JPanel pc2, 
			JPanel pc3, JPanel pc4, JPanel pc5, JPanel pc6, JPanel sl, JPanel sb) {
		
		c.setLayout(new GridLayout(7,2));
		
		JLabel l1 = new JLabel("             ");
		JLabel l2 = new JLabel("             ");
		JLabel l3 = new JLabel("             ");
		JLabel l4 = new JLabel("             ");
		JLabel l5 = new JLabel("             ");
		JLabel l6 = new JLabel("             ");
		
		buildThresholdsLabel(pc1); buildThresholdButtons(pc2);
		buildOperatorsLabel(pc3); buildOperatorButtons(pc4);
		buildSignalsLabel(sl); buildSignalButtons(sb);
		buildIfConditionLabel(pc5); buildPanelResult(pc6);
		
		c.add(pc1); c.add(pc2);
		c.add(l1); c.add(l2);
		c.add(pc3); c.add(pc4);
		c.add(l3); c.add(l4);
		c.add(sl); c.add(sb);	
		c.add(l5); c.add(l6);
		c.add(pc5); c.add(pc6);
	}
	
	
	/**
	 * Este método serve para criar a label do painel Tresholds
	 * @param panel - Painel
	 */
	private void buildThresholdsLabel(JPanel panel) {
		JLabel thresholds = new JLabel("Select a threshold: ");
		panel.add(thresholds);
	}
	
	
	/**
	 * Este método serve adicionar os botões ao painel Tresholds
	 * @param panel - Painel
	 */
	private void buildThresholdButtons(JPanel panel) {
		panel.setLayout(new GridLayout(2,2));
		
		locButton(panel);
		cycloButton(panel);
		atfdButton(panel);
		laaButton(panel);
	}
	
	
	/**
	 * Este método serve para adicionar funcionalidade ao botão LOC, 
	 * em que dependendo das escolhas do utilizador, o programa poderá ou 
	 * não enviar mensagens de erro ao utilizador
	 * @param panel - Painel
	 */
	private void locButton(JPanel panel) {
		final JButton loc = new JButton("LOC");
		loc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needOperator==false) {
					if(needSignal==false) {
						if(isLocUsed==false) {
							updateCondition(loc.getText());
							isLocUsed = true;
						} else {
							showRepeatedThresholdWarning();
						}
					} else {
						showSignalsWarning(1);
					}
				} else {
					showThresholdsWarning();
				}
			}
		});
		panel.add(loc);
	}
	
	
	/**
	 * Este método serve para adicionar funcionalidade ao botão CYCLO, 
	 * em que dependendo das escolhas do utilizador, o programa poderá ou 
	 * não enviar mensagens de erro ao utilizador
	 * @param panel - Painel
	 */
	private void cycloButton(JPanel panel) {
		final JButton cyclo = new JButton("CYCLO");
		cyclo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				if(needOperator==false) {
					if(needSignal==false) {
						if(isCycloUsed==false) {
							updateCondition(cyclo.getText());
							isCycloUsed = true;
						} else {
							showRepeatedThresholdWarning();
						}
					} else {
						showSignalsWarning(1);
					}
				} else {
					showThresholdsWarning();
				}
			}
		});
		panel.add(cyclo);
	}
	
	
	/**
	 * Este método serve para adicionar funcionalidade ao botão ATFD, 
	 * em que dependendo das escolhas do utilizador, o programa poderá ou 
	 * não enviar mensagens de erro ao utilizador
	 * @param panel - Painel
	 */
	private void atfdButton(JPanel panel) {
		final JButton atfd = new JButton("ATFD");
		atfd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needOperator==false) {
					if(needSignal==false) {
						if(isAtfdUsed==false) {
							updateCondition(atfd.getText());
							isAtfdUsed = true;
						} else {
							showRepeatedThresholdWarning();
						}
					} else {
						showSignalsWarning(1);
					}
				} else {
					showThresholdsWarning();
				}
			}
		});
		panel.add(atfd);
	}
	
	
	/**
	 * Este método serve para adicionar funcionalidade ao botão LAA, 
	 * em que dependendo das escolhas do utilizador, o programa poderá ou 
	 * não enviar mensagens de erro ao utilizador
	 * @param panel - Painel
	 */
	private void laaButton(JPanel panel) {
		final JButton laa = new JButton("LAA");
		laa.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needOperator==false) {
					if(needSignal==false) {
						if(isLaaUsed==false) {
							updateCondition(laa.getText());
							isLaaUsed = true;
						} else {
							showRepeatedThresholdWarning();
						}
					} else {
						showSignalsWarning(1);
					}
				} else {
					showThresholdsWarning();
				}
			}
		});
		panel.add(laa);
	}
	
	
	/**
	 * Este método serve para adicionar as métricas, operadores e sinais 
	 * que o utilizador vai adicionando à regra
	 * @param type - Métrica escolhida
	 */
	private void updateCondition(String type) {
		needCondition = false;
		String ifContent = ifCondition.getText();
		panelCenterResultComponent.remove(ifCondition);	
		String[] parts = ifContent.split(" ");
		String result="";
		for(int i=0; i<parts.length-1; i++) {
			result = result + parts[i] + " ";
		}
		result = result + dealWithType(type);
		ifCondition = new JLabel(result);
		panelCenterResultComponent.add(ifCondition);
		frame.validate();
	}
	
	
	/**
	 * Este método serve para o programa determinar qual a condição definida
	 * @param t - Métrica escolhida
	 * @return - Retorna a string resultante do utilizador fazer a sua regra
	 */
	private String dealWithType(String t) {
		String result = "";
		if(t.equals("LOC")) {
			needOperator=true;
			needSignal=true;
			result = result + "LOC" + signal +
					GRFCCT.getGRF().getGOF().getMD().getLOC() + " )";
		}
		if(t.equals("CYCLO")) {
			needOperator=true;
			needSignal=true;
			result = result + "CYCLO" + signal +
					GRFCCT.getGRF().getGOF().getMD().getCYCLO() + " )";
		}
		if(t.equals("ATFD")) {
			needOperator=true;
			needSignal=true;
			result = result + "ATFD" + signal +
					GRFCCT.getGRF().getGOF().getMD().getATFD() + " )";
		}
		if(t.equals("LAA")) {
			needOperator=true;
			needSignal=true;
			result = result + "LAA" + signal + 
					GRFCCT.getGRF().getGOF().getMD().getLAA() + " )";
		}
		if(t.equals("AND")) {
			needOperator=false;
			result = result + "&& )";
		}
		if(t.equals("OR")) {
			needOperator=false;
			result = result + "|| )";
		}
		return result;
	}
	
	
	/**
	 * Este método lança um aviso acerda das thresholds para o utilizador
	 */
	private void showThresholdsWarning() {
		 final JPanel warning = new JPanel();
		 JOptionPane.showMessageDialog(warning, "Unable to select "
		 		+ "thresholds! Please select operator first!", 
		 		"Warning", JOptionPane.WARNING_MESSAGE);
	}

	
	/**
	 * Este método adiciona uma label (referente aos operadores) ao painel 
	 * @param panel - Painel
	 */
	private void buildOperatorsLabel(JPanel panel) {
		JLabel operator = new JLabel("Select a operator: ");
		panel.add(operator);
	}



	/**
	 * Este método adiciona os botões AND e OR ao painel, definindo 
	 * também as suas acções
	 * @param panel - Painel
	 */
	private void buildOperatorButtons(JPanel panel) {;
		panel.setLayout(new FlowLayout());

		final JButton and = new JButton("AND");
		and.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needOperator==true) {
					updateCondition(and.getText());
					needSignal = true;
				} else {
					showOperatorsWarning();
				}
			}
		});
		panel.add(and);

		final JButton or = new JButton("OR");
		or.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needOperator==true) {
					updateCondition(or.getText());
					needSignal = true;
				} else {
					showOperatorsWarning();
				}
			}
		});
		panel.add(or);		
	}
	
	
	/**
	 * Este método lança aviso acerca dos operadores para o utilizador
	 */
	private void showOperatorsWarning() {
		 final JPanel warning = new JPanel();
		 JOptionPane.showMessageDialog(warning, "Unable to select "
			 		+ "operator! Please select threshold first!", 
			 		"Warning", JOptionPane.WARNING_MESSAGE);
	}
	
	
	/**
	 * Este método lança um aviso de thresholds duplicadas para o utilizador
	 */
	private void showRepeatedThresholdWarning() {
		 final JPanel warning = new JPanel();
		 JOptionPane.showMessageDialog(warning, "Unable to select "
		 		+ "the threshold! Threshold is already in use!", 
		 		"Warning", JOptionPane.WARNING_MESSAGE);
	}
	
	
	/**
	 * Este método adiciona uma label (referente aos sinais) ao painel
	 * @param panel - Painel
	 */
	private void buildSignalsLabel(JPanel panel) {
		JLabel signal = new JLabel("Select a signal for threshold: ");
		panel.add(signal);
	}
	
	
	/**
	 * Este método adiciona os botões(sinais) ao painel 
	 * @param panel
	 */
	private void buildSignalButtons(JPanel panel) {
		panel.setLayout(new FlowLayout());
		
		buildBiggerButton(panel);
		buildSmallerButton(panel);
		buildEqualButton(panel);
		buildDifferentButton(panel);
		
	}
	
	
	/**
	 * Este método definie e adiciona funcionalidade ao botão ">"
	 * @param panel - Painel
	 */
	private void buildBiggerButton(JPanel panel) {
		final JButton bigger = new JButton(">");
		bigger.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needSignal==true) {
					signal = new String(">");
					needSignal = false;
					confirmSignalSelection();
				} else {
					showSignalsWarning(2);
				}
			}
		});
		panel.add(bigger);
	}
	
	
	/**
	 * Este método define e adiciona funcionalidade ao botão "<"
	 * @param panel - Painel
	 */
	private void buildSmallerButton(JPanel panel) {
		final JButton smaller = new JButton("<");
		smaller.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needSignal==true) {
					signal = new String("<");
					needSignal = false;
					confirmSignalSelection();
				} else {
					showSignalsWarning(2);
				}
			}
		});
		panel.add(smaller);	
	}
	
	
	/**
	 * Este método define e adiciona funcionalidade ao botão "=="
	 * @param panel - Painel
	 */
	private void buildEqualButton(JPanel panel) {
		final JButton equal = new JButton("==");
		equal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needSignal==true) {
					signal = new String("==");
					needSignal = false;
					confirmSignalSelection();
				} else {
					showSignalsWarning(2);
				}
			}
		});
		panel.add(equal);
	}
	
	
	/**
	 * Este método define e adiciona funcionalidade ao botão "!="
	 * @param panel - Painel
	 */
	private void buildDifferentButton(JPanel panel) {
		final JButton different = new JButton("!=");
		different.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needSignal==true) {
					signal = new String("!=");
					needSignal = false;
					confirmSignalSelection();
				} else {
					showSignalsWarning(2);
				}
			}
		});
		panel.add(different);
	}
	
	
	/**
	 * Este método lança uma mensagem informativa de sucesso para o utilizador
	 */
	private void confirmSignalSelection() {
		final JPanel warning = new JPanel();
		JOptionPane.showMessageDialog(warning, "Signal successfully selected!"
		 		, "Information",
				 JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	/**
	 * Este método lança uma mensagem de erro para o utilizador
	 * @param x - Consoante o número escolhido, envia uma mensagem de erro diferente
	 */
	private void showSignalsWarning(int x) {
		 final JPanel warning = new JPanel();
		if(x==1) {
			 JOptionPane.showMessageDialog(warning, "Unable to select threshold!"
				 		+ "Please select signal first!", 
			 		"Warning", JOptionPane.WARNING_MESSAGE);
		}
		if(x==2) {
			 JOptionPane.showMessageDialog(warning, "Unable to select "
			 		+ "signal! Please select operator first!", 
			 		"Warning", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	
	/**
	 * Este método adiciona uma label (referente à condição) ao painel
	 * @param panel - Painel
	 */
	private void buildIfConditionLabel(JPanel panel) {
		JLabel result = new JLabel("Result of the condition: ");
		panel.add(result);
	}
	
	
	/**
	 * Este método adiciona uma label (referente ao resultado da condição) ao painel
	 * @param panel - Painel
	 */
	private void buildPanelResult(JPanel panel) {
		ifCondition = new JLabel("if ( )");
		panel.add(ifCondition);
	}
	
	
	/**
	 * Este método constrói o painel sul da janela
	 * RESET - O utilizador consegue reescrever a regra
	 * OK - O utilizador guarda a regra
	 * BACK - Volta para a janela anterior
	 * @param panel - Painel
	 */
	private void buildPanelSouth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		
		JButton reset = new JButton("RESET");
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				dealWithConsequenceFrame();
				closeFrame();
				GRFCCT.closeRuleConsequenceFrame();
				GRFCCT.getGRF().dealWithNewRule();
			}
		});
		panel.add(reset);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				recordIfCondition();
			}
		});
		panel.add(ok);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dealWithConsequenceFrame();
				closeFrame();
			}
		});
		panel.add(back);
	}
	
	
	/**
	 * Este método trata dos problemas de haver janelas deste tipo duplicadas
	 */
	private void dealWithConsequenceFrame() {
		if(isGuiRuleFrameCreatingFeatureEnvyConsequenceOpen==true) {
			GRFCFEC.closeRuleConsequenceFrame();
		}
	}
	
	
	/**
	 * Este método guarda a regra criada
	 */
	private void recordIfCondition() {
		if(needCondition==false) {
			String c = ifCondition.getText();
			String[] vector = c.split(" ");
			String result = "";
			for(int i=0; i<vector.length; i++) {
				result = result + vector[i];
			}
			this.condition = result;
			openGRFCFE_consequence();
		} else {
			 final JPanel warning = new JPanel();
			 JOptionPane.showMessageDialog(warning, "Unable to proceed to "
			 		+ "the rule consequence window! Please choose a condition first!", 
			 		"Warning", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	/**
	 * Este método abre a janela GUI_Rule_Frame_Creating_Feature_Envy_Consequence 
	 * ou então lança mensagens de erro ao utilizador
	 */
	public void openGRFCFE_consequence() {	
		String ifContent = ifCondition.getText();
		String[] parts = ifContent.split(" ");
		if(parts[parts.length-2].equals("&&") || parts[parts.length-2].equals("||")) {
			 final JPanel warning = new JPanel();
			 JOptionPane.showMessageDialog(warning, "Unable to proceed for "
			 		+ "choice of consequence! Please end the "
			 		+ "condition with a threshold first!", 
			 		"Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			if (isGuiRuleFrameCreatingFeatureEnvyConsequenceOpen==true) {
				final JPanel warning = new JPanel();
				JOptionPane.showMessageDialog(warning, "Unable to open new window "
						+ "for creating rule consequence! Window is already open!", 
						"Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				this.isGuiRuleFrameCreatingFeatureEnvyConsequenceOpen = true;
				GRFCFEC = new GUI_Rule_Frame_Creating_Feature_Envy_Consequence(GRFCFE);
			}
		}
	}
	
	
	/**
	 * Este método fecha a janela atual
	 */
	public void closeFrame() {
		GRFCCT.setIsOpenGRFCFE(false);
		frame.dispose();
	}
	
}