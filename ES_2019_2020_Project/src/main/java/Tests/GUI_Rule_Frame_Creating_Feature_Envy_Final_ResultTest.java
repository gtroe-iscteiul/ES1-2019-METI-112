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
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Creating_Feature_Envy_Condition;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Creating_Feature_Envy_Consequence;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rule_Frame_Creating_Feature_Envy_Final_Result;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Rules_Frame;

class GUI_Rule_Frame_Creating_Feature_Envy_Final_ResultTest {
	
	private GUI_Rule_Frame_Creating_Feature_Envy_Final_Result rf_final;
	private GUI_Rule_Frame_Creating_Feature_Envy_Consequence rf_consequence;
	private GUI_Rule_Frame_Creating_Feature_Envy_Condition rf_condition;
	private GUI_Rule_Frame_Choosing_Consequence_Type rf_type;
	private GUI_Rules_Frame rf;
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
		rf = new GUI_Rules_Frame(op);
		rf_type = new GUI_Rule_Frame_Choosing_Consequence_Type (rf);
		rf_condition = new GUI_Rule_Frame_Creating_Feature_Envy_Condition (rf_type);
		rf_consequence = new GUI_Rule_Frame_Creating_Feature_Envy_Consequence(rf_condition);
		rf_final = new GUI_Rule_Frame_Creating_Feature_Envy_Final_Result (rf_consequence);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGUI_Rule_Frame_Creating_Feature_Envy_Final_Result() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testCloseRuleResultFrame() {
		rf_final.closeRuleResultFrame();
		assertFalse(rf_consequence.isOpenGRFCFEFR());
	}

}