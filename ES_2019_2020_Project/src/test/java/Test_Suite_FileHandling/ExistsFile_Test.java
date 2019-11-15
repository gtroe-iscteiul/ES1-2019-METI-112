package Test_Suite_FileHandling;

import java.io.IOException;

import org.junit.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.FileHandling;
import junit.framework.TestCase;

public class ExistsFile_Test extends TestCase {

	@Test
	public void test_ExistsFile() throws IOException {
		FileHandling file = new FileHandling();
		file.init("Long-Method.xlsx");
		boolean result = file.existsFile(file.getFile());
		
		assertTrue(result);
		//file.init("ficheiro_inexistente");
		//assertFalse(result);
	
	}

}
