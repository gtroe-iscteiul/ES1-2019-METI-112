package ES1_2019_METI_112.ES_2019_2020_Project;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GUI_Rules_Frame {

	private JFrame frame;
	private GUI_Rules_Frame GRF;
	private GUI_Operative_Frame GOF;
	private GUI_Rule_Frame_Choosing_Consequence_Type GRFCCT;
	private GUI_Rule_Frame_Viewing GRFV;
	private boolean isGuiRuleFrameChoosingConsequenceTypeOpen = false;
	private boolean isGuiRuleFrameViewingOpen = false;
	
	
	public GUI_Rules_Frame(GUI_Operative_Frame g) {
		this.GOF = g;
		GRF = this;
		init();
	}
	
	
	public GUI_Operative_Frame getGOF() {
		return GOF;
	}
	
	
	public GUI_Rule_Frame_Choosing_Consequence_Type getGRFCCT() {
		return GRFCCT;
	}
	
	
	public GUI_Rule_Frame_Viewing getGRFV() {
		return GRFV;
	}

	
	public boolean isOpenGRFCCT() {
		return isGuiRuleFrameChoosingConsequenceTypeOpen;
	}
	
	
	public boolean isOpenGRFV() {
		return isGuiRuleFrameViewingOpen;
	}
	
	
	public void setIsOpenGRFCCT(boolean state) {
		isGuiRuleFrameChoosingConsequenceTypeOpen = state;
	}
	
	
	public void setIsOpenGRFV(boolean state) {
		isGuiRuleFrameViewingOpen = state;
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
		frame.setSize(500, 200);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(400, 190);
	}
	

	private void addFrameContent(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		buildPanel(panel);
		frame.add(panel, BorderLayout.CENTER);
	}
	
	
	private void buildPanel(JPanel panel) {
		JButton visualization = new JButton("View Rules");
		visualization.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dealWithExistingRules();
			}
		});
		panel.add(visualization);
		
		JButton newRule = new JButton("Create New Rule");
		newRule.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dealWithNewRule();
			}
		});
		panel.add(newRule);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GOF.setIsOpenGRF(false);
				frame.dispose();
			}
		});
		panel.add(back);
	}
	
	
	public void dealWithNewRule() {		
		if(GOF.getMD().hasBeenInitialized()==true) {
			if (isGuiRuleFrameChoosingConsequenceTypeOpen==true) {
				final JPanel warning = new JPanel();
				JOptionPane.showMessageDialog(warning, "Unable to open new window "
						+ "for rules creation! Window is already open!", 
						"Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				this.isGuiRuleFrameChoosingConsequenceTypeOpen = true;
				GRFCCT = new GUI_Rule_Frame_Choosing_Consequence_Type(GRF);
			}
		} else {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Unable to open new window "
					+ "to set rules! The limits of thresholds must "
					+ "be initialized first!", 
					"Warning", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	private void dealWithExistingRules() {
		if (isGuiRuleFrameViewingOpen==true) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Unable to open new window "
					+ "for rules visualization! Window is already open!", 
					"Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			this.isGuiRuleFrameViewingOpen = true;
			GRFV = new GUI_Rule_Frame_Viewing(GRF);
		}
	}

}
