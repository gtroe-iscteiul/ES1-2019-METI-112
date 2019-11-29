package No_Longer_Use_Class;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Treshold_GUI {

	private JFrame frame;
	private JTextField txtDefinirThresholds;
	private JTextField txtLoc;
	private JTextField textField;
	private JTextField txtCyclo;
	private JTextField textField_1;
	private JTextField txtAtfd;
	private JTextField textField_2;
	private JTextField txtLaa;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					Treshold_GUI window = new Treshold_GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Treshold_GUI() {
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
		frame.setVisible(true);
		
		txtDefinirThresholds = new JTextField();
		txtDefinirThresholds.setText("Definir Thresholds");
		txtDefinirThresholds.setBounds(164, 11, 112, 20);
		txtDefinirThresholds.setEditable(false);
		frame.getContentPane().add(txtDefinirThresholds);
		txtDefinirThresholds.setColumns(10);
		
		txtLoc = new JTextField();
		txtLoc.setText("LOC");
		txtLoc.setBounds(125, 60, 43, 20);
		txtLoc.setEditable(false);
		frame.getContentPane().add(txtLoc);
		txtLoc.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(190, 60, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtCyclo = new JTextField();
		txtCyclo.setText("CYCLO");
		txtCyclo.setEditable(false);
		txtCyclo.setBounds(125, 91, 51, 20);
		frame.getContentPane().add(txtCyclo);
		txtCyclo.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 91, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		txtAtfd = new JTextField();
		txtAtfd.setText("ATFD");
		txtAtfd.setEditable(false);
		txtAtfd.setBounds(125, 122, 51, 20);
		frame.getContentPane().add(txtAtfd);
		txtAtfd.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(190, 122, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		txtLaa = new JTextField();
		txtLaa.setText("LAA");
		txtLaa.setBounds(125, 153, 51, 20);
		txtLaa.setEditable(false);
		frame.getContentPane().add(txtLaa);
		txtLaa.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(190, 153, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(79, 197, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(190, 197, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(299, 197, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
