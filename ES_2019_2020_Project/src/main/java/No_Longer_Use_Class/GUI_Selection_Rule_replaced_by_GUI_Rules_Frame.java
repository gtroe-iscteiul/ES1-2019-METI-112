package No_Longer_Use_Class;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Creating_Condition;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Selection_Rule_replaced_by_GUI_Rules_Frame{

	private JFrame frame;
	private GUI_Operative_Frame GOF;
	@SuppressWarnings("unused")
	private GUI_Rule_Frame_Creating_Condition GRD;


	@SuppressWarnings("unused")
	private void initialize() {
		JButton buttonNewRule = new JButton("Definir nova regra");
		buttonNewRule.setBounds(158, 102, 150, 23);
		frame.getContentPane().add(buttonNewRule);
		buttonNewRule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				if(GOF.getisTresholdSet()) {
//					GRD = new GUI_Rule_Frame_Creating();
//				} else {
					final JPanel warning = new JPanel();
					JOptionPane.showMessageDialog(warning, "Unable to open new window "
							+ "for rules definition! Must define tresholds first!", 
							"Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
//		}
		);

		JButton buttonBack = new JButton("Back");
		buttonBack.setBounds(189, 198, 89, 23);
		frame.getContentPane().add(buttonBack);
		frame.setVisible(true);
		buttonBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GOF.setIsOpenGTF(false);
//				GOF.setIsGuiSelectionRulesFrameOpen(false);
				frame.dispose();
			}
		});
	}
}