package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Defect_Detection;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_JTable;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rules_Frame;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Thresholds_Frame;
import ES1_2019_METI_112.ES_2019_2020_Project.MethodDefinition;

class GUI_Operative_FrameTest {

	private GUI_Main_Class mc;
	private GUI_Operative_Frame of;
	private GUI_JTable jt;
	private GUI_Thresholds_Frame tf;
	private GUI_Defect_Detection dd;
	private String LOC;
	private String CYCLO;
	private String ATFD;
	private String LAA;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		mc = new GUI_Main_Class();
		of = new GUI_Operative_Frame(new GUI_Main_Class());
		//jt = new GUI_JTable(of);
		LOC = "-1";
		CYCLO = "-1";
		ATFD = "-1";
		LAA = "-1";
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGUI_Operative_Frame() {
		of = new GUI_Operative_Frame(mc);
		assertEquals(mc, of.getGMC());
	}

	@Test
	final void testGetGMC() {
		of = new GUI_Operative_Frame(mc);
		assertEquals(mc, of.getGMC());
	}

	@Test
	final void testGetGJT() {
//		jt = new GUI_JTable(of);
		assertEquals(null, of.getGJT());
	}

	@Test
	final void testGetGTF() {
		//of = new GUI_Operative_Frame(mc);
		tf = new GUI_Thresholds_Frame(of);
		assertEquals(null, of.getGTF());
	}

	@Test
	final void testGetGDD() {
		dd = new GUI_Defect_Detection(of);
		assertEquals(null, of.getGDD());
	}

	@Test
	final void testGetIsOpenGJT() {
		assertFalse(of.getIsOpenGJT());
	}

	@Test
	final void testGetMD() {
		MethodDefinition md = new MethodDefinition (LOC, CYCLO, ATFD, LAA);
		assertEquals(md, of.getMD());
	}

	@Test
	final void testGetGRF() {
		GUI_Rules_Frame grf = new GUI_Rules_Frame(of);
		assertEquals(null, of.getGRF());
	}

	@Test
	final void testSetIsOpenGJT() {
		of = new GUI_Operative_Frame(new GUI_Main_Class());
		of.setIsOpenGJT(true);
		boolean condition = of.getIsOpenGJT();

		assertTrue(condition);
	}

	@Test
	final void testGetIsOpenGTF() {
		assertFalse(of.getIsOpenGTF());
	}

	@Test
	final void testSetIsOpenGTF() {
		of = new GUI_Operative_Frame(new GUI_Main_Class());
		of.setIsOpenGTF(true);
		boolean condition = of.getIsOpenGTF();
		assertTrue(condition);
	}

	@Test
	final void testSetIsOpenGRF() {
		of = new GUI_Operative_Frame(new GUI_Main_Class());
		of.setIsOpenGRF(true);
		boolean condition = of.getIsOpenGRF();
		assertTrue(condition);
	}

	@Test
	final void testGetIsOpenGDD() {
		assertFalse(of.getIsOpenGDD());
	}

	@Test
	final void testSetIsOpenGDD() {
		of = new GUI_Operative_Frame(new GUI_Main_Class());
		of.setIsOpenGDD(true);
		boolean condition = of.getIsOpenGDD();
		assertTrue(condition);
	}

}
