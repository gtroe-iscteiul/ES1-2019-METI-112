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
//	private int DCI;
//	private int DII;
//	private int ADCI;
//	private int ADII;
	
	
	public GUI_Defect_Detection (GUI_Operative_Frame g) {
		this.GOF = g;
//		setIndicatorsNull();
		init();
	}
	
	
	public GUI_Operative_Frame getGOF() {
		return GOF;
	}
	
	
/*	public void setDCI(int number) {
		this.DCI = number;
	}
	
	
	public void setDII(int number) {
		this.DII = number;
	}
	
	
	public void setADCI(int number) {
		this.ADCI = number;
	}
	
	
	public void setADII(int number) {
		this.ADII = number;
	}
*/	
	
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
//				setIndicatorsNull();
				defectCalculation("iPlasma", "is_long_method");
			}
		});
		panel.add(iplasma);
		
		JButton pmd = new JButton("PMD");
		pmd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				setIndicatorsNull();
				defectCalculation("PMD", "is_long_method");
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
	
	
/*	private void setIndicatorsNull() {
		DCI = 0;
		DII = 0;
		ADCI = 0;
		ADII = 0;
	}
*/	
	
	private void defectCalculation(String tool, String metric) {
/*		DefectDetectionThread d1 = new DefectDetectionThread(this,"DCI",tool,metric);
		d1.start();
		DefectDetectionThread d2 = new DefectDetectionThread(this,"DII",tool,metric);
		d2.start();
		DefectDetectionThread d3 = new DefectDetectionThread(this,"ADCI",tool,metric);
		d3.start();
		DefectDetectionThread d4 = new DefectDetectionThread(this,"ADII",tool,metric);
		d4.start();
		while(true) {
			System.out.println("em espera...");
		}
*/		System.out.println("Defect Detection: " + tool);
		System.out.println("DCI: " + getResultsDCI(tool, metric));
//		System.out.println("DII: " + getResultsDII(tool, metric));
//		System.out.println("ADCI: " + getResultsADCI(tool, metric));
//		System.out.println("ADII: " + getResultsADII(tool, metric));
	}
	
	
	private int getResultsDCI(String tool, String metric) {
		int DCI = 0;
		int lines = getGOF().getGMC().getFile().getNumberOfLines();
		for(int i=1; i<lines; i++) {
			if(getGOF().getGMC().getFile().getCellValue(i, tool).equals("true") && 
			  getGOF().getGMC().getFile().getCellValue(i, metric).equals("true")) {
				DCI++;
			}
		}
		return DCI;
	}
	
	
	private int getResultsDII(String tool, String metric) {
		int DII = 0;
		int lines = getGOF().getGMC().getFile().getNumberOfLines();
		for(int i=1; i<lines; i++) {
			if(getGOF().getGMC().getFile().getCellValue(i, tool).equals("true") && 
			  getGOF().getGMC().getFile().getCellValue(i, metric).equals("false")) {
				DII++;
			}
		}
		return DII;
	}
	
	private int getResultsADCI(String tool, String metric) {
		int ADCI = 0;
		int lines = getGOF().getGMC().getFile().getNumberOfLines();
		for(int i=1; i<lines; i++) {
			if(getGOF().getGMC().getFile().getCellValue(i, tool).equals("false") && 
			  getGOF().getGMC().getFile().getCellValue(i, metric).equals("false")) {
				ADCI++;
			}
		}
		return ADCI;
	}
	
	
	private int getResultsADII(String tool, String metric) {
		int ADII = 0;
		int lines = getGOF().getGMC().getFile().getNumberOfLines();
		for(int i=1; i<lines; i++) {
			if(getGOF().getGMC().getFile().getCellValue(i, tool).equals("false") && 
			  getGOF().getGMC().getFile().getCellValue(i, metric).equals("true")) {
				ADII++;
			}
		}
		return ADII;
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