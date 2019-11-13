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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI_Thresholds_Frame {
	
	private GUI_Operative_Frame GOF;
	private JFrame frame;
	private JTextField LOC;
	private JTextField CYCLO;
	private JTextField ATFD;
	private JTextField LAA;
	
	public GUI_Thresholds_Frame (GUI_Operative_Frame g) {
		this.GOF = g;
		
		LOC = new JTextField(null);
		CYCLO = new JTextField(null);
		ATFD = new JTextField(null);
		LAA = new JTextField(null);
		
		init();
	}
	
	private void init () {
		frame = new JFrame("Software Quality Assessment");
		frame.setLayout(new BorderLayout());
		addFrameContent();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		
		// panel_1 definition
		panel_1.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("Definition of Thresholds: ");
		panel_1.add(searchText);
		
		// panel_2 definition
		panel_2.setLayout(new GridLayout(4,2));
		panel2Build(panel_2, "  LOC");
		panel2Build(panel_2, "CYCLO");
		panel2Build(panel_2, " ATFD");
		panel2Build(panel_2, "  LAA");
		
		// panel_3 definition
		panel3Build(panel_3, panel_2);
		
		frame.add(panel_1, BorderLayout.NORTH);
		frame.add(panel_2, BorderLayout.CENTER);
		frame.add(panel_3, BorderLayout.SOUTH);
	}
	
	private void panel2Build(JPanel panel_2, String name) {	
		JLabel label = new JLabel("                                 " + name);
		panel_2.add(label);		
		final JTextField text = new JTextField(null);
		panel_2.add(text);
		
		updateTextFields(name, text);
	}
	
	private void updateTextFields(String name, JTextField text) {
		if (name.contains("LOC") && !text.getText().equals(null)) {
			LOC = text;
		}
		if (name.contains("CYCLO") && !text.getText().equals(null)) {
			CYCLO = text;
		}
		if (name.contains("ATFD") && !text.getText().equals(null)) {
			ATFD = text;
		}
		if (name.contains("LAA") && !text.getText().equals(null)) {
			LAA = text;
		}
	}
	
	private void panel3Build(JPanel panel_3, final JPanel panel_2) {
		JButton save = new JButton("SAVE");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				dealWithButtons();
			}
		});
		panel_3.add(save);
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GOF.setIsOpenGTF(false);
				frame.dispose();
			}
		});
		panel_3.add(back);
	}
	
	private void dealWithButtons() {
		if (LOC.getText().isBlank() || CYCLO.getText().isBlank()
				|| ATFD.getText().isBlank() || LAA.getText().isBlank()) {
			failed();
		} else {
			succeeded();
		}
	}
	
	private void failed() {
		 final JPanel warning = new JPanel();
		 JOptionPane.showMessageDialog(warning, "There are empty "
		 		+ "thresholds fields! Please fill them first!"
		 		, "Warning",
				 JOptionPane.WARNING_MESSAGE);
	}
	
	private void succeeded() {
		GOF.setLOC(LOC.getText());
		GOF.setCYCLO(CYCLO.getText());
		GOF.setATFD(ATFD.getText());
		GOF.setLAA(LAA.getText());
		
		GOF.setIsOpenGTF(false);
		frame.dispose();
		final JPanel warning = new JPanel();
		JOptionPane.showMessageDialog(warning, "Successfully saved!"
		 		, "Information",
				 JOptionPane.INFORMATION_MESSAGE);
	}
	
}