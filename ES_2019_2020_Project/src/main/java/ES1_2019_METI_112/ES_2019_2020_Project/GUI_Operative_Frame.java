package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI_Operative_Frame {
	
	
	/**
	 * Variável referente à classe main
	 */
	private GUI_Main_Class GMC;
	/**
	 * Variável referente à frame desta classe
	 */
	private JFrame frame;
	/**
	 * Variável referente a esta classe
	 */
	private GUI_Operative_Frame GOF;
	/**
	 * Variável referente à classe GUI_JTable
	 */
	private GUI_JTable GJT;
	/**
	 * Variável referente à classe GUI_Thresholds_Frame
	 */
	private GUI_Thresholds_Frame GTF;
	/**
	 * Variável referente à classe GUI_Rules_Frame
	 */
	private GUI_Rules_Frame GRF;
	/**
	 * Variável referente à classe GUI_Defect_Detection
	 */
	private GUI_Defect_Detection GDD;
	/**
	 * 4 booleanos que servem para verificar se a janela pertecente à sua classe, se está aberta
	 */
	private boolean isGuiJTableOpen = false;
	private boolean isGuiThresholdsFrameOpen = false;
	private boolean isGuiRulesFrameOpen = false;
	private boolean isGuiDefectDetectionOpen = false;
	private MethodDefinition MD;
	
	/**
	 * Construtor da ckasse GUI_Operative_Frame
	 * @param g - Variável da classe main
	 */
	public GUI_Operative_Frame (GUI_Main_Class g) {
		this.GMC = g;
		GOF = this;
		MD = new MethodDefinition("-1","-1","-1","-1");
		init();
	}
	
	
	
	/**
	 * Conjunto de getters e setters
	 */
	public GUI_Main_Class getGMC () {
		return GMC;
	}
	
	public GUI_JTable getGJT () {
		return GJT;
	}
	
	public GUI_Thresholds_Frame getGTF () {
		return GTF;
	}
	
	public GUI_Defect_Detection getGDD () {
		return GDD;
	}
	
	public boolean getIsOpenGJT() {
		return isGuiJTableOpen;
	}
	
	public MethodDefinition getMD() {
		return MD;
	}
	
	public GUI_Rules_Frame getGRF () {
		return GRF;
	}
	
	public void setIsOpenGJT(boolean state) {
		this.isGuiJTableOpen = state;
	}
	
	public boolean getIsOpenGTF() {
		return isGuiThresholdsFrameOpen;
	}
	
	public void setIsOpenGTF(boolean state) {
		this.isGuiThresholdsFrameOpen = state;
	}
	
	public void setIsOpenGRF(boolean state) {
		this.isGuiRulesFrameOpen = state;
	}
	
	public boolean getIsOpenGDD() {
		return isGuiDefectDetectionOpen;
	}
	
	public boolean getIsOpenGRF(){
		return isGuiRulesFrameOpen;
	}
	
	public void setIsOpenGDD(boolean state) {
		this.isGuiDefectDetectionOpen = state;
	}
	
	
	/**
	 * Método para a inicialização da janela desta classe
	 */
	private void init () {
		frame = new JFrame("Software Quality Assessment");
		frame.setLayout(new BorderLayout());
		addFrameContent();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		open();
		}
		
	/**
	 * Este  método tem como objetivo definir definições da janela, tais como o seu tamanho 
	 */
	@SuppressWarnings("deprecation")
	private void open() {
		frame.setSize(500, 200);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(400, 190);
	}

	/**
	 * Este método tem como objetivo adicionar componentes à janela
	 */
	private void addFrameContent(){
		JPanel panel = new JPanel();		
		panel.setLayout(new GridLayout(5,1));
		
		buildPanel(panel, "View File", 1);
		buildPanel(panel, "Set Thresholds", 2);
		buildPanel(panel, "Set Rules", 3);
		buildPanel(panel, "Defects Detection", 4);
		buildPanel(panel, "Reselect File", 5);
								
		frame.add(panel, BorderLayout.CENTER);
	}
	
	/**
	 * Método referente à crição dos paineis da GUI_Operative_Frame
	 * @param panel - Painel da janela
	 * @param name - Nome do painel
	 * @param number - Chave dos paineis
	 */
	private void buildPanel(JPanel panel, String name, final int number) {
		JButton button = new JButton(name);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					if (number==1) {
						dealWithErrors_GJT();
					}
					if (number==2) {
						dealWithErrors_GTF();
					}
					if (number==3) {
						dealWithErrors_GSR();
					}
					if (number==4) {
						dealWithErrors_GDD();
					}
					if (number==5) {
						GMC.setIsOpenGOF(false);
						frame.dispose();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(button);
	}
	
	/**
	 * Este método serve para tratar as excepções referentes à abertura da janela GUI_JTable
	 * @throws IOException
	 */
	private void dealWithErrors_GJT() throws IOException {
		if (getGMC().getFile().isEmpty()) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "The imported file "
					+ "has no content!", "Warning",
					 JOptionPane.WARNING_MESSAGE);
		} else {
			if (isGuiJTableOpen==true) {
				final JPanel warning = new JPanel();
				JOptionPane.showMessageDialog(warning, "Unable to open new "
						+ "window for viewing Excel file! Window is already "
						+ "open!", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				this.isGuiJTableOpen = true;
				GJT = new GUI_JTable(GOF);
			}
		}
	}
	
	/**
	 * Este método serve para tratar as excepções referentes à abertura da janela GUI_Thresholds_Frame
	 * @throws IOException
	 */
	private void dealWithErrors_GTF() throws IOException {
		if (isGuiThresholdsFrameOpen==true) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Unable to open new window "
					+ "for thresholds settings! Window is already open!", 
					"Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			this.isGuiThresholdsFrameOpen = true;
			GTF = new GUI_Thresholds_Frame(GOF);
		}
	}
	
	/**
	 * Este método serve para tratar as excepções referentes à abertura da janela GUI_Rules_Frame
	 * @throws IOException
	 */
	private void dealWithErrors_GSR() throws IOException {
		if (isGuiRulesFrameOpen==true) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Unable to open new window "
					+ "to set rules! Window is already open!", 
					"Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			this.isGuiRulesFrameOpen = true;
			GRF = new GUI_Rules_Frame(GOF);
		}
	}
	
	/**
	 * Este método serve para tratar as excepções referentes à abertura da janela GUIDefectDetection
	 * @throws IOException
	 */
	private void dealWithErrors_GDD() throws IOException {
		if (getGMC().getFile().isEmpty()) {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Can't take action because"
					+ " the imported file has no content!", "Warning",
					 JOptionPane.WARNING_MESSAGE);
		} else {
			if (isGuiDefectDetectionOpen==true) {
				final JPanel warning = new JPanel();
				JOptionPane.showMessageDialog(warning, "Unable to open new window "
						+ "to perform defect detection! Window is already open!", 
						"Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				this.isGuiDefectDetectionOpen = true;
				GDD = new GUI_Defect_Detection(GOF);
			}
		}	
	}
	
}