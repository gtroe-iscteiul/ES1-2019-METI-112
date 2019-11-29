package Test_Suite_OperativeFrame;

import org.junit.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;
import junit.framework.TestCase;

public class SetCYCLO_Test extends TestCase {

		@Test
		public void test_SetCYCLO() {
			GUI_Operative_Frame of= new GUI_Operative_Frame(new GUI_Main_Class());
			of.getMD().setCYCLO("cyclo");

			String expected_result = "cyclo";
			assertEquals(expected_result, of.getMD().getCYCLO());
		}


	}
