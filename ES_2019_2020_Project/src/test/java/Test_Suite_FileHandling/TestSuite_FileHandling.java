package Test_Suite_FileHandling;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ExistsFile_Test.class, GetCellValue_Test.class, GetValueExpected_Test.class, IsEmpty_Test.class,
		NrColumns_test.class, NrLines_Test.class })
public class TestSuite_FileHandling {

}
