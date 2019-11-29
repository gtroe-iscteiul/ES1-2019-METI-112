package ES1_2019_METI_112.ES_2019_2020_Project;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GUI_Rules_Frame {

	private JFrame frame;
	private GUI_Operative_Frame GOF;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public GUI_Rules_Frame(GUI_Operative_Frame g) {
		this.GOF = g;
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
		
		JButton buttonVisualization = new JButton("Visualizar regras");
		buttonVisualization.setBounds(158, 50, 150, 23);
		frame.getContentPane().add(buttonVisualization);
		buttonVisualization.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Irá abrir classe 'GUI_Rule_Visualization.java,"
						+ "actualmente no package 'Classes_To_Use'");
			}
		});
		
		JButton buttonNewRule = new JButton("Definir nova regra");
		buttonNewRule.setBounds(158, 102, 150, 23);
		frame.getContentPane().add(buttonNewRule);
		buttonNewRule.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Irá abrir classe 'GUI_Rule_Definition.java,"
						+ "actualmente no package 'Classes_To_Use'\");'");
			}
		});
		
		JButton buttonBack = new JButton("Back");
		buttonBack.setBounds(189, 198, 89, 23);
		frame.getContentPane().add(buttonBack);
		frame.setVisible(true);
		buttonBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GOF.setIsOpenGRF(false);
				frame.dispose();
			}
		});
	}
}
