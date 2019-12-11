package Tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

class GUI_Rule_Frame_Creating_ConsequenceTest {
	
	private GUI_Rule_Frame_Creating_Feature_Envy_Consequence rf_consequence;
	private GUI_Rule_Frame_Creating_Feature_Envy_Condition rf_condition;
	private GUI_Rules_Frame rf;
	GUI_Rule_Frame_Choosing_Consequence_Type cc;

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
		rf_condition = new GUI_Rule_Frame_Creating_Feature_Envy_Condition(cc);
		rf_consequence = new GUI_Rule_Frame_Creating_Feature_Envy_Consequence(rf_condition);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGUI_Rule_Frame_Creating_Consequence() {
		testGetGRFCcondition();
	}

	@Test
	final void testGetGRFCcondition() {
		assertEquals(rf_condition, rf_consequence.getGRFCFE());
	}

	@Test
	final void testIsOpenGRFCFR() {
		assertFalse(rf_consequence.isOpenGRFCFEFR());
	}

	@Test
	final void testSetIsOpenGRFCFR() {
		rf_consequence.setIsOpenGRFCFEFR(true);;
		assertTrue(rf_consequence.isOpenGRFCFEFR());
	}

	@Test
	final void testGetGRFCFR() {
		assertEquals(null, rf_consequence.getGRFCFEFR());
	}

	@Test
	final void testGetConsequece() {
		assertEquals(null,rf_consequence.getConsequece());
	}

	@Test
	final void testCloseRuleConsequenceFrame() {
		fail("Not yet implemented"); // TODO
	}

}
