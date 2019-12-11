package Testes;

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
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rules_Frame;
import class_to_be_based_on.GUI_Rule_Frame_Creating_Condition;
import class_to_be_based_on.GUI_Rule_Frame_Creating_Consequence;
import class_to_be_based_on.GUI_Rule_Frame_Creating_Final_Result;

class GUI_Rule_Frame_Creating_ConsequenceTest {
	
	private GUI_Rule_Frame_Creating_Consequence rf_consequence;
	private GUI_Rule_Frame_Creating_Condition rf_condition;
	private GUI_Rules_Frame rf;
	private GUI_Operative_Frame op;
	private GUI_Main_Class main_class;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		main_class = new GUI_Main_Class ();
		op = new GUI_Operative_Frame(main_class);
		rf = new GUI_Rules_Frame (op);
		rf_condition = new GUI_Rule_Frame_Creating_Condition(rf);
		rf_consequence = new GUI_Rule_Frame_Creating_Consequence(rf_condition);
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
		assertEquals(rf_condition, rf_consequence.getGRFCcondition());
	}

	@Test
	final void testIsOpenGRFCFR() {
		assertFalse(rf_consequence.isOpenGRFCFR());
	}

	@Test
	final void testSetIsOpenGRFCFR() {
		rf_consequence.setIsOpenGRFCFR(true);
		assertTrue(rf_consequence.isOpenGRFCFR());
	}

	@Test
	final void testGetGRFCFR() {
		assertEquals(null, rf_consequence.getGRFCFR());
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
