package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class GUI_JTable {
	
	private GUI_Operative_Frame gui;
	private JFrame frame;
	
	public GUI_JTable (GUI_Operative_Frame g) {
		this.gui = g;
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
		int lines = gui.getGMC().getFile().getNumberOfLines();
		int columns = gui.getGMC().getFile().getNumberOfColumns();
				
		String[][] data = new String[lines-1][columns];
		String columnName [] = new String[columns];
		
		for (int i=0; i<columns; i++) {
			columnName[i] = gui.getGMC().getFile().getCellValue(0, i);
		}
		
		for (int x=1; x<lines; x++) {
			for (int y=0; y<columns; y++) {
				data[x-1][y] = gui.getGMC().getFile().getCellValue(x, y);
			}
		}
		
		JTable table = new JTable(data, columnName);
		
		JScrollPane scrollPane = new JScrollPane(table);
			
		frame.add(scrollPane);		
	}
	
}