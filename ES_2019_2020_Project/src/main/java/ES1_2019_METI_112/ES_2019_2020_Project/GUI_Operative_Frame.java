package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI_Operative_Frame {
	
	private GUI_Main_Class GMC;
	private JFrame frame;
	private GUI_Operative_Frame GOF;
	private GUI_JTable GJT;
	private String LOC = null;
	private String CYCLO = null;
	private String ATFD = null;
	private String LAA = null;
	
	public GUI_Operative_Frame (GUI_Main_Class g) {
		this.GMC = g;
		GOF = this;
		init();
	}
	
	public GUI_Main_Class getGMC () {
		return GMC;
	}
	
	public GUI_JTable getGJT () {
		return GJT;
	}
	
	public String getLOC () {
		return LOC;
	}
	
	public String getCYCLO () {
		return CYCLO;
	}
	
	public String getATFD () {
		return ATFD;
	}
	
	public String getLAA () {
		return LAA;
	}
	
	public void setLOC (String s) {
		LOC = s;
	}
	
	public void setCYCLO (String s) {
		CYCLO = s;
	}
	
	public void setATFD (String s) {
		ATFD = s;
	}
	
	public void setLAA (String s) {
		LAA = s;
	}
	
	private void init () {
		frame = new JFrame("Software Quality Assessment");
		frame.setLayout(new BorderLayout());
		addFrameContent();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

	private void addFrameContent(){
		JPanel panel = new JPanel();		
		panel.setLayout(new GridLayout(5,1));
		
		buildPanel(panel, "View File", 1);
		buildPanel(panel, "Set Thresholds", 2);
		buildPanel(panel, "Set Rules", 3);
		buildPanel(panel, "Defects Detection", 4);
		buildPanel(panel, "Reselect File", 5);
								
		frame.add(panel, BorderLayout.CENTER);
	}
	
	private void buildPanel(JPanel panel, String name, final int number) {
		JButton button = new JButton(name);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (number==1) {
					GJT = new GUI_JTable(GOF);
				}
				if (number==2) {
					System.out.println("Button 2: " + "abrir janela das thresolds");
				}
				if (number==3) {
					System.out.println("Button 3: " + "abrir janela das regras");
				}
				if (number==4) {
					System.out.println("Button 4: " + 
							"abrir janela dos defeitos detectados");
				}
				if (number==5) {
					frame.dispose();
				}
			}
		});
		panel.add(button);
	}
		
}