package No_Longer_Use_Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Teste {



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
        
         
/////// Serve para saber o número de linhas e colunas do ficheiro Excel///////////////////
      	Iterator<Row> iterator = mySheet.iterator();

      	XSSFRow Hrow = null;
        while( iterator.hasNext()){
        	Hrow = (XSSFRow) iterator.next();
        }
        if (Hrow != null) {
            System.out.print("Number of lines: " + (Hrow).getRowNum());
            System.out.println("");
            System.out.println("Number os columns: " + (Hrow).getLastCellNum());
            System.out.println("");
        }
//////////////////////////////////////////////////////////////////////////////////////////
        
         
		for (Row row : mySheet) {
			System.out.println(row.getCell(1).getStringCellValue());
			
			//System.out.println(row.toString() + ";");
		}
		
	}
	
}
