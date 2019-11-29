package ES1_2019_METI_112.ES_2019_2020_Project;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Rule_Frame_Viewing {

	private JFrame frame;
	private GUI_Rules_Frame GRF;

	/**
	 * Create the application.
	 */
	public GUI_Rule_Frame_Viewing(GUI_Rules_Frame grf) {
		this.GRF = grf;
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
