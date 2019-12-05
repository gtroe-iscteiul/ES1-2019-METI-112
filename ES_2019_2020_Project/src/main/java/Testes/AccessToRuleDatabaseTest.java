package Testes;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

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
		String path = "CreatedRuleDatabase";
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
		testGetNumberOfLines();
	}

	@Test
	void testWriteToFile() {
		fail("Not yet implemented");
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