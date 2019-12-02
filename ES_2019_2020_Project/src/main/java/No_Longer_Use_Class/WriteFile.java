package No_Longer_Use_Class;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {

	private String path;
	
	public WriteFile(String path) {
		this.path = path;
	}	
	
	public void writeToFile( String textLine ) throws IOException {
		FileWriter write = new FileWriter(path, true);
		PrintWriter print_line = new PrintWriter( write );
		print_line.printf( "%s" + "%n" , textLine);
		print_line.close();	
	}
	
	
/*	public static void main(String[] args) {
		WriteFile w = new WriteFile("Rules Created",true);
		try {
			w.writeToFile("teste");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
*/
}
