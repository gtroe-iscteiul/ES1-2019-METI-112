package ES1_2019_METI_112.ES_2019_2020_Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.LinkedList;

public class AccessToRuleDatabase {
	
	private String path;
	private LinkedList<String> deleteManager;
	
	public AccessToRuleDatabase(String path) {
		this.path = path;
		this.deleteManager = new LinkedList<>();
	}
	
	
	public void writeToFile(String textLine, boolean operation) throws IOException {
		FileWriter write = new FileWriter(path, operation);
		PrintWriter print_line = new PrintWriter(write);
		print_line.printf("%s" + "%n" , textLine);
		print_line.close();	
	}
		
	
	@SuppressWarnings("resource")
	public String[] readFile() throws IOException {
		String[] vector = new String[getNumberOfLines()];
		BufferedReader br = new BufferedReader(new FileReader(path)); 
		for (int i = 0; i < getNumberOfLines(); i++) {
			vector[i] = br.readLine();
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
	
	
	@SuppressWarnings("resource")
	public void deleteRule(String rule) throws IOException {
		String[] vector = new String[getNumberOfLines()];
		BufferedReader br = new BufferedReader(new FileReader(path)); 
		for (int i = 0; i < getNumberOfLines(); i++) {
			vector[i] = br.readLine();
			if(!vector[i].equals(rule)) {
				deleteManager.add(vector[i]);
			}
		}
		updateDatabase();
	}
	
	
	private void updateDatabase() throws IOException {
		for(String i : deleteManager) {
			if(deleteManager.getFirst().equals(i)) {
				writeToFile(i.toString(), false);
			} else {
				writeToFile(i.toString(), true);
			}
		}
	}
	
}