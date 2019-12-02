package ES1_2019_METI_112.ES_2019_2020_Project;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {

	private String path;
	private boolean append_to_file = false;
	
	public WriteFile(String path) {
		this.path = path;
	}
	
	public WriteFile(String path, boolean append_to_file) {
		this.path = path;
		this.append_to_file = append_to_file;
	}
	
	public void writeToFile( String textLine ) throws IOException {
		FileWriter write = new FileWriter(path , append_to_file);
		PrintWriter print_line = new PrintWriter( write );
		print_line.printf( "%s" + "%n" , textLine);
		print_line.close();
		
	}
	
	
	public static void main(String[] args) {
		WriteFile w = new WriteFile("Rules Created",true);
		try {
			w.writeToFile("teste");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
