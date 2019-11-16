package Test_Suite_OperativeFrame;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GetGMC_Test.class, SetATFD_Test.class, SetCYCLO_Test.class, SetIsOpenGJT_Test.class,
		SetIsOpenGTF_Test.class, SetLAA_Test.class, SetLOC_Test.class })
public class TestSuite_GUI_Operative_Frame {

}
