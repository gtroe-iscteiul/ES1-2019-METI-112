package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI_Rule_Frame_Creating_Final_Result {
	
	private JFrame frame;
	private GUI_Rule_Frame_Creating_Consequence GRFC_consequence;
	private GUI_Rule_Frame_Creating_Final_Result GRFCFR;
	private JTextField textSelection;
	private JTextArea textMetrics;
	private ReadFile rf = new ReadFile("Rules Created");
	private String[] rules = new String[10];
	
	public GUI_Rule_Frame_Creating_Final_Result(GUI_Rule_Frame_Creating_Consequence g) {
		this.GRFC_consequence = g;
		GRFCFR = this;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textSelection = new JTextField();
		textSelection.setText("Rule");
		textSelection.setBounds(10, 11, 174, 20);
		frame.getContentPane().add(textSelection);
		textSelection.setColumns(10);
		textSelection.setEditable(false);
		
		textMetrics = new JTextArea();
		try {
			rules = rf.readFile();
			for (int i = 0; i < rules.length - 1; i++) {
				textMetrics.insert(rules[i], i);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
//		textMetrics.setText(rf.readFile());
//		textMetrics.setText("(show rule)");
		textMetrics.setBounds(98, 109, 86, 20);
		frame.getContentPane().add(textMetrics);
		textMetrics.setColumns(10);
		textMetrics.setEditable(false);
		
		JButton btnReset = new JButton("CONFIRM");
		btnReset.setBounds(61, 227, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnOk = new JButton("CANCEL");
		btnOk.setBounds(191, 227, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(317, 227, 89, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				GRFC_consequence.setIsOpenGRFCFR(false);
				frame.dispose();
			}
		});
		
		frame.setVisible(true);
	}
	
	public void closeRuleResultFrame() {
		GRFC_consequence.setIsOpenGRFCFR(false);
		frame.dispose();
	}
	
	
}