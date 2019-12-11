package Tests;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;

@RunWith(JUnitPlatform.class)
@SelectClasses({AccessToRuleDatabaseTest.class, FileHandlingTest.class, 
	GUI_Defect_DetectionTest.class, GUI_Main_ClassTest.class, 
	GUI_Operative_FrameTest.class, GUI_Rule_Frame_Creating_ConditionTest.class,
	GUI_Rule_Frame_Creating_ConsequenceTest.class, GUI_Rules_FrameTest.class,
	MethodDefinitionTest.class})

public class AllTests {
}