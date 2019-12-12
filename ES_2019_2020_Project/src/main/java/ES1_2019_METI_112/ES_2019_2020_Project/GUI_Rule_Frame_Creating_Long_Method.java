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
	
	
	public GUI_Rule_Frame_Creating_Long_Method (
			GUI_Rule_Frame_Choosing_Consequence_Type g) {
		this.GRFCCT = g;
		database = new AccessToRuleDatabase("CreatedRuleDatabase");
		init();
	}
	
	
	private void init() {
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
		JPanel panelSouth = new JPanel();
		
		buildPanelNorth(panelNorth);
		buildPanelCenter(panelCenter);
		buildPanelSouth(panelSouth);
		
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelSouth, BorderLayout.SOUTH);
	}
	
	
	private void buildPanelNorth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("Rule summary: ");
		panel.add(searchText);
	}
	
	
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
	
	
	public void closeFrame() {
		GRFCCT.setIsOpenGRFCLM(false);
		frame.dispose();
	}
	
	
	private void showInformationMessage() {
		final JPanel warning = new JPanel();
		JOptionPane.showMessageDialog(warning, "Successfully saved!"
		 		, "Information",
				 JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	private void closeAllRuleFrameCreating() {
		closeFrame();
		GRFCCT.closeRuleConsequenceFrame();
	}
	
}