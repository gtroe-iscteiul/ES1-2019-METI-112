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

public class GUI_Rule_Frame_Choosing_Consequence_Type {

	private JFrame frame;
	private GUI_Rules_Frame GRF;
	private GUI_Rule_Frame_Choosing_Consequence_Type GRFCCT;	
	private GUI_Rule_Frame_Creating_Long_Method GRCLM;
	private GUI_Rule_Frame_Creating_Feature_Envy_Condition GRCFE;
	private boolean isGuiRuleFrameCreatingLongMethodOpen = false;
	private boolean isGuiRuleFrameCreatingFeatureEnvy = false;
	
	
	public GUI_Rule_Frame_Choosing_Consequence_Type(GUI_Rules_Frame grf) {
		this.GRF = grf;
		GRFCCT = this;
		init();
	}	
	
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
	
	
	public boolean isOpenGRFCFE() {
		return isGuiRuleFrameCreatingFeatureEnvy;
	}
	
	
	public void setIsOpenGRFCFE(boolean state) {
		isGuiRuleFrameCreatingFeatureEnvy = state;
	}
	
	
	public boolean isOpenGRFCLM() {
		return isGuiRuleFrameCreatingLongMethodOpen;
	}
	
	
	public void setIsOpenGRFCLM(boolean state) {
		isGuiRuleFrameCreatingLongMethodOpen = state;
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
		JPanel panelCenterComponent = new JPanel();
		JPanel panelSouth = new JPanel();
		
		buildPanelNorth(panelNorth);
		buildPanelCenter(panelCenter, panelCenterComponent);
		buildPanelSouth(panelSouth);
		
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelSouth, BorderLayout.SOUTH);
	}
	
	
	private void buildPanelNorth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		JLabel searchText = new JLabel(
				"Select a metric to define as 'if' consequence: ");
		panel.add(searchText);
	}
	
	
	private void buildPanelCenter(JPanel c, JPanel pc) {
		c.setLayout(new GridLayout(1,2));
		buildMetricButtons(pc);
		c.add(pc);
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
				openLongMethodFrame();
			}
		});
		panel.add(longM);
	}
	
	
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
	
	
	private void featureEnvyButton(JPanel panel) {
		final JButton featureE = new JButton("Feature Envy");
		featureE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				openFeatureEnvyFrame();
			}
		});
		panel.add(featureE);
	}
	
	
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
	
		
	public void dealWithAfterFrame() {
		if(isGuiRuleFrameCreatingLongMethodOpen==true) {
			GRCLM.closeFrame();
		}
		if(isGuiRuleFrameCreatingFeatureEnvy==true) {
			GRCFE.closeFrame();
		}
	}
		

	public void closeRuleConsequenceFrame() {
		GRF.setIsOpenGRFCCT(false);
		frame.dispose();
	}
	
}