package Tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Defect_Detection;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Defect_Detection_JTable;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Defect_Detection_Quality_Indicators;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;

class GUI_Defect_Detection_Quality_IndicatorsTest {
	
	private GUI_Defect_Detection_Quality_Indicators q;
	private GUI_Defect_Detection_JTable jt;
	private GUI_Defect_Detection dd;
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
		dd = new GUI_Defect_Detection(op);
		jt = new GUI_Defect_Detection_JTable(dd);
		q = new GUI_Defect_Detection_Quality_Indicators(jt);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGUI_Defect_Detection_Quality_Indicators() {
		testCloseFrame();
	}

	@Test
	final void testCloseFrame() {
		q.closeFrame();
		assertFalse(jt.getIsOpenGDDQI());
	}

}