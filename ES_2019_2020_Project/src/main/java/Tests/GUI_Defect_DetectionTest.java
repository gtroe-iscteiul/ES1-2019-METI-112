package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Defect_Detection;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Defect_Detection_JTable;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;

class GUI_Defect_DetectionTest {

	private GUI_Operative_Frame of;
	private GUI_Main_Class mc;
	private GUI_Defect_Detection dd;
	private GUI_Defect_Detection_JTable jt;
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
		//	jt = new GUI_Defect_Detection_JTable (dd);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGUI_Defect_Detection() {
		testGetGOF();
	}

	@Test
	final void testGetGOF() {
		assertEquals(of, dd.getGOF());
	}

	@Test
	final void testGetGDDJT() {
		//assertEquals(jt,dd.getGDDJT());
		fail("Not yet implemented"); // TODO
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

	@Test
	final void testSetChosenRule() {
		assertEquals("",dd.getChosenRule());
	}

	@Test
	final void testIsOpenGDDR() {
		assertFalse(dd.isOpenGDDR());
	}

	@Test
	final void testIsOpenGDDJT() {
		dd.setIsOpenGDDJT(false);
		assertFalse(dd.isOpenGDDJT());
	}

	@Test
	final void testSetIsOpenGDDR() {
		dd.setIsOpenGDDR(true);
		assertTrue(dd.isOpenGDDR());
	}

	@Test
	final void testSetIsOpenGDDJT() {
		dd.setIsOpenGDDJT(false);
		assertFalse(dd.isOpenGDDJT());
	}

	@Test
	final void testGetElementFromDefectDetectionMatrix() {
		String[][] aux = new String [2][3];
		for(int i = 0; i != aux.length; i++) {
			for(int j = 0; i != aux.length; j++) {

				aux[i][j] = "rule";
			}
		}
		dd.setDefectsCalculated(aux);
		String a = "rule";
		assertEquals(a, dd.getElementFromDefectDetectionMatrix(2, 3));
	}

	@Test
	final void testGetDefectsCalculated() {
		String[][] aux = new String [2][3];
		dd.setDefectsCalculated(aux);
		assertEquals(aux, dd.getDefectsCalculated());
	}
	
	@Test
	final void testDefectDetectionForRule() {
		dd.setChosenRule("is_feature_envy");
		dd.defectDetectionForRule();

	}

}