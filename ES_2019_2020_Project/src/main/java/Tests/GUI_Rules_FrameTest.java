package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Viewing;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rules_Frame;

class GUI_Rules_FrameTest {
	
	private GUI_Operative_Frame op;
	private GUI_Main_Class mc;
	private GUI_Rules_Frame rf;
	private GUI_Rule_Frame_Viewing rf_viewing;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		mc = new GUI_Main_Class();
		op = new GUI_Operative_Frame(mc);
		rf = new GUI_Rules_Frame(op);
		rf_viewing = new GUI_Rule_Frame_Viewing(rf);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGUI_Rules_Frame() {
		testGetGOF();
	}

	@Test
	final void testGetGOF() {
		assertEquals(op,rf.getGOF());
	}

	@Test
	final void testGetGRFCCT() {
		assertNull(rf.getGRFCCT());
	}

	@Test
	final void testGetGUFV() {
		assertEquals(null, rf.getGRFV());
	}

	@Test
	final void testIsOpenGRFC() {
		assertFalse(rf.isOpenGRFCCT());
	}

	@Test
	final void testIsOpenGRFV() {
		assertFalse(rf.isOpenGRFV());
	}

	@Test
	final void testSetIsOpenGRFC() {
		rf.setIsOpenGRFCCT(true);
		assertTrue(rf.isOpenGRFCCT());
	}

	@Test
	final void testSetIsOpenGRFV() {
		rf.setIsOpenGRFV(true);
		assertTrue(rf.isOpenGRFV());
	}

	@Test
	final void testDealWithNewRule() {
		fail("Not yet implemented"); // TODO
	}

}
