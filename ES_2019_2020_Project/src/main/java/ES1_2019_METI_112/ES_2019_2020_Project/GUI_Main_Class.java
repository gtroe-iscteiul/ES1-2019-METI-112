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
			// "fileTest()" apenas para testar a interface, depois é para apagar!
//			fileTest();
			GOF = new GUI_Operative_Frame(GMC);
		 } else {
			 final JPanel warning = new JPanel();
			 JOptionPane.showMessageDialog(warning, "The file name entered does " + 
			 		"not exist in the directory!", "Warning",
					 JOptionPane.WARNING_MESSAGE);
		 }		
	}
	
/*	private void fileTest() {
		System.out.println("selecção do ficheiro: " + fileName);
		System.out.println("a partir daqui, entra então o mecanismo de import...");
		System.out.println("");
		System.out.println("Number of lines: " + file.getNumberOfLines());
		System.out.println("Number of columns: " + file.getNumberOfColumns());
		System.out.println("Cell 0 on 0: " + file.getCellValue(0, "MethodID"));
		System.out.println("Cell 1 on 1: " + file.getCellValue(1, "package"));
		System.out.println("Cell 2 on 2: " + file.getCellValue(2, "class"));
		System.out.println("Cell 3 on 3: " + file.getCellValue(3, "method"));
		System.out.println("Cell 4 on 4: " + file.getCellValue(4, "LOC"));
		System.out.println("Cell 5 on 5: " + file.getCellValue(5, "CYCLO"));
		System.out.println("Cell 6 on 6: " + file.getCellValue(6, "ATFD"));
		System.out.println("Cell 7 on 7: " + file.getCellValue(7, "LAA"));
		System.out.println("Cell 8 on 8: " + file.getCellValue(8, "is_long_method"));
		System.out.println("Cell 9 on 9: " + file.getCellValue(9, "iPlasma"));
		System.out.println("Cell 10 on 10: " + file.getCellValue(10, "PMD"));
		System.out.println("Cell 11 on 11: " + file.getCellValue(11, "is_feature_envy"));
		System.out.println("Cell 0 on 11: " + file.getCellValue(0, "is_feature_envy"));
		
	}
*/	
	public static void main(String[] args) {
		GUI_Main_Class GUI = new GUI_Main_Class();
	}
}