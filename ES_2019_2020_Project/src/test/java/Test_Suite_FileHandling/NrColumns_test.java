package Test_Suite_FileHandling;

import java.io.IOException;

import org.junit.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.FileHandling;
import junit.framework.TestCase;

public class NrColumns_test extends TestCase{

	@Test
	public void test() throws IOException {
		FileHandling file = new FileHandling();
		file.init("Long-Method.xlsx");
		int result = file.getNumberOfColumns();
		
		assertEquals(12,result);
	}

}
