package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI_Main_Class {
	
	private FileHandling file;
	private String fileName;
	private JFrame frame;
	private GUI_Operative_Frame GOF;
	private GUI_Main_Class GMC;
	
	public GUI_Main_Class () {
		GMC = this;
		init();
	}
	
	private void init () {
		frame = new JFrame("Software Quality Assessment");
		frame.setLayout(new BorderLayout());
		addFrameContent();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		open();
	}
	
	public FileHandling getFile () {
		return file;
	}
	
	public GUI_Operative_Frame getGOF() {
		return GOF;
	}
	
	@SuppressWarnings("deprecation")
	private void open(){
		frame.setSize(400, 135);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(450, 200);
	}
	
	private void addFrameContent(){
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		
		// panel_1 definition
		panel_1.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("File name to import: ");
		panel_1.add(searchText);
		
		// panel_2 definition
		final JTextField text = new JTextField("               "
				+ "                                            ");
		panel_2.add(text);
		
		// panel_3 definition
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					fileName = text.getText();
					file = new FileHandling();
					importFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_3.add(ok);
				
		frame.add(panel_1, BorderLayout.NORTH);
		frame.add(panel_2, BorderLayout.CENTER);
		frame.add(panel_3, BorderLayout.SOUTH);
	}
	
	private void importFile () throws IOException {
		File f = new File(fileName);
		 if (file.existsFile(f)) {
			file.init(fileName);
			GOF = new GUI_Operative_Frame(GMC);
		 } else {
			 final JPanel warning = new JPanel();
			 JOptionPane.showMessageDialog(warning, "The file name entered does " + 
			 		"not exist in the directory!", "Warning",
					 JOptionPane.WARNING_MESSAGE);
		 }		
	}
		
	public static void main(String[] args) {
		GUI_Main_Class GUI = new GUI_Main_Class();
		GUI.init();
	}
}