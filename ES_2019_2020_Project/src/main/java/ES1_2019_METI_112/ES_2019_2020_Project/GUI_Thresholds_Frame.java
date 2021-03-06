package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI_Thresholds_Frame {
	
	private GUI_Operative_Frame GOF;
	private JFrame frame;
	
	//4 variáveis correspondentes às métricas
	private JTextField LOC;
	private JTextField CYCLO;
	private JTextField ATFD;
	private JTextField LAA;
	
	/**
	 * Construtor da classe 
	 * @param g - Recebe como parâmetro a GUI_Operative_Frame
	 */
	public GUI_Thresholds_Frame (GUI_Operative_Frame g) {
		this.GOF = g;
		
		LOC = new JTextField(null);
		CYCLO = new JTextField(null);
		ATFD = new JTextField(null);
		LAA = new JTextField(null);
		
		init();
	}
	
	/**
	 * Este método tem como objetivo inicializar a janela
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
	 * Este  método tem como objetivo definir definições da janela, tais como o seu tamanho 
	 */
	@SuppressWarnings("deprecation")
	private void open(){
		frame.setSize(500, 200);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(400, 190);
	}

	/**
	 * Este método tem como objetivo adicionar conteúdo à janela
	 */
	private void addFrameContent(){
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		
		// panel_1 definition
		panel_1.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("Definition of Thresholds: ");
		panel_1.add(searchText);
		
		// panel_2 definition
		panel_2.setLayout(new GridLayout(4,2));
		panel2Build(panel_2, "  LOC");
		panel2Build(panel_2, "CYCLO");
		panel2Build(panel_2, " ATFD");
		panel2Build(panel_2, "  LAA");
		
		// panel_3 definition
		panel3Build(panel_3, panel_2);
		
		frame.add(panel_1, BorderLayout.NORTH);
		frame.add(panel_2, BorderLayout.CENTER);
		frame.add(panel_3, BorderLayout.SOUTH);
	}
	
	/** Este método serve para adicionar conteúdo ao painel 2 da janela
	 * @param panel_2 - Painel
	 * @param name - Nome do label
	 */
	private void panel2Build(JPanel panel_2, String name) {	
		JLabel label = new JLabel("                                 " + name);
		panel_2.add(label);		
		final JTextField text = new JTextField(null);
		panel_2.add(text);
		
		updateTextFields(name, text);
	}
	
	/**
	 * Este método tem como objetivo verificar se o utilizador não deixou os campos a null
	 * @param name - nome do label
	 * @param text - Número escrito pelo utilizador
	 */
	private void updateTextFields(String name, JTextField text) {
		if (name.contains("LOC") && !text.getText().equals(null)) {
			LOC = text;
		}
		if (name.contains("CYCLO") && !text.getText().equals(null)) {
			CYCLO = text;
		}
		if (name.contains("ATFD") && !text.getText().equals(null)) {
			ATFD = text;
		}
		if (name.contains("LAA") && !text.getText().equals(null)) {
			LAA = text;
		}
	}
	
	/**
	 * Este método tem como objetivo adicionar conteúdo ao painel 3 da janela
	 * @param panel_3 - Painel 3
	 * @param panel_2 - Painel 2
	 */
	private void panel3Build(JPanel panel_3, final JPanel panel_2) {
		JButton save = new JButton("SAVE");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				dealWithButtons();
			}
		});
		panel_3.add(save);
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GOF.setIsOpenGTF(false);
				frame.dispose();
			}
		});
		panel_3.add(back);
	}
	
	/**
	 * Este método tem como objetivo verificar se os campos escritos pelo utilizador, se estão a null
	 */
	private void dealWithButtons() {
		if (LOC.getText().isBlank() || CYCLO.getText().isBlank()
				|| ATFD.getText().isBlank() || LAA.getText().isBlank()) {
		// Usar este 'if' em caso de erro no 'isBlank', mas no fim, voltar a colocar
//		if (LOC.getText().isEmpty() || CYCLO.getText().isEmpty()
//				|| ATFD.getText().isEmpty() || LAA.getText().isEmpty()) {
			failed();
		} else {
			testingType();
		}
	}
	
	/**
	 * Método com o objetivo de lançar um erro se os campos estiverem a null
	 */
	private void failed() {
		 final JPanel warning = new JPanel();
		 JOptionPane.showMessageDialog(warning, "There are blank "
		 		+ "thresholds fields! Please fill them first!"
		 		, "Warning",
				 JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Método com o objetivo de guardar os valores inseridos pelo utilizador
	 */
	private void succeeded() {
		GOF.getMD().setLOC(LOC.getText());
		GOF.getMD().setCYCLO(CYCLO.getText());
		GOF.getMD().setATFD(ATFD.getText());
		GOF.getMD().setLAA(LAA.getText());
		
		final JPanel warning = new JPanel();
		JOptionPane.showMessageDialog(warning, "Successfully saved!"
		 		, "Information",
				 JOptionPane.INFORMATION_MESSAGE);
		GOF.setIsOpenGTF(false);
		frame.dispose();
	}
	
	/**
	 * Este método verifica se foram digitados apenas números
	 */
	private void testingType() {
		if (notOnlyNumbers(LOC.getText(), CYCLO.getText(), 
				ATFD.getText(), LAA.getText())==4) {
			succeeded();
		} else {
			final JPanel warning = new JPanel();
			JOptionPane.showMessageDialog(warning, "Invalid values! Values "
					+ "â€‹â€‹must be all numeric!", "Warning",
					 JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/**
	 * Método que serve para contar o número de vezes que o utilizador digita números
	 * @param v1 - Campo LOC
	 * @param v2 - Campo CYCLO
	 * @param v3 - Campo ATFD
	 * @param v4 - Campo LAA
	 * @return - Retorna o número de vezes que o utilizador digita números
	 */
	private int notOnlyNumbers(String v1, String v2, String v3, String v4) {
		int check = isNumber(v1) + isNumber(v2) + 
				isNumber(v3) + isNumber(v4);
		return check;
	}
	
	/**
	 * Método que verifica se o campo value é um número
	 * @param value - Valor da métrica
	 * @return - Retorna 1 se o value for um número
	 */
	@SuppressWarnings("unused")
	private int isNumber(String value) {
		int count = 0;
	    try {
	        double d = Double.parseDouble(value);
	        count++;
	    } catch (NumberFormatException | NullPointerException nfe) {
	    }
		return count;
	}
		
}