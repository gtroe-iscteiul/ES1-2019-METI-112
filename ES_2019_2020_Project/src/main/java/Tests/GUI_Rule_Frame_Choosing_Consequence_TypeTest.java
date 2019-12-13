package Tests;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

		GRFCCT.setIsOpenGRFCLM(true);
		GRFCCT.setIsOpenGRFCFE(true);	
		GRFCCT.openFeatureEnvyFrame();
		
		GRFCCT.setIsOpenGRFCLM(false);
		GRFCCT.openFeatureEnvyFrame();
		assertTrue(GRFCCT.isOpenGRFCFE());
	}

	@Test
	final void testDealWithAfterFrame() {
		GRFCCT.openFeatureEnvyFrame();
		GRFCCT.dealWithAfterFrame();
		assertFalse(GRFCCT.isOpenGRFCFE());		
		
		GRFCCT.setIsOpenGRFCLM(true);
		GRFCCT.dealWithAfterFrame();
		assertFalse(GRFCCT.isOpenGRFCLM());
	}

	@Test
	final void testCloseRuleConsequenceFrame() {
		GRFCCT.closeRuleConsequenceFrame();
		assertFalse(GRF.isOpenGRFCCT());
	}
	  
	@Test
	void testGenerateRuleID() {
		Random random = new Random();
		assertNotEquals(random,GRFCCT.generateRuleID());
	}

}