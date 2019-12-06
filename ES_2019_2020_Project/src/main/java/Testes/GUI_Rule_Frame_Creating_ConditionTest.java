package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Creating_Condition;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rules_Frame;

class GUI_Rule_Frame_Creating_ConditionTest {

	GUI_Rule_Frame_Creating_Condition g;
	GUI_Rules_Frame rf;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		rf = new GUI_Rules_Frame(new GUI_Operative_Frame(new GUI_Main_Class()));
		g = new GUI_Rule_Frame_Creating_Condition(rf);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGUI_Rule_Frame_Creating_Condition() {
		testGetGRF();
	}

	@Test
	void testGetGRF() {
		assertEquals(rf, g.getGRF());
	}

	@Test
	void testIsOpenGRFCconsequence() {
		assertFalse(g.isOpenGRFCconsequence());
	}

	@Test
	void testSetIsOpenGRFCconsequence() {
		g.setIsOpenGRFCconsequence(true);
		assertTrue(g.isOpenGRFCconsequence());
	}

	@Test
	void testGetGRFC_consequence() {
		assertNull(g.getGRFC_consequence());
	}

	@Test
	void testGetCondition() {
		assertNull(g.getCondition());
	}

	@Test
	void testOpenGRFCconsequence() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseRuleConditionFrame() {
		fail("Not yet implemented");
	}

}
