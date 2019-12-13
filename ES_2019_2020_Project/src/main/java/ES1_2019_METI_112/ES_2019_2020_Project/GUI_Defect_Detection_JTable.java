package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;


public class GUI_Defect_Detection_JTable {
	
	private GUI_Defect_Detection GDD;
	private GUI_Defect_Detection_JTable GDDJT;
	private JFrame frame;
	private GUI_Defect_Detection_Quality_Indicators GDDQI;
	private boolean isOpenGDDQI;
	private String tool;
	
	
	/**
	 * Construtor da classe GUI_Defect_Detection_JTable
	 * @param g - GUI_Defect_Detection
	 */
	public GUI_Defect_Detection_JTable(GUI_Defect_Detection g) {
		GDDJT = this;
		this.GDD = g;
		this.isOpenGDDQI = false;
		init();
	}
	
	
	/**
	 * Getters da classe GUI_Defect_Detection_JTable
	 * @return das seguintes variáveis: GDD e isOpenGDDQI que indica o estado da GUI_Defect_Detection_Quality_Indicators
	 */
	public GUI_Defect_Detection getGDD() {
		return GDD;
	}
	
	
	public boolean getIsOpenGDDQI() {
		return isOpenGDDQI;
	}
	
	
	/**
	 * Setter da variável state que permite definir o estado da GUI_Defect_Detection_Quality_Indicators
	 * @param state - boolean
	 */
	public void setIsOpenGDDQI(boolean state) {
		isOpenGDDQI = state;
	}
	
	
	/**
	 * Getter da classe GUI_Defect_Detection_JTable
	 * @return da variável tool
	 */
	public String getTool() {
		return tool;
	}
	
	
	/**
	 * Setter da variável t
	 * @param t - String
	 */
	public void setTool(String t) {
		this.tool = t;
	}
	
	
	/**
	 * Método que inicializa a JFrame
	 */
	private void init () {
		frame = new JFrame("Software Quality Assessment");
		frame.setLayout(new BorderLayout());
		addFrameContent();
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.pack();
		open();
	}
	
		
	/**
	 * Este  método tem como objetivo definir características da janela, tais como o seu tamanho 
	 */
	@SuppressWarnings("deprecation")
	private void open(){
		frame.setSize(800, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(300, 130);
	}
	

	/**
	 * Este método tem como objetivo adicionar componentes à janela
	 */
	private void addFrameContent(){
		openJTable();
	}
	
	
	/**
	 * Este método tem como objetivo abrir uma JTable, bem como a criação dos botões: "Quality Indicators" e "BACK"
	 */
	private void openJTable() {
		int lines = GDD.getGOF().getGMC().getFile().getNumberOfLines();
		int columns = 4;
				
		String[][] data = new String[lines-1][columns];
		String columnName [] = new String[columns];
		
		for (int i=0; i<columns; i++) {
			columnName[i] = GDD.getElementFromDefectDetectionMatrix(0, i);
		}
		
		for (int x=1; x<lines; x++) {
			for (int y=0; y<columns; y++) {
				data[x-1][y] = GDD.getElementFromDefectDetectionMatrix(x, y);
			}
		}
		
		JTable table = new JTable(data, columnName);
		
		JScrollPane scrollPane = new JScrollPane(table);
			
		frame.add(scrollPane, BorderLayout.NORTH);	
		
		JPanel panel = new JPanel();
		
		JButton qi = new JButton("Quality Indicators");
		qi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				openGDDQI();
			}
		});
		panel.add(qi);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				closeFrame();
			}
		});
		panel.add(button);
		
		frame.add(panel, BorderLayout.SOUTH);
	}
	
	
	/**
	 * Este método é responsável por abrir a janela GUI_Defect_Detection_Quality_Indicators
	 */
	private void openGDDQI() {		
		if(isOpenGDDQI==true) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Unable to open new "
					+ "window for checking quality inicators!"
					+ " Windows is already open!", "Warning", 
					JOptionPane.WARNING_MESSAGE);
		} else {
			isOpenGDDQI = true;		
			GDDQI = new GUI_Defect_Detection_Quality_Indicators(GDDJT);
		}
	}
	
	
	/**
	 * Método responsável por fechar a janela GUI_Defect_Detection_Quality_Indicators 
	 */
	public void closeFrame() {
		if(isOpenGDDQI==true) {
			GDDQI.closeFrame();
		}
		GDD.setIsOpenGDDJT(false);
		frame.dispose();
	}
}