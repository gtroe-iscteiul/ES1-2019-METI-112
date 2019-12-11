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
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI_Defect_Detection_Rule {
	
	private JFrame frame;
	private GUI_Defect_Detection GDD;
	private AccessToRuleDatabase database;
	private JList<String> list;


	public GUI_Defect_Detection_Rule(GUI_Defect_Detection g) {
		this.GDD = g;
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
				setRuleInformation();
			}
		});
		panelSouth.add(select);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GDD.setIsOpenGDDR(false);
				frame.dispose();
			}
		});
		panelSouth.add(back);
	}
	
	
	private void setRuleInformation() {
		String[] vector = list.getSelectedValue().toString().split(" ");
		String rule = vector[1] + " " + vector[2];
		
		GDD.setChosenRule(rule);
		
		closeFrame();
		
		GDD.defectDetectionForRule();
	}
	
	
	public void closeFrame() {
		GDD.setIsOpenGDDR(false);
		frame.dispose();
	}
	
}