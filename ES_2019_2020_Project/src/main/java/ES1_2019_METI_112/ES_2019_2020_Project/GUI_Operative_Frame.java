package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI_Operative_Frame {
	
	private GUI_Main_Class gui;
	private JFrame frame;
	private GUI_Operative_Frame GOF;
	private GUI_JTable GJT;
	
	public GUI_Operative_Frame (GUI_Main_Class g) {
		this.gui = g;
		GOF = this;
		init();
	}
	
	public GUI_Main_Class getGMC () {
		return gui;
	}
	
	private void init () {
		frame = new JFrame("Software Quality Assessment");
		frame.setLayout(new BorderLayout());
		addFrameContent();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		open();
		}
		
	private void open(){
		frame.setSize(500, 200);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(400, 190);
	}

	private void addFrameContent(){
		JPanel panel = new JPanel();		
		panel.setLayout(new GridLayout(5,1));
		
		buildPanel(panel, "View File", "abrir jTable", 1);
		buildPanel(panel, "Set Thresholds", "abrir janela das thresolds", 2);
		buildPanel(panel, "Set Rules", "abrir janela das regras", 3);
		buildPanel(panel, "Defects Detection", "abrir janela dos defeitos detectados", 4);
		buildPanel(panel, "Reselect File", "voltar à janela 'GUI_Main_Class'", 5);
								
		frame.add(panel, BorderLayout.CENTER);
	}
	
	private void buildPanel(JPanel panel, String name, final String message, 
			final int number) {
		JButton button = new JButton(name);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (number==1) {
					GJT = new GUI_JTable(GOF);
				}
				if (number==2) {
					System.out.println("Button 2: " + message);
				}
				if (number==3) {
					System.out.println("Button 3: " + message);
				}
				if (number==4) {
					System.out.println("Button 4: " + message);
				}
				if (number==5) {
					frame.dispose();
				}
			}
		});
		panel.add(button);
	}
		
}