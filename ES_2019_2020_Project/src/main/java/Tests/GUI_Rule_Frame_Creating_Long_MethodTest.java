package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Choosing_Consequence_Type;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Creating_Long_Method;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rules_Frame;

class GUI_Rule_Frame_Creating_Long_MethodTest {

	public GUI_Rule_Frame_Creating_Long_Method GRFCLM;
	private GUI_Rule_Frame_Choosing_Consequence_Type GRFCCT;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		GRFCCT = new GUI_Rule_Frame_Choosing_Consequence_Type(new GUI_Rules_Frame(new GUI_Operative_Frame(new GUI_Main_Class())));
		GRFCLM = new GUI_Rule_Frame_Creating_Long_Method(GRFCCT);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGUI_Rule_Frame_Creating_Long_Method() {
		testCloseFrame();
	}

	@Test
	void testCloseFrame() {
		GRFCLM.closeFrame();
		assertFalse(GRFCCT.isOpenGRFCLM());
	}

}
