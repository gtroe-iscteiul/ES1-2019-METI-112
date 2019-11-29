package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI_Operative_Frame {
	
	private GUI_Main_Class GMC;
	private JFrame frame;
	private GUI_Operative_Frame GOF;
	private GUI_JTable GJT;
	private GUI_Thresholds_Frame GTF;
	private GUI_Selection_Rule GSR;
	private String LOC = null;
	private String CYCLO = null;
	private String ATFD = null;
	private String LAA = null;
	private boolean isGuiJTableOpen = false;
	private boolean isGuiThresholdsFrameOpen = false;
	private boolean isGuiSelectionRulesFrameOpen = false;
	
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
	
	public GUI_Thresholds_Frame getGTF () {
		return GTF;
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
	
	public boolean getIsOpenGJT() {
		return isGuiJTableOpen;
	}
	
	public void setIsOpenGJT(boolean state) {
		this.isGuiJTableOpen = state;
	}
	
	public boolean getIsOpenGTF() {
		return isGuiThresholdsFrameOpen;
	}
	
	public void setIsOpenGTF(boolean state) {
		this.isGuiThresholdsFrameOpen = state;
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
				try {
					if (number==1) {
						dealWithErrors_GJT();
					}
					if (number==2) {
						dealWithErrors_GTF();
					}
					if (number==3) {
						dealWithErrors_GSR();
					}
					if (number==4) {
						System.out.println("Button 4: " + 
								"abrir janela dos defeitos detectados");
					}
					if (number==5) {
						GMC.setIsOpenGOF(false);
						frame.dispose();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(button);
	}
	
	private void dealWithErrors_GJT() throws IOException {
		if (getGMC().getFile().isEmpty()) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "The imported file "
					+ "has no content!", "Warning",
					 JOptionPane.WARNING_MESSAGE);
		} else {
			if (isGuiJTableOpen==true) {
				final JPanel warning = new JPanel();
				JOptionPane.showMessageDialog(warning, "Unable to open new "
						+ "window for viewing Excel file! Window is already "
						+ "open!", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				this.isGuiJTableOpen = true;
				GJT = new GUI_JTable(GOF);
			}
		}
	}
	
	private void dealWithErrors_GTF() throws IOException {
		if (isGuiThresholdsFrameOpen==true) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Unable to open new window "
					+ "for thresholds settings! Window is already open!", 
					"Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			this.isGuiThresholdsFrameOpen = true;
			GTF = new GUI_Thresholds_Frame(GOF);
		}
	}
	
	private void dealWithErrors_GSR() throws IOException {
		if (isGuiSelectionRulesFrameOpen==true) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Unable to open new window "
					+ "for rules selection! Window is already open!", 
					"Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			this.isGuiSelectionRulesFrameOpen = true;
			GSR = new GUI_Selection_Rule(GOF);
		}
	}
	
		
}