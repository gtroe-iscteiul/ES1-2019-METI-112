package Tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;;

@RunWith(JUnitPlatform.class)
@SelectClasses({AccessToRuleDatabaseTest.class, FileHandlingTest.class, GUI_Defect_Detection_RuleTest.class,
	GUI_Defect_DetectionTest.class, GUI_Main_ClassTest.class, GUI_Operative_FrameTest.class, GUI_Rule_Frame_Choosing_Consequence_TypeTest.class,
	GUI_Rule_Frame_Creating_Feature_Envy_ConditionTest.class, GUI_Rule_Frame_Creating_Feature_Envy_ConsequenceTest.class, 
	GUI_Rule_Frame_Creating_Feature_Envy_Final_ResultTest.class, GUI_Rule_Frame_Creating_Long_MethodTest.class, GUI_Rules_FrameTest.class,
	MethodDefinitionTest.class})
public class AllTests {

}
