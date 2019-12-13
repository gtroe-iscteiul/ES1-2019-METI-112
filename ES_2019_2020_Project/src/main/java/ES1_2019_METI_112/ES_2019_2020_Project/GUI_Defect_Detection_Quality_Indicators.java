package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI_Defect_Detection_Quality_Indicators {
	
	private JFrame frame;
	private GUI_Defect_Detection_JTable GDDJT;
	

	public GUI_Defect_Detection_Quality_Indicators(GUI_Defect_Detection_JTable g) {
		this.GDDJT = g;
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
		frame.setSize(300, 250);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(500, 250);	
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
		JLabel searchText = new JLabel("Quality indicators for " + GDDJT.getTool() + ":");
		panelNorth.add(searchText);
	}
	
	
	private void buildPanelCenter(JPanel panelCenter) {
		panelCenter.setLayout(new GridLayout(4,1));
		
		String space = "                                       ";
		
		JLabel dci = new JLabel(space + "DCI: " + GDDJT.getGDD().getDCI()); 
		JLabel dii = new JLabel(space + "DII: " + GDDJT.getGDD().getDII()); 		
		JLabel adci = new JLabel(space + "ADCI: " + GDDJT.getGDD().getADCI()); 
		JLabel adii = new JLabel(space + "ADII: " + GDDJT.getGDD().getADII());
		
		panelCenter.add(dci);
		panelCenter.add(dii);
		panelCenter.add(adci);
		panelCenter.add(adii);
		
	}	
	
	
	private void buildPanelSouth(JPanel panelSouth) {
		panelSouth.setLayout(new FlowLayout());
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				closeFrame();
			}
		});
		panelSouth.add(back);
	}
	
	
	public void closeFrame() {
		GDDJT.setIsOpenGDDQI(false);
		frame.dispose();
	}
	
}