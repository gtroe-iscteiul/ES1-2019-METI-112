package ES1_2019_METI_112.ES_2019_2020_Project;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GUI_Rule_Frame_Viewing {

	private JFrame frame;
	private GUI_Rules_Frame GRF;
	private AccessToRuleDatabase database;
	
	private JTextField textSelection;
	private JTextArea textMetrics;
	private String[] rules;
	private final int RuleMaxNumber = 10;

	/**
	 * Create the application.
	 */
	public GUI_Rule_Frame_Viewing(GUI_Rules_Frame grf) {
		this.GRF = grf;
		database = new AccessToRuleDatabase("CreatedRuleDatabase");
		rules = new String[RuleMaxNumber];
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textSelection = new JTextField();
		textSelection.setText("Rule");
		textSelection.setBounds(10, 11, 174, 20);
		frame.getContentPane().add(textSelection);
		textSelection.setColumns(10);
		textSelection.setEditable(false);
		
		textMetrics = new JTextArea();
		try {
			rules = database.readFile();
			for (int i = 0; i < rules.length - 1; i++) {
				textMetrics.insert(rules[i], i);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.setBounds(52, 227, 89, 23);
		frame.getContentPane().add(btnSelect);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(299, 220, 89, 23);		
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GRF.setIsOpenGRFV(false);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnBack);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDelete.setBounds(304, 227, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		frame.setVisible(true);
	}

}
