package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Choosing_Consequence_Type;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Creating_Feature_Envy_Condition;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Creating_Feature_Envy_Consequence;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rules_Frame;

class GUI_Rule_Frame_Creating_Feature_Envy_ConditionTest {
	
	private GUI_Rule_Frame_Creating_Feature_Envy_Condition g;
	private GUI_Rules_Frame rf;
	private GUI_Rule_Frame_Choosing_Consequence_Type cc;
	private GUI_Rule_Frame_Creating_Feature_Envy_Consequence consequence;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		rf = new GUI_Rules_Frame(new GUI_Operative_Frame(new GUI_Main_Class()));
		cc = new GUI_Rule_Frame_Choosing_Consequence_Type(rf);
		g = new GUI_Rule_Frame_Creating_Feature_Envy_Condition(cc);
		consequence = new GUI_Rule_Frame_Creating_Feature_Envy_Consequence(g);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGUI_Rule_Frame_Creating_Feature_Envy_Condition() {
		assertEquals(cc, g.getGRFCCT());
	}

	@Test
	final void testGetGRFCCT() {
		assertEquals(cc, g.getGRFCCT());
	}

	@Test
	final void testIsOpenGRFCFEC() {
		g.openGRFCFE_consequence();
		assertTrue(g.isOpenGRFCFEC());
	}

	@Test
	final void testSetIsOpenGRFCFEC() {
		g.setIsOpenGRFCFEC(true);
		assertTrue(g.isOpenGRFCFEC());
	}

	@Test
	final void testGetGRFCFEC() {
		//g.openGRFCFE_consequence();
		assertNull(g.getGRFCFEC());
	}

	@Test
	final void testGetCondition() {
		assertNull(g.getCondition());
	}

	@Test
	final void testOpenGRFCFE_consequence() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testCloseFrame() {
		g.closeFrame();
		assertFalse(g.isOpenGRFCFEC());
	}

}