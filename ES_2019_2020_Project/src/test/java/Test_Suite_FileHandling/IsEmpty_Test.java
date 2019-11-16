package Test_Suite_FileHandling;

import java.io.IOException;

import org.junit.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.FileHandling;
import junit.framework.TestCase;

public class IsEmpty_Test extends TestCase {

	@Test
	public void test_IsEmpty() throws IOException {
		FileHandling file = new FileHandling();
		file.init("Long-Method.xlsx");
		boolean result = file.isEmpty();
		
		assertFalse(result);
		//file.init("emptyFile.xlsx");
		//assertTrue(result);

	}

}
