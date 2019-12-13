package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class GUI_JTable {

	private GUI_Operative_Frame GOF;
	private JFrame frame;

	/**
	 * Construtor da classe
	 * @param g - Recebe GUI_Operative_Frame como parâmetro
	 */
	public GUI_JTable (GUI_Operative_Frame g) {
		this.GOF = g;
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
		frame.setSize(1200, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(80, 130);
	}

	/**
	 * Este método adiciona chama um método para adicionar a JTable à janela
	 */
	private void addFrameContent(){
		openJTable();
	}

	/**
	 * Este método tem como objetivo adicionar a tabela à janela e também adicionar o botão BACK
	 * BACK - Volta à janela anteriormente aberta
	 */
	private void openJTable() {
		int lines = GOF.getGMC().getFile().getNumberOfLines();
		int columns = GOF.getGMC().getFile().getNumberOfColumns();

		String[][] data = new String[lines-1][columns];
		String columnName [] = new String[columns];

		for (int i=0; i<columns; i++) {
			columnName[i] = GOF.getGMC().getFile().getCellValue(0, i);
		}

		for (int x=1; x<lines; x++) {
			for (int y=0; y<columns; y++) {
				data[x-1][y] = GOF.getGMC().getFile().getCellValue(x, y);
			}
		}

		JTable table = new JTable(data, columnName);

		JScrollPane scrollPane = new JScrollPane(table);

		frame.add(scrollPane, BorderLayout.NORTH);	

		JPanel panel = new JPanel();
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GOF.setIsOpenGJT(false);
				frame.dispose();
			}
		});
		panel.add(button);
		frame.add(panel, BorderLayout.SOUTH);
	}

}