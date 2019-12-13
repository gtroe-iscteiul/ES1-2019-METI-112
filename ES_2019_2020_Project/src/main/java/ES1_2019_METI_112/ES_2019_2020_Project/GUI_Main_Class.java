package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class GUI_Main_Class {
	
	/**
	 *  Variável do ficheiro
	 */
	private FileHandling file;
	/**
	 * Nome do ficheiro que o utilizador quer abrir
	 */
	private String fileName;
	/**
	 * Frame da janela de importação do ficheiro
	 */
	private JFrame frame;
	/**
	 * Variável da GUI_Operative_Frame
	 */
	private GUI_Operative_Frame GOF;
	private GUI_Main_Class GMC;
	/**
	 * Boolean que serve para verificar se a janela já se encontra aberta
	 */
	private boolean isGuiOperativeFrameOpen = false;
	
	public GUI_Main_Class () {
		GMC = this;
	}
	
	/**
	 * Este método tem como objetivo inicializar a janela
	 * 
	 */
	private void init () {
		frame = new JFrame("Software Quality Assessment");
		frame.setLayout(new BorderLayout());
		addFrameContent();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		open();
		
		disableWarning();
	}
	
	public FileHandling getFile () {
		return file;
	}
	
	public GUI_Operative_Frame getGOF() {
		return GOF;
	}
	
	public boolean getIsOpenGOF() {
		return isGuiOperativeFrameOpen;
	}
	
	public void setIsOpenGOF(boolean state) {
		this.isGuiOperativeFrameOpen = state;
	}	
	
	/**
	 * Este  método tem como objetivo definir definições da janela, tais como o seu tamanho 
	 */
	@SuppressWarnings("deprecation")
	private void open(){
		frame.setSize(400, 135);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(450, 200);
	}
	
	/**
	 * Este método tem como objetivo adicionar componentes à janela
	 */
	private void addFrameContent(){
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		
		// panel_1 definition
		panel_1.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("File name to import: ");
		panel_1.add(searchText);
		
		// panel_2 definition
		final JTextField text = new JTextField("               "
				+ "                                            ");
		panel_2.add(text);
		
		// panel_3 definition
		panelBuild(panel_3, text);
				
		frame.add(panel_1, BorderLayout.NORTH);
		frame.add(panel_2, BorderLayout.CENTER);
		frame.add(panel_3, BorderLayout.SOUTH);
	}
	
	/**
	 * Este método tem como objetivo criar o painel Sul da janela
	 * @param panel_3 o parâmetro painel
	 * @param text parâmetro que serve para recuperar o texto escrito pelo utilizador
	 */
	private void panelBuild(JPanel panel_3, final JTextField text) {
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					fileName = text.getText();
					file = new FileHandling();
					importFile(text);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_3.add(ok);
	}
	
	
	/**
	 * Este método tem como objetivo lidar com as excepções referentes à importação do ficheiro
	 * @param text parâmetro texto escrito pelo utilizador que serve para tratar as diferentes exceptions
	 * @throws IOException
	 */
	private void importFile (JTextField text) throws IOException {
		File f = new File(fileName);
		 if (file.existsFile(f)) {
			 dealWithExternalErrors(file);
		 } else {
			 dealWithInternalErrors(text);
		 }		
	}
	
	/**
	 * Este método serve para lidar com situações em que o utilizador tenta abrir várias vezes a mesma janela
	 * @param file Parâmetro referente ao ficheiro
	 * @throws IOException
	 */
	private void dealWithExternalErrors(FileHandling file) throws IOException {
		file.init(fileName);
		if (isGuiOperativeFrameOpen==true) {
			 final JPanel warning = new JPanel();
			 JOptionPane.showMessageDialog(warning, "Unable to open "
			 		+ "new file operations window! Window is already "
			 		+ "open!", "Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			isGuiOperativeFrameOpen = true;
			GOF = new GUI_Operative_Frame(GMC);
		}
	}
	
	/**
	 * Este método serve para lidar com situações em que o utilizador digita o nome errado
	 * @param text Parâmetro texto referente ao texto escrito pelo utilizador
	 */
	private void dealWithInternalErrors(JTextField text) {
//		if (text.getText().isEmpty()) {
		// Usar este 'if' em caso de erro no 'isBlank', mas no fim, voltar a colocar
		if (text.getText().isBlank()) {
			 final JPanel warning = new JPanel();
			 JOptionPane.showMessageDialog(warning, "Blank search field! "
			 		+ "Please enter filename to continue!", "Warning",
			 		JOptionPane.WARNING_MESSAGE);
		 } else {
			 final JPanel warning = new JPanel();
			 JOptionPane.showMessageDialog(warning, "The file name entered "
			 		+ "does not exist in the directory!", "Warning",
			 		JOptionPane.WARNING_MESSAGE);
		 }
		
	}
	
	private static void disableWarning() {
	    System.err.close();
	    System.setErr(System.out);
	}
		
	/**
	 * Método main do projeto
	 * @param args Parâmetro args do main
	 */
	public static void main(String[] args) {
		GUI_Main_Class GUI = new GUI_Main_Class();
		GUI.init();
	}
}