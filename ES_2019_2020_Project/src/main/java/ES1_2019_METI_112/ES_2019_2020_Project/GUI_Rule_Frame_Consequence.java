package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI_Rule_Frame_Consequence {

	private JFrame frame;
	private JTextField textSelection;
	private JTextField textMetrics;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Rule_Frame_Consequence window = new GUI_Rule_Frame_Consequence();
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
	public GUI_Rule_Frame_Consequence() {
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
		
		textSelection = new JTextField();
		textSelection.setText("Selection of if consequences");
		textSelection.setBounds(10, 11, 174, 20);
		frame.getContentPane().add(textSelection);
		textSelection.setColumns(10);
		textSelection.setEditable(false);
		
		textMetrics = new JTextField();
		textMetrics.setText("Metrics");
		textMetrics.setBounds(98, 109, 86, 20);
		frame.getContentPane().add(textMetrics);
		textMetrics.setColumns(10);
		textMetrics.setEditable(false);
		
		JButton btnLongMethod = new JButton("long_method");
		btnLongMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLongMethod.setBounds(243, 63, 122, 41);
		frame.getContentPane().add(btnLongMethod);
		
		JButton btnFeatureEnvy = new JButton("feature_envy");
		btnFeatureEnvy.setBounds(243, 134, 122, 41);
		frame.getContentPane().add(btnFeatureEnvy);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBounds(61, 227, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(191, 227, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(317, 227, 89, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}
