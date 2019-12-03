package ES1_2019_METI_112.ES_2019_2020_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI_Rule_Frame_Viewing {

	private JFrame frame;
	private GUI_Rules_Frame GRF;
	private AccessToRuleDatabase database;
	
	private JTextField textSelection;
	private JTextArea textMetrics;
	private String[] rules;
	private final int RuleMaxNumber = 10;
	private JList jList;

	/**
	 * Create the application.
	 */
	public GUI_Rule_Frame_Viewing(GUI_Rules_Frame grf) {
		this.GRF = grf;
		database = new AccessToRuleDatabase("CreatedRuleDatabase");
		rules = new String[RuleMaxNumber];
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Software Quality Assessment");
		frame.setLayout(new BorderLayout());
		addFrameContent();
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.pack();
		open();

	}

	@SuppressWarnings("deprecation")
	private void open() {
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.move(400, 150);		
	}

	private void addFrameContent() {
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelSouth = new JPanel();
		buildPanelNorth(panelNorth);
		buildPanelSouth(panelSouth);
		buildPanelCenter(panelCenter);
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.add(panelCenter, BorderLayout.CENTER);
	}

	@SuppressWarnings("rawtypes")
	private void buildPanelCenter(JPanel panelCenter) {
		panelCenter.setLayout(new FlowLayout());
		String[] conteudo;
	    DefaultListModel listModel = new DefaultListModel();
	    try {
			conteudo = database.readFile();
			for (int i = 0; i < conteudo.length; i++) {
				listModel.addElement(conteudo[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    jList = new JList(listModel);
	    panelCenter.add(jList);
	}

	private void buildPanelSouth(JPanel panelSouth) {
		panelSouth.setLayout(new FlowLayout());
		
		JButton select = new JButton("SELECT");
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
			}
		});
		panelSouth.add(select);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				GRF.setIsOpenGRFV(false);
				frame.dispose();
			}
		});
		panelSouth.add(back);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index = jList.getSelectedIndex();
				((DefaultListModel) jList.getModel()).remove(index);
				try {
					database.deleteRule(index); //Este método tem algum erro, mas o resto funciona(funciona o remover da jList)
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			}
		});
		panelSouth.add(delete);
	}

	private void buildPanelNorth(JPanel panelNorth) {
		panelNorth.setLayout(new FlowLayout());
		JLabel searchText = new JLabel("Rule: ");
		panelNorth.add(searchText);
	}

	
	
}
