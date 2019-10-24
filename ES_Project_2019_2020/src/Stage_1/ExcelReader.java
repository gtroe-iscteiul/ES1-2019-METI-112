package Stage_1;

import java.io.File;
import java.io.IOException;

public class ExcelReader {
 
	public static void main(String args[]) throws IOException {
		
		// This allow to access the excel file
		File file = new File("C:\\Users\\gonca\\eclipse-workspace-EE"
				+ "\\ES_Project_2019_2020\\src\\Long-Method.xlsx");

		System.out.println("File size: " + file.length() + " bytes");
		
		// In principle we will have to use some libraries outside of eclipse (Apache POI)
	
	}
	
}