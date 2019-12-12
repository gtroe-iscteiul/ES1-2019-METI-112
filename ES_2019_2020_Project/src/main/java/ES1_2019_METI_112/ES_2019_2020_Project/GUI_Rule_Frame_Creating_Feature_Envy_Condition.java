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
	
	
	public GUI_Rule_Frame_Creating_Feature_Envy_Condition(
			GUI_Rule_Frame_Choosing_Consequence_Type g) {
		this.GRFCCT = g;
		GRFCFE = this;
		this.isGuiRuleFrameCreatingFeatureEnvyConsequenceOpen = false;
		this.isLocUsed = false;
		this.isCycloUsed = false;
		this.isAtfdUsed = false;
		this.isLaaUsed = false;
		init();
		
	}
	
	
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
	
	
	private void init () {
		frame = new JFrame("Software Quality Assessment");
		frame.setLayout(new BorderLayout());
		addFrameContent();
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.pack();
		open();
	}
	
	
	@SuppressWarnings("deprecation")
	private void open(){
		frame.setSize(500, 400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(400, 150);
	}
	
	
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
	
	
	private void buildPanelNorth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("Selection of 'if' condition: ");
		panel.add(searchText);
	}
	
	
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
	
	
	private void buildThresholdsLabel(JPanel panel) {
		JLabel thresholds = new JLabel("Select a threshold: ");
		panel.add(thresholds);
	}
	
	
	private void buildThresholdButtons(JPanel panel) {
		panel.setLayout(new GridLayout(2,2));
		
		locButton(panel);
		cycloButton(panel);
		atfdButton(panel);
		laaButton(panel);
	}
	
	
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
	
	
	private void updateCondition(String type) {
		String ifContent = ifCondition.getText();
		panelCenterResultComponent.remove(ifCondition);	
		String[] parts = ifContent.split(" ");
		String result="";
		for(int i=0; i<parts.length-1; i++) {
			result = result + parts[i] + " ";
		}
//		if(needOperator==true) {
//			result = result + "&&";
//			needOperator=false;
//		}
		result = result + dealWithType(type);
		ifCondition = new JLabel(result);
		panelCenterResultComponent.add(ifCondition);
		frame.validate();
	}
	
	
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
	
	
	private void showThresholdsWarning() {
		 final JPanel warning = new JPanel();
		 JOptionPane.showMessageDialog(warning, "Unable to select "
		 		+ "thresholds! Please select operator first!", 
		 		"Warning", JOptionPane.WARNING_MESSAGE);
	}


	private void buildOperatorsLabel(JPanel panel) {
		JLabel operator = new JLabel("Select a operator: ");
		panel.add(operator);
	}


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
	
	
	private void showOperatorsWarning() {
		 final JPanel warning = new JPanel();
		 JOptionPane.showMessageDialog(warning, "Unable to select "
			 		+ "operator! Please select threshold first!", 
			 		"Warning", JOptionPane.WARNING_MESSAGE);
	}
	
	
	private void showRepeatedThresholdWarning() {
		 final JPanel warning = new JPanel();
		 JOptionPane.showMessageDialog(warning, "Unable to select "
		 		+ "the threshold! Threshold is already in use!", 
		 		"Warning", JOptionPane.WARNING_MESSAGE);
	}
	
	
	private void buildSignalsLabel(JPanel panel) {
		JLabel signal = new JLabel("Select a signal for threshold: ");
		panel.add(signal);
	}
	
	
	private void buildSignalButtons(JPanel panel) {
		panel.setLayout(new FlowLayout());
		
		buildBiggerButton(panel);
		buildSmallerButton(panel);
		buildEqualButton(panel);
		buildDifferentButton(panel);
		
	}
	
	
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
	
	
	private void confirmSignalSelection() {
		final JPanel warning = new JPanel();
		JOptionPane.showMessageDialog(warning, "Signal successfully selected!"
		 		, "Information",
				 JOptionPane.INFORMATION_MESSAGE);
	}
	
	
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
	
	
	private void buildIfConditionLabel(JPanel panel) {
		JLabel result = new JLabel("Result of the condition: ");
		panel.add(result);
	}
	
	
	private void buildPanelResult(JPanel panel) {
		ifCondition = new JLabel("if ( )");
		panel.add(ifCondition);
	}
	
	
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
				openGRFCFE_consequence();
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
	
	
	private void dealWithConsequenceFrame() {
		if(isGuiRuleFrameCreatingFeatureEnvyConsequenceOpen==true) {
			GRFCFEC.closeRuleConsequenceFrame();
		}
	}
	
	
	private void recordIfCondition() {
		String c = ifCondition.getText();
		String[] vector = c.split(" ");
		String result = "";
		for(int i=0; i<vector.length; i++) {
			result = result + vector[i];
		}
		this.condition = result;
	}
	
	
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
	
	
	public void closeFrame() {
		GRFCCT.setIsOpenGRFCFE(false);
		frame.dispose();
	}
	
}