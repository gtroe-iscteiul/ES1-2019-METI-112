package Testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ES1_2019_METI_112.ES_2019_2020_Project.FileHandling;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Main_Class;
import ES1_2019_METI_112.ES_2019_2020_Project.GUI_Operative_Frame;

class GUI_Main_ClassTest {
	
	private GUI_Main_Class mc;
	private FileHandling fh;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		mc = new GUI_Main_Class();
		fh = new FileHandling();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGUI_Main_Class() throws IOException {
		fh.init("Long-Method.xlsx");
		assertEquals(null,mc.getFile());
	}

	@Test
	final void testGetFile() throws IOException {
		fh.init("Long-Method.xlsx");
		assertEquals(null,mc.getFile());
	}

	@Test
	final void testGetGOF() {
		GUI_Operative_Frame GOF = new GUI_Operative_Frame (mc);
		assertEquals(null, mc.getGOF());
	}

	@Test
	final void testGetIsOpenGOF() {
		assertFalse(mc.getIsOpenGOF());
	}

	@Test
	final void testSetIsOpenGOF() {
		mc.setIsOpenGOF(true);
		boolean condition = mc.getIsOpenGOF();
		assertTrue(condition);
	}

	@Test
	final void testMain() {
		fail("Not yet implemented"); // TODO
	}

}