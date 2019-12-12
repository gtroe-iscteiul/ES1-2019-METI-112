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
	
	private File file; //Variável ficheiro
	private FileInputStream inputFile;
	private XSSFWorkbook myWorkBook;
	private XSSFSheet mySheet;
	
	/**
	 * Este método serve para abrir o ficheiro XML
	 * @param fileName - Nome do ficheiro XML
	 * @throws IOException
	 */
	public void init (String fileName) throws IOException {
		 file = new File(fileName);
		
		 inputFile = new FileInputStream(file);
		     
		 // Finds the workbook instance for XLSX file
		 myWorkBook = new XSSFWorkbook (inputFile);
		     
		 // Return first sheet from the XLSX workbook
		 mySheet = myWorkBook.getSheetAt(0);
	}
	
	/**
	 * Getters da classe
	 */
	public XSSFSheet getMySheet() {
		return mySheet;
	}

	public File getFile() {
		return file;
	}
	
	
	/**
	 * Método que serve para verificar se o ficheiro já se encontra aberto
	 * @param file - Parâmetro file
	 * @return
	 */
	public boolean existsFile (File file) {
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Método que serve para devolver o número de linhas do ficheiro XML
	 */
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
	
	/**
	 * Método que serve para devolver o número de colunas do ficheiro XML
	 */
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
	
	/**
	 * Método que serve para devolver o número da coluna em questão
	 * @param type - String com o nome da coluna
	 */
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
	
	/**
	 * Este método serve para retornar uma String com o campo em questão
	 * @param row - Linha do ficheiro
	 * @param column - número da coluna do ficheiro
	 * @return retorna a String em questão
	 */
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
	

	/**
	 * Este método serve para escolher uma célula baseado no MethodID e do tipo da coluna, que vai ser muito útil na JFrame responsável pela seleção do user
	 * @param methodId - id do método
	 * @param type - Nome da coluna
	 */
	public String getCellValue (int methodId, String type) {
		String result = null;
		for (Row row : mySheet) {
			if (row.getRowNum()==methodId) {
				result = getValueExpected(row, getColumnOfType(type));
			}
		}
		return result;
	}
	
	// This function allows to select a cell based on a line and a column integer value
	// which will be very useful to use in Jframe responsible for the user selection
	/**
	 * Este método serve para escolher uma célula baseado numa linha e duma coluna, que vai ser muito útil na JFrame responsável pela seleção do user
	 * @param line - Número da linha
	 * @param column - Número da coluna
	 */
	public String getCellValue (int line, int column) {
		String value = null;
		for (Row row : mySheet) {
			if (row.getRowNum()==line) {
				value = getValueExpected(row, column);
			}
		}
		return value;
	}
	
	/**
	 * Verifica se o ficheiro XML se encontra vazio
	 * @return Retorna um booleano
	 */
	public boolean isEmpty () {
		if (getNumberOfLines()<1) {
			return true;
		} else {
			return false;
		}
	}
	
}