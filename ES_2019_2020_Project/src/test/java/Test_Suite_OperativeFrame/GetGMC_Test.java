package Test_Suite_OperativeFrame;

import org.junit.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;
import junit.framework.TestCase;

public class GetGMC_Test extends TestCase {

	@Test
	public void test_getGMC() {
		GUI_Main_Class mc = new GUI_Main_Class();
		GUI_Operative_Frame of = new GUI_Operative_Frame(mc);
		
		assertEquals(mc, of.getGMC());
	}

}
