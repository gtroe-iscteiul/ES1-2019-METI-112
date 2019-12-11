package ES1_2019_METI_112.ES_2019_2020_Project;

import javax.swing.JFrame;

public class GUI_Rule_Frame_Creating_Feature_Envy {
	
	private JFrame frame;
	private GUI_Rule_Frame_Choosing_Consequence_Type GRFCCT;
	
	
	public GUI_Rule_Frame_Creating_Feature_Envy(
			GUI_Rule_Frame_Choosing_Consequence_Type g) {
		
	}
	
	
	public void closeFrame() {
		GRFCCT.setIsOpenGRFCFE(false);
		frame.dispose();
	}
	
}