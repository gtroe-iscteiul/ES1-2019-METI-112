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
	private int DCI;
	private int DII;
	private int ADCI;
	private int ADII;
	private int numberOfThreads;
	
	
	public GUI_Defect_Detection (GUI_Operative_Frame g) {
		this.GOF = g;
		initIndicators();
		this.numberOfThreads = 0;
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
				defectCalculation("iPlasma", "is_long_method");
			}
		});
		panel.add(iplasma);
		
		JButton pmd = new JButton("PMD");
		pmd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
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
		System.out.println("DCI: " + DCI);
		System.out.println("DII: " + DII);
		System.out.println("ADCI: " + ADCI);
		System.out.println("ADII: " + ADII);
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