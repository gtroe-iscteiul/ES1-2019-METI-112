package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class GUI_JTable {
	
	private GUI_Operative_Frame GOF;
	private JFrame frame;
	
	public GUI_JTable (GUI_Operative_Frame g) {
		this.GOF = g;
		if (GOF.getGMC().getFile().isEmpty()) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "The imported file "
					+ "has no content!", "Warning",
					 JOptionPane.WARNING_MESSAGE);
		} else {
			init();
		}
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
		frame.setSize(1200, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(80, 130);
	}

	private void addFrameContent(){
		openJTable();
	}
	
	private void openJTable() {
		int lines = GOF.getGMC().getFile().getNumberOfLines();
		int columns = GOF.getGMC().getFile().getNumberOfColumns();
				
		String[][] data = new String[lines-1][columns];
		String columnName [] = new String[columns];
		
		for (int i=0; i<columns; i++) {
			columnName[i] = GOF.getGMC().getFile().getCellValue(0, i);
		}
		
		for (int x=1; x<lines; x++) {
			for (int y=0; y<columns; y++) {
				data[x-1][y] = GOF.getGMC().getFile().getCellValue(x, y);
			}
		}
		
		JTable table = new JTable(data, columnName);
		
		JScrollPane scrollPane = new JScrollPane(table);
			
		frame.add(scrollPane);		
	}
	
}