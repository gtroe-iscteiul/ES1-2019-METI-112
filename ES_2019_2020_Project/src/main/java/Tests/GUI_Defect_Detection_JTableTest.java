package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Defect_Detection;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Defect_Detection_JTable;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;

class GUI_Defect_Detection_JTableTest {
	
	private GUI_Defect_Detection_JTable GDDJT;
	private GUI_Defect_Detection GDD;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		GDD = new GUI_Defect_Detection(new GUI_Operative_Frame(new GUI_Main_Class()));
		GDDJT = new GUI_Defect_Detection_JTable(GDD);
	}

//	@Test
//	void testGUI_Defect_Detection_JTable() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetGDD() {
		GUI_Defect_Detection gdd = new GUI_Defect_Detection(
				new GUI_Operative_Frame(new GUI_Main_Class()));
		assertEquals(null, GDDJT.getGDD());
	}

	@Test
	void testGetIsOpenGDDQI() {
		assertFalse(GDDJT.getIsOpenGDDQI());
	}

	@Test
	void testSetIsOpenGDDQI() {
		GDDJT = new GUI_Defect_Detection_JTable(GDD);
		GDDJT.setIsOpenGDDQI(true);
		boolean condition = GDDJT.getIsOpenGDDQI();
		assertTrue(condition);
		assertFalse(condition);
	}

	@Test
	void testGetTool() {
		assertEquals(null, GDDJT.getTool());
	}

	@Test
	void testSetTool() {
		GDDJT.setTool("tool");
		assertEquals("tool", GDDJT.getTool());
	}

	@Test
	void testCloseFrame() {
		GDDJT.closeFrame();
		assertFalse(GDDJT.getIsOpenGDDQI());
	}

}
