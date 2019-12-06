package Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.Object;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;

//import com.sun.rowset.internal.Row;

import ES1_2019_METI_112.ES_2019_2020_Project.FileHandling;

class FileHandlingTest {
	
	private FileHandling fh;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		fh = new FileHandling();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testInit() throws IOException {
		File file = new File("Long-Method.xlsx");
		FileInputStream inputFile = new FileInputStream(file);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (inputFile);
		XSSFSheet sheet = myWorkBook.getSheetAt(0);
		
		FileHandling f = new FileHandling();
		f.init("Long-Method.xlsx");
		
		//assertEquals(sheet, f.getMySheet());
	}

	@Test
	final void testGetMySheet() throws IOException {
		File file = new File("Long-Method.xlsx");
		//fh.init("Long-Method.xlsx");
		FileInputStream inputFile = new FileInputStream(file);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (inputFile);
		XSSFSheet sheet = myWorkBook.getSheetAt(0);
		assertEquals(null, fh.getMySheet());
	}

	@Test
	final void testGetFile() throws IOException {
		File file = new File("Long-Method.xlsx");
		fh.init("Long-Method.xlsx");
		assertEquals(file,fh.getFile());
	}

	@Test
	final void testExistsFile() throws IOException {
		fh.init("Long-Method.xlsx");
		boolean result = fh.existsFile(fh.getFile());
		assertTrue(result);
		
		File f = new File ("abc.xlsx");
		assertFalse(fh.existsFile(f));
	
	}

	@Test
	final void testGetNumberOfLines() throws IOException {
		fh.init("Long-Method.xlsx");
		int result = fh.getNumberOfLines();
		
		assertEquals(421,result);
		FileHandling fg = new FileHandling();
		fg.init("emptyFile.xlsx");
		
		assertEquals(0,fg.getNumberOfLines());
	}

	@Test
	final void testGetNumberOfColumns() throws IOException {
		fh.init("Long-Method.xlsx");
		int result = fh.getNumberOfColumns();
		
		assertEquals(12,result);
		FileHandling fg = new FileHandling();
		fg.init("emptyFile.xlsx");
		
		assertEquals(0,fg.getNumberOfColumns());
	}

	@Test
	final void testGetColumnOfType() throws IOException {
		fh.init("Long-Method.xlsx");
		String tipo = new String("class");
		assertEquals(2, fh.getColumnOfType(tipo));
		
		assertThrows(IllegalStateException.class,()->{fh.getColumnOfType(null);});
	}

	@Test
	final void testGetValueExpected() throws IOException {
		File file = new File("Long-Method.xlsx");
		FileInputStream inputFile = new FileInputStream(file);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (inputFile);
		XSSFSheet sheet = myWorkBook.getSheetAt(0);
		
		String valor = new String ("1.0");
		Row r = sheet.getRow(1);
		assertEquals(valor,fh.getValueExpected (r, 0));
		
		Row r1 = sheet.getRow(2);
		assertEquals("Structure()", fh.getValueExpected(r1, 3));
		
		Row r2 = sheet.getRow(4);
		assertEquals("false", fh.getValueExpected(r2, 8));
	}

	@Test
	final void testGetCellValueIntString() throws IOException {
		fh.init("Long-Method.xlsx");
		String result = fh.getCellValue(1,"package");
		
		assertEquals("fat",result);
	}

	@Test
	final void testGetCellValueIntInt() throws IOException {
		fh.init("Long-Method.xlsx");
		String result = fh.getCellValue(1,1);
		
		assertEquals("fat",result);
	}

	@Test
	final void testIsEmpty() throws IOException {
		
		fh.init("Long-Method.xlsx");
		boolean result = fh.isEmpty();
		assertFalse(result);
		
		fh.init("emptyFile.xlsx");
		assertTrue(fh.isEmpty());
	}

}