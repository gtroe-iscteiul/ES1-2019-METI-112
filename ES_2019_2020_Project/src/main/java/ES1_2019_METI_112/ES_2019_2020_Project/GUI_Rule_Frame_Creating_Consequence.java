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

public class GUI_Rule_Frame_Creating_Consequence {

	private JFrame frame;
	private GUI_Rule_Frame_Creating_Condition GRFC_condition;
	private GUI_Rule_Frame_Creating_Consequence GRFC_consequence;
	private JLabel ifConsequence;
	private JPanel panelCenterResultComponent;
	private boolean needMetric=true;
	private GUI_Rule_Frame_Creating_Final_Result GRFCFR;
	private boolean isGuiRuleFrameCreatingFinalResultOpen = false;
	private String consequence;


	public GUI_Rule_Frame_Creating_Consequence(GUI_Rule_Frame_Creating_Condition g) {
		this.GRFC_condition = g;
		GRFC_consequence = this;
		init();
	}
	
	
	public boolean isOpenGRFCFR() {
		return isGuiRuleFrameCreatingFinalResultOpen;
	}
	
	
	public void setIsOpenGRFCFR(boolean state) {
		isGuiRuleFrameCreatingFinalResultOpen = state;
	}
	
	
	public GUI_Rule_Frame_Creating_Final_Result getGRFCFR() {
		return GRFCFR;
	}
	
	
	public String getConsequece() {
		return consequence;
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
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(400, 150);
	}
	
	
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
	
	
	private void buildPanelNorth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("Selection of 'if' consequence: ");
		panel.add(searchText);
	}
	
	
	private void buildPanelCenter(JPanel c, JPanel pc1, JPanel pc2, 
			JPanel pc3, JPanel pc4) {
		
		c.setLayout(new GridLayout(3,2));
		
		JLabel l1 = new JLabel("             ");
		JLabel l2 = new JLabel("             ");
		buildMetricsLabel(pc1);
		buildMetricButtons(pc2);
		buildIfConsequenceLabel(pc3);
		buildPanelResult(pc4);
		c.add(pc1);
		c.add(pc2);
		c.add(l1);
		c.add(l2);
		c.add(pc3);
		c.add(pc4);
	}
	
	
	private void buildMetricsLabel(JPanel panel) {
		JLabel metrics = new JLabel("Select a metric: ");
		panel.add(metrics);
	}
	
	
	private void buildMetricButtons(JPanel panel) {
		panel.setLayout(new GridLayout(2,1));
		
		longMethodButton(panel);
		featureEnvyButton(panel);
	}
	
	
	private void longMethodButton(JPanel panel) {
		final JButton longM = new JButton("Long Method");
		longM.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needMetric==true) {
					updateConsequence(longM.getText());
				} else {
					showMetricsWarning();
				}
			}
		});
		panel.add(longM);
	}
	
	
	private void featureEnvyButton(JPanel panel) {
		final JButton featureE = new JButton("Feature Envy");
		featureE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needMetric==true) {
					updateConsequence(featureE.getText());
				} else {
					showMetricsWarning();
				}
			}
		});
		panel.add(featureE);
	}
	
	
	private void updateConsequence(String type) {
		needMetric=false;
		panelCenterResultComponent.remove(ifConsequence);	
		ifConsequence = new JLabel(type);
		panelCenterResultComponent.add(ifConsequence);
		frame.validate();
	}
	
	
	private void showMetricsWarning() {
		 final JPanel warning = new JPanel();
		 JOptionPane.showMessageDialog(warning, "Unable to select metrics! "
		 		+ "Metric already selected! To select again, first reset!", 
		 		"Warning", JOptionPane.WARNING_MESSAGE);
	}
	
	
	private void buildIfConsequenceLabel(JPanel panel) {
		JLabel result = new JLabel("Metric used as consequence: ");
		panel.add(result);
	}
	
	
	private void buildPanelResult(JPanel panel) {
		ifConsequence = new JLabel("");
		panel.add(ifConsequence);
	}
	
	
	private void buildPanelSouth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		
		JButton reset = new JButton("RESET");
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dealWithFinalResultFrame();
				closeRuleConsequenceFrame();
				GRFC_condition.openGRFCconsequence();
			}
		});
		panel.add(reset);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				consequence = ifConsequence.getText();
				openGRFCFR();
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
				GRFC_consequence.closeRuleConsequenceFrame();
				GRFC_condition.closeRuleConditionFrame();
			}
		});
		panel.add(cancel);
	}
	
	
	private void dealWithFinalResultFrame() {
		if(isGuiRuleFrameCreatingFinalResultOpen==true) {
			GRFCFR.closeRuleResultFrame();
		}
	}
	
	
	private void openGRFCFR() {
		System.out.println("Passar para frame de resumo da regra...");
		System.out.println("Condição: " + GRFC_condition.getCondition());
		System.out.println("Consequência: " + getConsequece());
		GRFCFR = new GUI_Rule_Frame_Creating_Final_Result(GRFC_consequence);
	}
	
	
	public void closeRuleConsequenceFrame() {
		GRFC_condition.setIsOpenGRFCconsequence(false);
		frame.dispose();
	}
	
}
