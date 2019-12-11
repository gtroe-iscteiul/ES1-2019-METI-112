package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI_Defect_Detection {
	
	private JFrame frame;
	private GUI_Operative_Frame GOF;
	private GUI_Defect_Detection GDD;
	private int DCI;
	private int DII;
	private int ADCI;
	private int ADII;
	private int numberOfThreads;
	private GUI_Defect_Detection_Rule GDDR;
	private boolean isOpenGDDR;
	private String chosenRule;
	
	
	public GUI_Defect_Detection (GUI_Operative_Frame g) {
		this.GOF = g;
		GDD = this;
		initIndicators();
		this.numberOfThreads = 0;
		this.chosenRule = "";
		this.isOpenGDDR = false;
		init();
	}
	
	
	private void initIndicators() {
		this.DII = 0;
		this.DII = 0;
		this.ADCI = 0;
		this.ADII = 0;
	}
	
	
	public GUI_Operative_Frame getGOF() {
		return GOF;
	}
	
	
	public synchronized int getNumberOfThreads() {
		return numberOfThreads;
	}
	
	
	public synchronized void setThreadWorkingUp() {
		this.numberOfThreads++;
	}
	
	
	public synchronized void setThreadWorkingDown() {
		this.numberOfThreads--;
	}
	
	
	public synchronized int getDCI() {
		return DCI;
	}
	
	
	public synchronized int getDII() {
		return DII;
	}
	
	
	public synchronized int getADCI() {
		return ADCI;
	}
	
	
	public synchronized int getADII() {
		return ADII;
	}
	
	
	public synchronized void setDCI(int number) {
		this.DCI = number;
	}
	
	
	public synchronized void setDII(int number) {
		this.DII = number;
	}
	
	
	public synchronized void setADCI(int number) {
		this.ADCI = number;
	}
	
	
	public synchronized void setADII(int number) {
		this.ADII = number;
	}
	
	
	public void setChosenRule (String rule) {
		this.chosenRule = rule;
	}
	
	
	public void setIsOpenGDDR (boolean state) {
		isOpenGDDR = state;
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
//				defectCalculation("iPlasma", "is_long_method");
				defectDetection("iPlasma", "is_long_method");
			}
		});
		panel.add(iplasma);
		
		JButton pmd = new JButton("PMD");
		pmd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				defectCalculation("PMD", "is_long_method");
				defectDetection("PMD", "is_long_method");
			}
		});
		panel.add(pmd);
		
		JButton rule = new JButton("Created rule");
		rule.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(isOpenGDDR==true) {
					final JPanel warning = new JPanel();
					JOptionPane.showMessageDialog(warning, "Unable to open new "
							+ "window for the rule selection! Windows is already "
							+ "open!", "Warning", JOptionPane.WARNING_MESSAGE);
				} else {
					isOpenGDDR=true;
					GDDR = new GUI_Defect_Detection_Rule(GDD);
				}
			}
		});
		panel.add(rule);
	}
	
	
	private void defectDetection(String tool, String metric) {
		System.out.println("//////////Defects Detection Started//////////");
		int dci = 0;
		int dii = 0;
		int adci = 0;
		int adii = 0;
		int lines = getGOF().getGMC().getFile().getNumberOfLines();
		for(int i=1; i<lines; i++) {
			int auxDCI = 0;
			int auxDII = 0;
			int auxADCI = 0;
			int auxADII = 0;
			System.out.println("Method ID: " + i);
			System.out.println("Using Tool: " + tool);
			if(getGOF().getGMC().getFile().getCellValue(i, tool).equals("true") && 
			  getGOF().getGMC().getFile().getCellValue(i, metric).equals("true")) {
				dci++;
				auxDCI++;
			}
			if(getGOF().getGMC().getFile().getCellValue(i, tool).equals("true") && 
			  getGOF().getGMC().getFile().getCellValue(i, metric).equals("false")) {
				dii++;
				auxDII++;
			}
			if(getGOF().getGMC().getFile().getCellValue(i, tool).equals("false") && 
			  getGOF().getGMC().getFile().getCellValue(i, metric).equals("false")) {
				adci++;
				auxADCI++;
			}
			if(getGOF().getGMC().getFile().getCellValue(i, tool).equals("false") && 
			  getGOF().getGMC().getFile().getCellValue(i, metric).equals("true")) {
				adii++;
				auxADII++;
			}
			System.out.println("Number of hits (DCI + DII): " + (auxDCI + auxDII));
			System.out.println("Error number (ADCI + ADII): " + (auxADCI + auxADII));
			System.out.println("\n");
		}
		setDCI(dci);
		setDII(dii);
		setADCI(adci);
		setADII(adii);
		System.out.println("//////////Defects Detection Finished//////////");
		System.out.println("\n");
		calculationOfQualityIndicators();
	}
	
	
	public void defectDetectionForRule() {
		System.out.println("Procurar com regra '" + chosenRule + "'");
	
	}
	
	
	// This function will be use on sprint3 to show the quality indicators
	// We should determine if this function will allow us to calculate defects
	@SuppressWarnings("unused")
	private void defectCalculation(String tool, String metric) {
		DefectDetectionThread d1 = new DefectDetectionThread(this,"DCI",tool,metric);
		numberOfThreads++;
		d1.start();
		DefectDetectionThread d2 = new DefectDetectionThread(this,"DII",tool,metric);
		numberOfThreads++;
		d2.start();
		DefectDetectionThread d3 = new DefectDetectionThread(this,"ADCI",tool,metric);
		numberOfThreads++;
		d3.start();
		DefectDetectionThread d4 = new DefectDetectionThread(this,"ADII",tool,metric);
		numberOfThreads++;
		d4.start();
		while(numberOfThreads!=0) {
			//waiting for threads to finish
			System.out.println("calculating...");
		}
		calculationOfQualityIndicators();
	}
	
	
	// This function will be use on sprint3 to show the quality indicators
	// On sprint3, we should replace de "sysout" with a JFrame
	private void calculationOfQualityIndicators() {
		System.out.println("Quality Indicators:");
		System.out.println("DCI: " + DCI);
		System.out.println("DII: " + DII);
		System.out.println("ADCI: " + ADCI);
		System.out.println("ADII: " + ADII);
	}

	
	private void buildPanelSouth(JPanel panel) {
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(isOpenGDDR==true) {
					setIsOpenGDDR(false);
					GDDR.closeFrame();
				}
				GOF.setIsOpenGDD(false);
				frame.dispose();
			}
		});
		panel.add(back);
	}
	
}