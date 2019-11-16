package Test_Suite_FileHandling;

import java.io.IOException;

import org.junit.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.FileHandling;
import junit.framework.TestCase; 

public class NrLines_Test extends TestCase {

	@Test
	public void testgetNumberOfLines() throws IOException {
		FileHandling file = new FileHandling();
		file.init("Long-Method.xlsx");
		int result = file.getNumberOfLines();
		assertEquals(421,result);
	}

}
