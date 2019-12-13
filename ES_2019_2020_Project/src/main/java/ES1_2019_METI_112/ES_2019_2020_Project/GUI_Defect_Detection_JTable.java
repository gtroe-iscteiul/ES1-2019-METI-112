package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class GUI_Defect_Detection_JTable {
	
	private GUI_Defect_Detection GDD;
	private JFrame frame;
	
	public GUI_Defect_Detection_JTable(GUI_Defect_Detection g) {
		this.GDD = g;
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
		frame.setSize(800, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(300, 130);
	}

	private void addFrameContent(){
		openJTable();
	}
	
	private void openJTable() {
		int lines = GDD.getGOF().getGMC().getFile().getNumberOfLines();
		int columns = 4;
				
		String[][] data = new String[lines-1][columns];
		String columnName [] = new String[columns];
		
		for (int i=0; i<columns; i++) {
			columnName[i] = GDD.getElementFromMatrix(0, i);
		}
		
		for (int x=1; x<lines; x++) {
			for (int y=0; y<columns; y++) {
				data[x-1][y] = GDD.getElementFromMatrix(x, y);
			}
		}
		
		JTable table = new JTable(data, columnName);
		
		JScrollPane scrollPane = new JScrollPane(table);
			
		frame.add(scrollPane, BorderLayout.NORTH);	
		
		JPanel panel = new JPanel();
		
		JButton qi = new JButton("Quality Indicators");
		qi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("open quality indicators frame!");
			}
		});
		panel.add(qi);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GDD.setIsOpenGDDJT(false);
				frame.dispose();
			}
		});
		panel.add(button);
		
		frame.add(panel, BorderLayout.SOUTH);
	}
}