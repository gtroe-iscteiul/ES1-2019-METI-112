package ES1_2019_METI_112.ES_2019_2020_Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JList;

public class AccessToRuleDatabase {
	
	private String path;
	private ArrayList<String> chaves = new ArrayList<>(); //Lista para guardar as chaves da base de dados
	
	
	public AccessToRuleDatabase(String path) {
		this.path = path;
	}
	
	
	public void writeToFile(String textLine) throws IOException {
		FileWriter write = new FileWriter(path, true);
		PrintWriter print_line = new PrintWriter(write);
		print_line.printf("%s" + "%n" , textLine);
		guardarChave(textLine);
		print_line.close();	
	}
	
	private void guardarChave(String textLine) {
		int espacoInt = textLine.indexOf(' ');
		String chave = textLine.substring(0, espacoInt);
		chaves.add(chave);
	}
	
	public void deleteRule(int indice) throws IOException {
		FileWriter write = new FileWriter(path, true);
		BufferedReader br = new BufferedReader(new FileReader(path)); 
		for (int i = 0; i < getNumberOfLines(); i++) {
			if(br.readLine().equals(chaves.get(indice))) {
				write.write("");
			}
		}	
		write.close(); 
		br.close(); 
		chaves.remove(indice);
	}
	
	
	@SuppressWarnings("resource")
	public String[] readFile() throws IOException {
		String[] vector = new String[getNumberOfLines()];
		BufferedReader br = new BufferedReader(new FileReader(path)); 
		for (int i = 0; i < getNumberOfLines(); i++) {
			vector[i] = br.readLine();
//			System.out.println(vector[i]); 
		}
		return vector;
	}
	
	
	@SuppressWarnings("resource")
	public int getNumberOfLines() throws IOException {
		File file = new File(path);
		LineNumberReader count = new LineNumberReader(new FileReader(file));
		count.skip(file.length());
		return count.getLineNumber();		
	}
	
}