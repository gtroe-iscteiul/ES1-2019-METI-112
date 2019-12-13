package Tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.AccessToRuleDatabase;

class AccessToRuleDatabaseTest {

	static AccessToRuleDatabase a;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		String path = "AuxRuleDataBase";
		a = new AccessToRuleDatabase(path);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAccessToRuleDatabase() throws IOException {
		testWriteToFile();
	}

	@Test
	void testWriteToFile() throws FileNotFoundException {
		Scanner s = new Scanner(new FileReader("AuxRuleDataBase"));
		int size = 0;
		while(s.hasNextLine()) {
			String v = s.nextLine();
			size++;
		}
		assertEquals(3, size);
	}

	@Test
	void testReadFile() throws IOException {
		String[] expected = new String [3];
		expected[0] = "Rule_2 if(LOC==4&&CYCLO==6||ATFD==5) is_long_method=false";
		expected[1] = "Rule_3 if(LOC==9&&CYCLO==9||ATFD==9) is_long_method=false";
		expected[2] = "Rule_4 if(ATFD==680&&LAA==8&&CYCLO==7||LOC==6) is_feature_envy=false";

		assertArrayEquals(expected, a.readFile());
	}
	
	@Test
	void testGetLine() throws IOException {
		String[] expected = new String [3];
		expected[0] = "Rule_2 if(LOC==4&&CYCLO==6||ATFD==5) is_long_method=false";
		assertArrayEquals(expected, a.getLine(1));	
	}


	@Test
	void testGetNumberOfLines() throws IOException {
		assertEquals(3, a.getNumberOfLines());
	}

	@Test
	void testDeleteRule() throws IOException {
		String[] expected = new String [2];
		expected[0] = "Rule_2 if(LOC==4&&CYCLO==6||ATFD==5) is_long_method=false";
		expected[1] = "Rule_3 if(LOC==9&&CYCLO==9||ATFD==9) is_long_method=false";

		//A linha seguinte tem de estar comentada, sendo que esta afeta os dados do ficheiro CreatedRuleDataBase.
		//So pode ser descomentada quando o teste esta a ser efetuado.
		//A seguir ao método ser testado tem de se adicionar de novo a regra que foi eliminada.
		//a.deleteRule("Rule_4 if(ATFD==680&&LAA==8&&CYCLO==7||LOC==6) is_feature_envy=false");

		assertArrayEquals(expected, a.readFile());
	}

}