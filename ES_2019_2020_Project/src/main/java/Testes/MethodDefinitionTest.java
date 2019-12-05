package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;
import ES1_2019_METI_112.ES_2019_2020_Project.MethodDefinition;

class MethodDefinitionTest {

	private String LOC;
	private String CYCLO;
	private String ATFD;
	private String LAA;
	private MethodDefinition m;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
	final void testMethodDefinition() {
		m = new MethodDefinition(LOC, CYCLO, ATFD, LAA);
		assertEquals(LOC, m.getLOC());
	}

	@Test
	final void testGetLOC() {
		m = new MethodDefinition(LOC, CYCLO, ATFD, LAA);
		assertEquals(LOC, m.getLOC());
	}

	@Test
	final void testGetCYCLO() {
		m = new MethodDefinition(LOC, CYCLO, ATFD, LAA);
		assertEquals(CYCLO, m.getCYCLO());
	}

	@Test
	final void testGetATFD() {
		m = new MethodDefinition(LOC, CYCLO, ATFD, LAA);
		assertEquals(ATFD, m.getATFD());
	}

	@Test
	final void testGetLAA() {
		m = new MethodDefinition(LOC, CYCLO, ATFD, LAA);
		assertEquals(LAA, m.getLAA());
	}

	@Test
	final void testSetLOC() {
		m = new MethodDefinition(LOC, CYCLO, ATFD, LAA);
		m.setLOC("loc");
		assertEquals("loc", m.getLOC());
	}

	@Test
	final void testSetCYCLO() {
		m = new MethodDefinition(LOC, CYCLO, ATFD, LAA);
		m.setCYCLO("cyclo");
		assertEquals("cyclo", m.getCYCLO());
	}

	@Test
	final void testSetATFD() {
		m = new MethodDefinition(LOC, CYCLO, ATFD, LAA);
		m.setATFD("atfd");
		assertEquals("atfd", m.getATFD());
	}

	@Test
	final void testSetLAA() {
		m = new MethodDefinition(LOC, CYCLO, ATFD, LAA);
		m.setLAA("laa");
		assertEquals("laa", m.getLAA());
	}

	@Test
	final void testHasBeenInitialized() {
		m = new MethodDefinition(LOC, CYCLO, ATFD, LAA);
		m.setATFD("-1");
		m.setCYCLO("-1");
		m.setLAA("-1");
		m.setLOC("-1");
		
		assertFalse(m.hasBeenInitialized());
		
		m.setATFD("1");
		m.setCYCLO("1");
		m.setLAA("1");
		m.setLOC("1");
		
		assertTrue(m.hasBeenInitialized());
	}

	@Test
	final void testLongMethodDefinition() {
		m = new MethodDefinition(LOC, CYCLO, ATFD, LAA);
	
		m.setCYCLO("-1");
		m.setLOC("-1");
		
		assertFalse(m.longMethodDefinition());
		
		m.setCYCLO("12");
		m.setLOC("90");
		
		assertTrue(m.longMethodDefinition());
	}

	@Test
	final void testFeatureEnvyDefinition() {
		m = new MethodDefinition(LOC, CYCLO, ATFD, LAA);
		m.setATFD("-1");
		m.setLAA("1");
		
		assertFalse(m.featureEnvyDefinition());
		
		m.setATFD("6");
		m.setLAA("0.30");
		
		assertTrue(m.featureEnvyDefinition());
	}

}
