package classes_to_use_as_a_base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GUIDefectDetection {

	private JFrame frame;
	private JTable table;
	private JTextField textDetection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIDefectDetection window = new GUIDefectDetection();
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
	public GUIDefectDetection() {
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
		
		table = new JTable();
		table.setBounds(75, 50, 274, 128);
		frame.getContentPane().add(table);
		
		JButton buttonQuality = new JButton("Indicadores de Qualidade");
		buttonQuality.setBounds(10, 212, 220, 38);
		frame.getContentPane().add(buttonQuality);
		
		
		JButton buttonBack = new JButton("BACK");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonBack.setBounds(240, 212, 184, 38);
		frame.getContentPane().add(buttonBack);
		
		textDetection = new JTextField();
		textDetection.setText("Deteção de Defeitos");
		textDetection.setBounds(10, 11, 139, 20);
		textDetection.setEditable(false);
		frame.getContentPane().add(textDetection);
		textDetection.setColumns(10);
	}
}
