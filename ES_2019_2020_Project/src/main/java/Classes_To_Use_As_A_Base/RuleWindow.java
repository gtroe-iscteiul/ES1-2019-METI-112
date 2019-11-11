package Classes_To_Use_As_A_Base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class RuleWindow extends JFrame { 
    private JList<String> countryList;
    private JTextField txtMtrica;
    private JTextField textField;
    private JTextField txtMtrica_1;
    private JTextField textField_1;
    public RuleWindow() { 
        //create the model and add elements 
        DefaultListModel<String> listModel = new DefaultListModel<>(); 
        listModel.addElement("LOC"); 
        listModel.addElement("CYCLO"); 
        listModel.addElement("ATFD"); 
        listModel.addElement("LAA"); 
        
        getContentPane().setLayout(null);
 
        //create the list 
        countryList = new JList<>(listModel); 
        countryList.setBounds(0, 0, 77, 73);
        getContentPane().add(countryList); 
        
        txtMtrica = new JTextField();
        txtMtrica.setText("Métrica 1");
        txtMtrica.setBounds(88, 11, 86, 20);
        getContentPane().add(txtMtrica);
        txtMtrica.setColumns(10);
        txtMtrica.setEditable(false);
        
        textField = new JTextField();
        textField.setBounds(87, 42, 86, 20);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        txtMtrica_1 = new JTextField();
        txtMtrica_1.setText("Métrica 2");
        txtMtrica_1.setBounds(88, 92, 86, 20);
        getContentPane().add(txtMtrica_1);
        txtMtrica_1.setColumns(10);
        txtMtrica_1.setEditable(false);
        
        textField_1 = new JTextField();
        textField_1.setBounds(88, 123, 86, 20);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        JRadioButton radioButton = new JRadioButton("&&");
        radioButton.setBounds(0, 91, 51, 23);
        getContentPane().add(radioButton);
        
        JRadioButton radioButton_1 = new JRadioButton("||");
        radioButton_1.setBounds(0, 119, 51, 23);
        getContentPane().add(radioButton_1);
         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setTitle("Rule Window");        
        this.setSize(200,200); 
        this.setLocationRelativeTo(null);
        this.setVisible(true); 
    } 
     
    public static void main(String[] args) { 
        SwingUtilities.invokeLater(new Runnable() { 
            @Override
            public void run() { 
                new RuleWindow(); 
            } 
        }); 
    }        
}