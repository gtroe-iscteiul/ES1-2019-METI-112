package Tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Defect_Detection;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Defect_Detection_Rule;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;

class GUI_Defect_Detection_RuleTest {
	
	private GUI_Defect_Detection_Rule r;
	private GUI_Defect_Detection d;
	private GUI_Operative_Frame op;
	private GUI_Main_Class mc;

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
		d = new GUI_Defect_Detection(op);
		r = new GUI_Defect_Detection_Rule(d);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGUI_Defect_Detection_Rule() {
		testCloseFrame();
	}

	@Test
	final void testCloseFrame() {
		r.closeFrame();
		assertFalse(d.isOpenGDDR());
	
	}

}
