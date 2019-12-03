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

public class GUI_Defect_Detection {
	
	private JFrame frame;
	private GUI_Operative_Frame GOF;
	
	
	public GUI_Defect_Detection (GUI_Operative_Frame g) {
		this.GOF = g;
		init();
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
		JLabel label = new JLabel("Define the tool to use: ");
		panel.add(label);
	}
	
	
	private void buildPanelCenter(JPanel panel) {
		panel.setLayout(new GridLayout(3,1));
		
		JButton iplasma = new JButton("iPlasma");
		iplasma.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dealWithIPlasma();
			}
		});
		panel.add(iplasma);
		
		JButton pmd = new JButton("PMD");
		pmd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dealWithPMD();
			}
		});
		panel.add(pmd);
		
		JButton rule = new JButton("Created rule");
		rule.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("cálculo com uma das regras da base de dados");
			}
		});
		panel.add(rule);
	}
	
	
	private void dealWithIPlasma() {
		System.out.println("Cálculo com iPlasma e is_long_method");
		int lines = GOF.getGMC().getFile().getNumberOfLines();
		for(int i=0; i<lines; i++) {
			System.out.println(GOF.getGMC().getFile().getCellValue(i, "iPlasma") + 
					GOF.getGMC().getFile().getCellValue(i, "is_long_method"));
		}
	}
	
	
	private void dealWithPMD() {
		System.out.println("Cálculo com PMD");
		int lines = GOF.getGMC().getFile().getNumberOfLines();
		for(int i=0; i<lines; i++) {
			System.out.println(GOF.getGMC().getFile().getCellValue(i, "PMD") +
					GOF.getGMC().getFile().getCellValue(i, "is_long_method"));
		}
	}
	
	
	private void buildPanelSouth(JPanel panel) {
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GOF.setIsOpenGDD(false);
				frame.dispose();
			}
		});
		panel.add(back);
	}
	
}