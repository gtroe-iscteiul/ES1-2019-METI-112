package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Defect_Detection;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;

class GUI_Defect_DetectionTest {
	
	private GUI_Operative_Frame of;
	private GUI_Main_Class mc;
	private GUI_Defect_Detection dd;
	private int numberOfThreads;
	private int DCI;
	private int DII;
	private int ADCI;
	private int ADII;
	private int number=2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		of = new GUI_Operative_Frame(mc);
		dd = new GUI_Defect_Detection(of);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGUI_Defect_Detection() {
		assertEquals(0, dd.getNumberOfThreads());
	}

	@Test
	final void testGetGOF() {
		of = new GUI_Operative_Frame(mc);
		//operative frame diferentes ..
		assertEquals(of, dd.getGOF());
	}

	@Test
	final void testGetNumberOfThreads() {
		assertEquals(0, dd.getNumberOfThreads());
	}

	@Test
	final void testSetThreadWorkingUp() {
		dd.setThreadWorkingUp();
		assertEquals(1, dd.getNumberOfThreads());
	}

	@Test
	final void testSetThreadWorkingDown() {
		dd.setThreadWorkingDown();
		assertEquals(-1, dd.getNumberOfThreads());
	}

	@Test
	final void testGetDCI() {
		assertEquals(DCI, dd.getDCI());
	}

	@Test
	final void testGetDII() {
		assertEquals(DII, dd.getDII());
	}

	@Test
	final void testGetADCI() {
		assertEquals(ADCI, dd.getADCI());
	}

	@Test
	final void testGetADII() {
		assertEquals(ADII, dd.getADII());
	}

	@Test
	final void testSetDCI() {
		dd.setDCI(number);
		assertEquals(2, dd.getDCI());
	}

	@Test
	final void testSetDII() {
		dd.setDII(number);
		assertEquals(2, dd.getDII());
	}

	@Test
	final void testSetADCI() {
		dd.setADCI(number);
		assertEquals(2, dd.getADCI());
	}

	@Test
	final void testSetADII() {
		dd.setADII(number);
		assertEquals(2, dd.getADII());
	}

}