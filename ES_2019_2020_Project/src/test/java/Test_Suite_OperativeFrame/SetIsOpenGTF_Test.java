package Test_Suite_OperativeFrame;

import static org.junit.Assert.*;

import org.junit.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;

public class SetIsOpenGTF_Test {

	@Test
	public void test_SetIsOpenGTF() {
		GUI_Operative_Frame of= new GUI_Operative_Frame(new GUI_Main_Class());
		of.setIsOpenGTF(true);
		boolean condition = of.getIsOpenGTF();

		assertTrue(condition);
	}
}
