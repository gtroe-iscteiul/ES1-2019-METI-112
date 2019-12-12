package Tests;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Choosing_Consequence_Type;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Creating_Feature_Envy_Condition;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Creating_Long_Method;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rules_Frame;

class GUI_Rule_Frame_Choosing_Consequence_TypeTest {

	private GUI_Rules_Frame GRF;
	private GUI_Operative_Frame GOF;
	private GUI_Rule_Frame_Choosing_Consequence_Type GRFCCT;
	private GUI_Rule_Frame_Creating_Long_Method GRCLM;
	private GUI_Rule_Frame_Creating_Feature_Envy_Condition GRCFE;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		GRF = new GUI_Rules_Frame(GOF);
		GRFCCT = new GUI_Rule_Frame_Choosing_Consequence_Type(GRF);
		//GRCLM = new GUI_Rule_Frame_Creating_Long_Method(GRFCCT);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGUI_Rule_Frame_Choosing_Consequence_Type() {
		assertEquals(GRFCCT, GRFCCT.getGRFCCT());
	}

	@Test
	final void testGetGRFCCT() {
		assertEquals(GRFCCT, GRFCCT.getGRFCCT());
	}

	@Test
	final void testGetGRF() {
		assertEquals(GRF, GRFCCT.getGRF());
	}

	@Test
	final void testGetGRFCLM() {
		assertEquals(GRCLM, GRFCCT.getGRFCLM());
	}

	@Test
	final void testGetGRFCFE() {
		assertEquals(GRCFE, GRFCCT.getGRFCFE());
	}

	@Test
	final void testIsOpenGRFCFE() {
		assertFalse(GRFCCT.isOpenGRFCFE());
	}

	@Test
	final void testSetIsOpenGRFCFE() {
		GRFCCT.setIsOpenGRFCFE(true);
		assertTrue(GRFCCT.isOpenGRFCFE());
		GRFCCT.setIsOpenGRFCFE(false);
		assertFalse(GRFCCT.isOpenGRFCFE());
	}

	@Test
	final void testIsOpenGRFCLM() {
		assertFalse(GRFCCT.isOpenGRFCLM());
	}

	@Test
	final void testSetIsOpenGRFCLM() {
		GRFCCT.setIsOpenGRFCLM(true);
		assertTrue(GRFCCT.isOpenGRFCLM());
		GRFCCT.setIsOpenGRFCLM(false);
		assertFalse(GRFCCT.isOpenGRFCLM());
	}

	@Test
	final void testOpenFeatureEnvyFrame() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testDealWithAfterFrame() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testCloseRuleConsequenceFrame() {
		GRFCCT.closeRuleConsequenceFrame();
		assertFalse(GRF.isOpenGRFCCT());
	}

}
