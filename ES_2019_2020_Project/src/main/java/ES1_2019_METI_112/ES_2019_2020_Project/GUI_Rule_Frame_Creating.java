package ES1_2019_METI_112.ES_2019_2020_Project;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GUI_Rule_Frame_Creating {

	private JFrame frame;
	private GUI_Rules_Frame GRF;
	private JLabel ifCondition;
	private JPanel panelCenterComponent06;
	private boolean needOperator=false;

	public GUI_Rule_Frame_Creating(GUI_Rules_Frame grf) {
		this.GRF = grf;
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
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(400, 150);
	}
	
	private void addFrameContent() {
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelCenterComponent01 = new JPanel();
		JPanel panelCenterComponent02 = new JPanel();
		JPanel panelCenterComponent03 = new JPanel();
		JPanel panelCenterComponent04 = new JPanel();
		JPanel panelCenterComponent05 = new JPanel();
		panelCenterComponent06 = new JPanel();
		JPanel panelSouth = new JPanel();
		
		buildPanelNorth(panelNorth);
		buildPanelCenter(panelCenter, panelCenterComponent01, panelCenterComponent02, 
				panelCenterComponent03, panelCenterComponent04, panelCenterComponent05,
				panelCenterComponent06);
		buildPanelSouth(panelSouth);
		
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelSouth, BorderLayout.SOUTH);	
	}
	
	private void buildPanelNorth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("Selection of 'if' condition: ");
		panel.add(searchText);
	}
	
	private void buildPanelCenter(JPanel c, JPanel pc1, JPanel pc2, 
			JPanel pc3, JPanel pc4, JPanel pc5, JPanel pc6) {
		
		c.setLayout(new GridLayout(5,2));
		
		JLabel l1 = new JLabel("             ");
		JLabel l2 = new JLabel("             ");
		JLabel l3 = new JLabel("             ");
		JLabel l4 = new JLabel("             ");
		buildPanel01(pc1);
		buildPanel02(pc2);
		buildPanel03(pc3);
		buildPanel04(pc4);
		buildPanel05(pc5);
		buildPanel06(pc6);
		c.add(pc1);
		c.add(pc2);
		c.add(l1);
		c.add(l2);
		c.add(pc3);
		c.add(pc4);
		c.add(l3);
		c.add(l4);
		c.add(pc5);
		c.add(pc6);
	}
	
	private void buildPanel01(JPanel panel) {
		JLabel metrics = new JLabel("Select a metric: ");
		panel.add(metrics);
	}
	
	private void buildPanel02(JPanel panel) {
		panel.setLayout(new GridLayout(2,2));
		
		locButton(panel);
		cycloButton(panel);
		atfdButton(panel);
		laaButton(panel);
	}
	
	private void locButton(JPanel panel) {
		JButton loc = new JButton("LOC");
		loc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needOperator==false) {
					String ifContent = ifCondition.getText();
					panelCenterComponent06.remove(ifCondition);
					String aux = ifContent + "LOC==" + 
							GRF.getGOF().getMD().getLOC();
					ifCondition = new JLabel(aux);
					panelCenterComponent06.add(ifCondition);
					frame.validate();
					needOperator=true;
				} else {
					 final JPanel warning = new JPanel();
					 JOptionPane.showMessageDialog(warning, "Unable to select "
					 		+ "metric! Please add operator first!", 
					 		"Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(loc);
	}
	
	private void cycloButton(JPanel panel) {
		JButton cyclo = new JButton("CYCLO");
		cyclo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				if(needOperator==false) {
					String ifContent = ifCondition.getText();
					panelCenterComponent06.remove(ifCondition);
					String aux = ifContent + "CYCLO==" + 
							GRF.getGOF().getMD().getCYCLO();
					ifCondition = new JLabel(aux);
					panelCenterComponent06.add(ifCondition);
					frame.validate();
					needOperator=true;
				} else {
					 final JPanel warning = new JPanel();
					 JOptionPane.showMessageDialog(warning, "Unable to select "
					 		+ "metric! Please add operator first!", 
					 		"Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(cyclo);
	}
	
	private void atfdButton(JPanel panel) {
		JButton atfd = new JButton("ATFD");
		atfd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needOperator==false) {
					String ifContent = ifCondition.getText();
					panelCenterComponent06.remove(ifCondition);
					String aux = ifContent + "ATFD==" + 
							GRF.getGOF().getMD().getATFD();
					ifCondition = new JLabel(aux);
					panelCenterComponent06.add(ifCondition);
					frame.validate();
					needOperator=true;
				} else {
					 final JPanel warning = new JPanel();
					 JOptionPane.showMessageDialog(warning, "Unable to select "
					 		+ "metric! Please add operator first!", 
					 		"Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(atfd);
	}
	
	private void laaButton(JPanel panel) {
		JButton laa = new JButton("LAA");
		laa.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(needOperator==false) {
					String ifContent = ifCondition.getText();
					panelCenterComponent06.remove(ifCondition);
					String aux = ifContent + "LAA==" + 
							GRF.getGOF().getMD().getLAA();
					ifCondition = new JLabel(aux);
					panelCenterComponent06.add(ifCondition);
					frame.validate();
					needOperator=true;
				} else {
					 final JPanel warning = new JPanel();
					 JOptionPane.showMessageDialog(warning, "Unable to select "
					 		+ "metric! Please add operator first!", 
					 		"Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(laa);
	}
	
	private void buildPanel03(JPanel panel) {
		JLabel operator = new JLabel("Select a operator: ");
		panel.add(operator);
	}
	
	private void buildPanel04(JPanel panel) {
		panel.setLayout(new GridLayout(1,2));
		
		JButton and = new JButton("AND");
		and.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("&&");
			}
		});
		panel.add(and);
		
		JButton or = new JButton("OR");
		or.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("||");
			}
		});
		panel.add(or);		
	}
	
	private void buildPanel05(JPanel panel) {
		JLabel result = new JLabel("Result of the condition: ");
		panel.add(result);
	}
	
	private void buildPanel06(JPanel panel) {
		ifCondition = new JLabel("if(");
		panel.add(ifCondition);
	}
	
	private void buildPanelSouth(JPanel panel) {
		panel.setLayout(new FlowLayout());
		
		JButton reset = new JButton("RESET");
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			
				GRF.setIsOpenGRFC(false);
				frame.dispose();
				GRF.dealWithNewRule();
			}
		});
		panel.add(reset);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Open new window to choose the if consequence!");
				System.out.println("If condition: " + ifCondition.getText());
			}
		});
		panel.add(ok);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GRF.setIsOpenGRFC(false);
				frame.dispose();
			}
		});
		panel.add(back);
	}
}
