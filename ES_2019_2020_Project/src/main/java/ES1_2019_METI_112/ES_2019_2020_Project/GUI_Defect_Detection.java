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
	private String[][] defectsCalculated;
	private GUI_Defect_Detection_JTable GDDJT;
	private boolean isOpenGDDJT;
	
	
	public GUI_Defect_Detection (GUI_Operative_Frame g) {
		this.GOF = g;
		GDD = this;
		initIndicators();
		this.numberOfThreads = 0;
		this.chosenRule = "";
		this.isOpenGDDR = false;
		this.isOpenGDDJT = false;
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
	
	
	public GUI_Defect_Detection_JTable getGDDJT() {
		return GDDJT;
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
	
	public void setIsOpenGDDJT (boolean state) {
		isOpenGDDJT = state;
	}
	
	
	public String getElementFromMatrix(int l, int c) {
		String aux = defectsCalculated[l][c];
		return aux;
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
				defectDetection("iPlasma", "is_long_method");
			}
		});
		panel.add(iplasma);
		
		JButton pmd = new JButton("PMD");
		pmd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
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
		int dci = 0;
		int dii = 0;
		int adci = 0;
		int adii = 0;
		int lines = getGOF().getGMC().getFile().getNumberOfLines();
		
		defectsCalculated = new String[lines][4];
		defectsCalculated[0][0] = "Method ID";
		defectsCalculated[0][1] = "Used Tool";
		defectsCalculated[0][2] = "Number of hits (DCI + DII)";
		defectsCalculated[0][3] = "Error number (ADCI + ADII)";
		
		waiting();
		
		for(int i=1; i<lines; i++) {
			int auxDCI = 0;
			int auxDII = 0;
			int auxADCI = 0;
			int auxADII = 0;

			defectsCalculated[i][0] = "" + i;
			defectsCalculated[i][1] = tool;
			
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
			int aux1 = auxDCI + auxDII;
			int aux2 = auxADCI + auxADII;
			defectsCalculated[i][2] = "" + aux1;
			defectsCalculated[i][3] = "" + aux2;
		}
		setDCI(dci);
		setDII(dii);
		setADCI(adci);
		setADII(adii);
		openGDDJT();
	}
	
	
	public void defectDetectionForRule() {
		String[] ifRule = chosenRule.split("if()");
		String[] rule = ifRule[1].split(" ");
		
		if(chosenRule.contains("is_long_method")) {
			longMethodConvert(rule);
		}
		if(chosenRule.contains("is_feature_envy")) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Our apologies but definition "
					+ "not yet implemented!", "Warning", 
					JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	private void longMethodConvert(String[] rule) {
		String[] condition = rule[0].split("&&");

		String[] aux1 = condition[0].split(">");
		String[] aux2 = condition[1].split(">");

		String[] aux3 = aux2[1].split("()");
		String s = "";
		for(int i=0; i<aux3.length-1;i++) {
			s = s + aux3[i];
		}
		
		longMethod(Double.parseDouble(aux1[1]), Double.parseDouble(s));
	}
	
	
	private void longMethod(Double l, Double c) {
		int dci = 0;
		int dii = 0;
		int adci = 0;
		int adii = 0;
		int lines = getGOF().getGMC().getFile().getNumberOfLines();
		
		defectsCalculated = new String[lines][4];
		defectsCalculated[0][0] = "Method ID";
		defectsCalculated[0][1] = "Used Tool";
		defectsCalculated[0][2] = "Number of hits (DCI + DII)";
		defectsCalculated[0][3] = "Error number (ADCI + ADII)";
		
		waiting();
		
		for(int i=1; i<lines; i++) {
			int auxDCI = 0;
			int auxDII = 0;
			int auxADCI = 0;
			int auxADII = 0;

			defectsCalculated[i][0] = "" + i;
			defectsCalculated[i][1] = "Created Rule";
					
			String loc = getGOF().getGMC().getFile().getCellValue(i, "LOC");
			String cyclo = getGOF().getGMC().getFile().getCellValue(i, "CYCLO");
			
			if(getGOF().getMD().longMethodDefinition(loc, cyclo, l, c)==true && 
					getGOF().getGMC().getFile().getCellValue(i, "is_long_method").
					equals("true")){
				dci++;
				auxDCI++;
			}
			if(getGOF().getMD().longMethodDefinition(loc, cyclo, l, c)==true && 
					getGOF().getGMC().getFile().getCellValue(i, "is_long_method").
					equals("false")){
				dii++;
				auxDII++;
			}
			if(getGOF().getMD().longMethodDefinition(loc, cyclo, l, c)==false && 
					getGOF().getGMC().getFile().getCellValue(i, "is_long_method").
					equals("false")){
				adci++;
				auxADCI++;
			}
			if(getGOF().getMD().longMethodDefinition(loc, cyclo, l, c)==false && 
					getGOF().getGMC().getFile().getCellValue(i, "is_long_method").
					equals("true")){
				adii++;
				auxADII++;
			}
			int aux1 = auxDCI + auxDII;
			int aux2 = auxADCI + auxADII;
			defectsCalculated[i][2] = "" + aux1;
			defectsCalculated[i][3] = "" + aux2;
		}	
		setDCI(dci);
		setDII(dii);
		setADCI(adci);
		setADII(adii);
		openGDDJT();
	}
	
	
	private void openGDDJT() {
		if(isOpenGDDJT==true) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Unable to open new "
					+ "window for checking results of defect detection! "
					+ "Windows is already open!", "Warning", 
					JOptionPane.WARNING_MESSAGE);
		} else {
			isOpenGDDJT=true;
			GDDJT = new GUI_Defect_Detection_JTable(GDD);
		}
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
	
	
	private void waiting() {
		final JPanel warning = new JPanel();
		JOptionPane.showMessageDialog(warning, "Performing defect detection! "
				+ "Please wait until results table is loaded!", "Information",
				 JOptionPane.INFORMATION_MESSAGE);
	}
	
}