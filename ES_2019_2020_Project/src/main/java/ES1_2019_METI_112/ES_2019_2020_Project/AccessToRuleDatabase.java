package ES1_2019_METI_112.ES_2019_2020_Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class AccessToRuleDatabase {
	
	private String path;
	
	
	public AccessToRuleDatabase(String path) {
		this.path = path;
	}
	
	
	public void writeToFile(String textLine) throws IOException {
		FileWriter write = new FileWriter(path, true);
		PrintWriter print_line = new PrintWriter(write);
		print_line.printf("%s" + "%n" , textLine);
		print_line.close();	
	}
	
	
	@SuppressWarnings("resource")
	public String[] readFile() throws IOException {
		String[] vector = new String[10];
		BufferedReader br = new BufferedReader(new FileReader(path)); 
		String st; 
		for (int i = 0; i < vector.length; i++) {
			while ((st = br.readLine()) != null) {
				vector[i] = st;
				System.out.println(vector[i]); 
			}
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