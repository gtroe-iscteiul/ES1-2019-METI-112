package Test_Suite_FileHandling;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.FileHandling;
import junit.framework.TestCase;

public class GetValueExpected_Test extends TestCase {

	@Test
	public void test() throws IOException {
		FileHandling file = new FileHandling();
		file.init("Long-Method.xlsx");
		String result = null;
		for(Row row : file.getMySheet()) {
			result = file.getValueExpected(row,0);
		}
		assertEquals("420.0",result);	}

}
