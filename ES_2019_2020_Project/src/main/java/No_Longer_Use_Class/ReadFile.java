package No_Longer_Use_Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	private String path;
	
	public ReadFile(String path) {
		this.path = path;
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
		   
	
	
	
	public static void main(String[] args) {
		ReadFile rf = new ReadFile("CreatedRuleDatabase");
		try {
			rf.readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
