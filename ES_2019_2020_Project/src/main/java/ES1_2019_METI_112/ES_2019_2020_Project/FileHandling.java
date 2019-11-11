package ES1_2019_METI_112.ES_2019_2020_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileHandling {
	
	private File file;
	private FileInputStream inputFile;
	private XSSFWorkbook myWorkBook;
	private XSSFSheet mySheet;
	
	public void init (String fileName) throws IOException {
		 file = new File(fileName);
		
		 inputFile = new FileInputStream(file);
		     
		 // Finds the workbook instance for XLSX file
		 myWorkBook = new XSSFWorkbook (inputFile);
		     
		 // Return first sheet from the XLSX workbook
		 mySheet = myWorkBook.getSheetAt(0);
	}
	
	public boolean existsFile (File file) {
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public int getNumberOfLines () {
		Iterator<Row> iterator = mySheet.iterator();
		XSSFRow Hrow = null;
	    while( iterator.hasNext()){
	    	Hrow = (XSSFRow) iterator.next();
	    }
	    if (Hrow != null) {
	    	return (Hrow).getRowNum()+1; //don't consider line 0, so we have to compensate
	    } else {
	    	return 0;
	    }
	}
	
	public int getNumberOfColumns () {
		Iterator<Row> iterator = mySheet.iterator();
		XSSFRow Hrow = null;
	    while( iterator.hasNext()){
	    	Hrow = (XSSFRow) iterator.next();
	    }
	    if (Hrow != null) {
	    	return (Hrow).getLastCellNum();
	    } else {
	    	return 0;
	    }
	}
	
	public int getColumnOfType (String type) {
		int value = -1;
		for (Row row : mySheet) {
			for (int i=0; i<getNumberOfColumns(); i++) {
				if (row.getRowNum()==0 && getValueExpected(row, i).equals(type)) {
					value = i;
				}
			}
		}
		if (value!=-1) {
			return value;
		} else {
			 // later the exception will cease to exist and 
			 // will become a warning in a jframe
			 throw new IllegalStateException ("The type entered does "
			 		+ "not exist in the Excel file!");
		}
	}
	
	public String getValueExpected (Row row, int column) {
		String value = null;
		if (row.getCell(column).getCellType()==0) {
			value = Double.toString(row.getCell(column).getNumericCellValue());
		}
		if (row.getCell(column).getCellType()==1) {
			value = row.getCell(column).getStringCellValue();
		}
		if (row.getCell(column).getCellType()==4) {
			value = String.valueOf(row.getCell(column).getBooleanCellValue());
		}
		return value;
	}
	
	// This function allows to select a cell based on MethodID and a column type
	// which will be very useful to use in Jframe responsible for the user selection
	public String getCellValue (int methodId, String type) {
		String result = null;
		for (Row row : mySheet) {
			if (row.getRowNum()==methodId) {
				result = getValueExpected(row, getColumnOfType(type));
			}
		}
		return result;
	}
	
	public String getCellValue (int line, int column) {
		String value = null;
		for (Row row : mySheet) {
			if (row.getRowNum()==line) {
				value = getValueExpected(row, column);
			}
		}
		return value;
	}

/*	public static void main(String[] args) throws IOException {        
                  
		FileHandling fh = new FileHandling();
		fh.init("Long-Method.xlsx");
		System.out.println("Number of lines: " + fh.getNumberOfLines());
		System.out.println("Number of columns: " + fh.getNumberOfColumns());
		System.out.println("Cell 0 on 0: " + fh.getCellValue(0, "MethodID"));
		System.out.println("Cell 1 on 1: " + fh.getCellValue(1, "package"));
		System.out.println("Cell 2 on 2: " + fh.getCellValue(2, "class"));
		System.out.println("Cell 3 on 3: " + fh.getCellValue(3, "method"));
		System.out.println("Cell 4 on 4: " + fh.getCellValue(4, "LOC"));
		System.out.println("Cell 5 on 5: " + fh.getCellValue(5, "CYCLO"));
		System.out.println("Cell 6 on 6: " + fh.getCellValue(6, "ATFD"));
		System.out.println("Cell 7 on 7: " + fh.getCellValue(7, "LAA"));
		System.out.println("Cell 8 on 8: " + fh.getCellValue(8, "is_long_method"));
		System.out.println("Cell 9 on 9: " + fh.getCellValue(9, "iPlasma"));
		System.out.println("Cell 10 on 10: " + fh.getCellValue(10, "PMD"));
		System.out.println("Cell 11 on 11: " + fh.getCellValue(11, "is_feature_envy"));
		System.out.println("Cell 0 on 11: " + fh.getCellValue(0, "is_feature_envy"));
	}
*/	
}