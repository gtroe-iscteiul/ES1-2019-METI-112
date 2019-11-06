package ES1_2019_METI_112.ES_2019_2020_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Teste {

	private String path = "/Users/Jorge/git/projeto/ES1-2019-METI-112/ES_2019_2020_Project/documentos/Long-Method.xlsx";

	public static void main(String[] args) throws IOException {
//		File excelFile = new File("/Users/Jorge/git/projeto/ES1-2019-METI-112/ES_2019_2020_Project/documentos/Long-Method.xlsx");
//		FileInputStream fis = new FileInputStream(excelFile);
//		
//		HSSFWorkbook workbook = new HSSFWorkbook(fis);
//		HSSFSheet sheet = workbook.getSheetAt(0);
//		
//		
//		for (Row row : sheet) {
//			System.out.println(row.toString() + ";");
//		}
//		
//		workbook.close();
//		fis.close();
	
//		ClassLoader classloader = org.apache.poi.poifs.filesystem.POIFSFileSystem.class.getClassLoader();
//		URL res = classloader.getResource("org/apache/poi/util/POILogger.class");
//		String path = res.getPath();
//		System.out.println("POI came from " + path);

		 File myFile = new File("Long-Method.xlsx");
         FileInputStream fis = new FileInputStream(myFile);

         // Finds the workbook instance for XLSX file
         XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
        
         // Return first sheet from the XLSX workbook
         XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        
        
		for (Row row : mySheet) {
			System.out.println(row.toString() + ";");
		}
		
	}
	
}
