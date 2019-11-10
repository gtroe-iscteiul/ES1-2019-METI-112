package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class GUI {

	private JFrame frame;
	private JTextField txtDci;
	private JTextField txtDii;
	private JTextField txtAdci;
	private JTextField txtAdii;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtFerramentaEscolhida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
					window.frame.setTitle("GUI");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
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
		
		txtDci = new JTextField();
		txtDci.setText("DCI");
		txtDci.setBounds(26, 11, 86, 20);
		frame.getContentPane().add(txtDci);
		txtDci.setColumns(10);
		txtDci.setEditable(false);
		
		txtDii = new JTextField();
		txtDii.setText("DII");
		txtDii.setBounds(26, 42, 86, 20);
		frame.getContentPane().add(txtDii);
		txtDii.setColumns(10);
		txtDii.setEditable(false);
		
		txtAdci = new JTextField();
		txtAdci.setText("ADCI");
		txtAdci.setBounds(26, 73, 86, 20);
		frame.getContentPane().add(txtAdci);
		txtAdci.setColumns(10);
		txtAdci.setEditable(false);
		
		txtAdii = new JTextField();
		txtAdii.setText("ADII");
		txtAdii.setBounds(26, 104, 86, 20);
		frame.getContentPane().add(txtAdii);
		txtAdii.setColumns(10);
		txtAdii.setEditable(false);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setBounds(218, 11, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setBounds(218, 42, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setBounds(218, 73, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setBounds(218, 104, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		txtFerramentaEscolhida = new JTextField();
		txtFerramentaEscolhida.setText("Ferramenta escolhida");
		txtFerramentaEscolhida.setBounds(26, 152, 146, 20);
		frame.getContentPane().add(txtFerramentaEscolhida);
		txtFerramentaEscolhida.setColumns(10);
		txtFerramentaEscolhida.setEditable(false);
		
		JCheckBox chckbxIplasma = new JCheckBox("iPlasma");
		chckbxIplasma.setBounds(26, 179, 97, 23);
		frame.getContentPane().add(chckbxIplasma);
		
		JCheckBox chckbxPmd = new JCheckBox("PMD");
		chckbxPmd.setBounds(26, 205, 97, 23);
		frame.getContentPane().add(chckbxPmd);
		
		JButton btnCriarUmaRegra = new JButton("Definir uma regra");
		btnCriarUmaRegra.setBounds(242, 205, 146, 23);
		btnCriarUmaRegra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RuleWindow ruleWindow = new RuleWindow();
			}
		});
		frame.getContentPane().add(btnCriarUmaRegra);
	}
}
