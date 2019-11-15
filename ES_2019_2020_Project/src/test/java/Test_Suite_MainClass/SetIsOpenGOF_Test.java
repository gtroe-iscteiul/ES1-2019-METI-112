package Test_Suite_MainClass;

import org.junit.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import junit.framework.TestCase;

public class SetIsOpenGOF_Test extends TestCase{

	@Test
	public void test_SetIsOpenGOF(){
		GUI_Main_Class mc = new GUI_Main_Class();
		mc.setIsOpenGOF(true);
		
		boolean condition = mc.getIsOpenGOF();
		
		assertTrue(condition);
	}

}
