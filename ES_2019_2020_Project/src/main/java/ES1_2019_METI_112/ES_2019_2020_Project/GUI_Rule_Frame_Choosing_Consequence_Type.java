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
//	private GUI_Rules_Frame GRF;
	private GUI_Rule_Frame_Choosing_Consequence_Type GRFCCT;
	
	
	public GUI_Rule_Frame_Choosing_Consequence_Type() {//GUI_Rules_Frame grf) {
//		this.GRF = grf;
		GRFCCT = this;
		init();
	}	
	
	public GUI_Rule_Frame_Choosing_Consequence_Type getGRFCCT() {
		return GRFCCT;
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
				final JPanel warning = new JPanel();
				JOptionPane.showMessageDialog(warning, "The method for this "
						+ "metric is predefined and will only update previously "
						+ "defined threshold limits!", "Information",
						 JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panel.add(longM);
	}
	
	
	private void featureEnvyButton(JPanel panel) {
		final JButton featureE = new JButton("Feature Envy");
		featureE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("abrir GUI feature envy");
			}
		});
		panel.add(featureE);
	}
	
	
	private void buildPanelSouth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				dealWithFinalResultFrame(); //if next window is open
//				closeRuleConsequenceFrame(); //close this frame
				System.out.println("voltar a trás");
			}
		});
		panel.add(back);
		
	}
	
		
//	private void dealWithFinalResultFrame() {
//		if(isGuiRuleFrameCreatingFinalResultOpen==true) {
//			GRFCFR.closeRuleResultFrame();
//		}
//	}
	
	
/*	private void openGRFCFR() {
		if(response.equals("Feature Envy") || response.equals("Long Method")) {
			if (isGuiRuleFrameCreatingFinalResultOpen==true) {
				final JPanel warning = new JPanel();
				JOptionPane.showMessageDialog(warning, "Unable to open the rule"
						+ "check window! Window is already open!", 
						"Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				consequence = ifConsequence.getText();
				isGuiRuleFrameCreatingFinalResultOpen=true;
				GRFCFR = new GUI_Rule_Frame_Creating_Final_Result(GRFC_consequence);
			}
		} else {
			 final JPanel warning = new JPanel();
			 JOptionPane.showMessageDialog(warning, "Unable to proceed to "
			 		+ "the rule check window! Please choose a metric first!", 
			 		"Warning", JOptionPane.WARNING_MESSAGE);
		}
		
	}
*/	
	
	// this allows to return to previous window
//	public void closeRuleConsequenceFrame() {
//		GRF.setIsOpenGRFCCT(false);
//		frame.dispose();
//	}
	
	
	public static void main(String[] args) {
		GUI_Rule_Frame_Choosing_Consequence_Type grfcct = 
				new GUI_Rule_Frame_Choosing_Consequence_Type();
		grfcct.init();
	}
	
}