package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Rule_Visualization {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Rule_Visualization window = new GUI_Rule_Visualization();
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
	public GUI_Rule_Visualization() {
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
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.setBounds(52, 227, 89, 23);
		frame.getContentPane().add(btnSelect);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(181, 227, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDelete.setBounds(304, 227, 89, 23);
		frame.getContentPane().add(btnDelete);
	}

}
