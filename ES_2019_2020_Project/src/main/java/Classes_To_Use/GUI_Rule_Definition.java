package Classes_To_Use;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI_Rule_Definition {

	private JFrame frame;
	private JTextField txtSelectionOfif;
	private JTextField txtTresholds;
	private JTextField txtOperators;
	private JTextField txtResult;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Rule_Definition window = new GUI_Rule_Definition();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Rule_Definition() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtSelectionOfif = new JTextField();
		txtSelectionOfif.setText("Selection of \"if\" condition");
		txtSelectionOfif.setEditable(false);
		txtSelectionOfif.setBounds(10, 11, 132, 20);
		frame.getContentPane().add(txtSelectionOfif);
		txtSelectionOfif.setColumns(10);
		
		txtTresholds = new JTextField();
		txtTresholds.setText("Tresholds");
		txtTresholds.setEditable(false);
		txtTresholds.setBounds(86, 59, 56, 20);
		frame.getContentPane().add(txtTresholds);
		txtTresholds.setColumns(10);
		
		JButton btnLoc = new JButton("LOC");
		btnLoc.setBounds(212, 58, 53, 23);
		frame.getContentPane().add(btnLoc);
		
		JButton btnCyclo = new JButton("CYCLO");
		btnCyclo.setBounds(275, 58, 65, 23);
		frame.getContentPane().add(btnCyclo);
		
		JButton btnAtfd = new JButton("ATFD");
		btnAtfd.setBounds(212, 92, 65, 23);
		frame.getContentPane().add(btnAtfd);
		
		JButton btnLaa = new JButton("LAA");
		btnLaa.setBounds(285, 92, 55, 23);
		frame.getContentPane().add(btnLaa);
		
		txtOperators = new JTextField();
		txtOperators.setText("Operators");
		txtOperators.setEditable(false);
		txtOperators.setBounds(86, 158, 86, 20);
		frame.getContentPane().add(txtOperators);
		txtOperators.setColumns(10);
		
		JButton btnAnd = new JButton("&&");
		btnAnd.setBounds(212, 157, 53, 23);
		frame.getContentPane().add(btnAnd);
		
		JButton button = new JButton("||");
		button.setBounds(275, 157, 53, 23);
		frame.getContentPane().add(button);
		
		txtResult = new JTextField();
		txtResult.setText("Result");
		txtResult.setEditable(false);
		txtResult.setBounds(86, 189, 56, 20);
		frame.getContentPane().add(txtResult);
		txtResult.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(166, 189, 174, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(176, 220, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(299, 220, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBounds(53, 220, 89, 23);
		frame.getContentPane().add(btnReset);
		
		frame.setVisible(true);
	}
}
