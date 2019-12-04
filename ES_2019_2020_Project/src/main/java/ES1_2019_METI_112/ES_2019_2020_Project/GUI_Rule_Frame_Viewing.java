package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI_Rule_Frame_Viewing {

	private JFrame frame;
	private GUI_Rules_Frame GRF;
	private AccessToRuleDatabase database;
	private JList<String> list;


	public GUI_Rule_Frame_Viewing(GUI_Rules_Frame grf) {
		this.GRF = grf;
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
	private void open() {
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
		buildPanelSouth(panelSouth);
		buildPanelCenter(panelCenter);
		
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.add(panelCenter, BorderLayout.CENTER);
	}
	
	
	private void buildPanelNorth(JPanel panelNorth) {
		panelNorth.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("List of rules created: ");
		panelNorth.add(searchText);
	}
	
	
	private void buildPanelCenter(JPanel panelCenter) {
		panelCenter.setLayout(new FlowLayout());
		String[] conteudo;
	    DefaultListModel<String> listModel = new DefaultListModel<>();
	    try {
			conteudo = database.readFile();
			for (int i = 0; i < conteudo.length; i++) {
				listModel.addElement(conteudo[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    list = new JList<String>(listModel);
	    panelCenter.add(list);
	}	
	
	
	private void buildPanelSouth(JPanel panelSouth) {
		panelSouth.setLayout(new FlowLayout());
		
		JButton select = new JButton("SELECT");
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				getRuleInformation();
			}
		});
		panelSouth.add(select);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				deleteRuleFromDatabase(); 
			}
		});
		panelSouth.add(delete);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GRF.setIsOpenGRFV(false);
				frame.dispose();
			}
		});
		panelSouth.add(back);
	}
	
	
	private void getRuleInformation() {
		String[] vector = list.getSelectedValue().toString().split(" ");
		String ID = "Rule ID: " + vector[0];
		String condition = "Condition (if): " + vector[1];
		String consequence = "Consequence (then): " + vector[2];
		String result = ID + "\n" + "\n" + condition + "\n" + "\n" + consequence;
		
		final JPanel warning = new JPanel();
		JOptionPane.showMessageDialog(warning, result, "Information",
				 JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	private void deleteRuleFromDatabase() {
		// 2 linhas a seguir remove da JList
//		int index = list.getSelectedIndex();
//		((DefaultListModel<String>) list.getModel()).remove(index);
		try {
			// remove do ficheiro txt
			database.deleteRule(list.getSelectedValue().toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		final JPanel warning = new JPanel();
		JOptionPane.showMessageDialog(warning, "Rule deleted successfully!", 
				"Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
