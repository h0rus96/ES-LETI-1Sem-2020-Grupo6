/**
 * 
 */
package data_service.CodeSmells;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author ES-LETI-1Sem-2020-Grupo6
 *
 */
class TestSourceCode {
	private static SourceCode sourceCodeTest;
	private static Cell cellNumeric;
	private static Cell cellBoolean;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sourceCodeTest = new SourceCode();
		startCells();
	}

	private static void startCells() {
		try {
			File file = new File("testFiles/testWorkBook.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook testWorkBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = testWorkBook.getSheetAt(0);
			Row row = sheet.getRow(0);
			cellNumeric = row.getCell(0);
			cellBoolean = row.getCell(2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getMethodID()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setMethodID(int)}.
	 */
	@Test
	void testGetSetMethodID() {
		sourceCodeTest.setMethodID(0);
		assertEquals(0, sourceCodeTest.getMethodID());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getPkg()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setPkg(java.lang.String)}.
	 */
	@Test
	void testGetSetPkg() {
		sourceCodeTest.setPkg("Test");
		assertEquals("Test", sourceCodeTest.getPkg());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getClss()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setClss(java.lang.String)}.
	 */
	@Test
	void testGetSetClss() {
		sourceCodeTest.setClss("Test");
		assertEquals("Test", sourceCodeTest.getClss());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getMethod()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setMethod(java.lang.String)}.
	 */
	@Test
	void testGetSetMethod() {
		sourceCodeTest.setMethod("Test");
		assertEquals("Test", sourceCodeTest.getMethod());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getLOC()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setLOC(int)}.
	 */
	@Test
	void testGetSetLOC() {
		sourceCodeTest.setLOC(0);
		assertEquals(0, sourceCodeTest.getLOC());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getCYCLO()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setCYCLO(int)}.
	 */
	@Test
	void testGetSetCYCLO() {
		sourceCodeTest.setCYCLO(0);
		assertEquals(0, sourceCodeTest.getCYCLO());
	}
	

	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getATFD()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setATFD(int)}.
	 */
	@Test
	void testGetSetATFD() {
		sourceCodeTest.setATFD(0);
		assertEquals(0, sourceCodeTest.getATFD());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getLAA()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setLAA(org.apache.poi.ss.usermodel.Cell)}.
	 */
	@Test
	void testGetSetLAAType0() {
		sourceCodeTest.setLAA(cellNumeric);
		assertEquals(0,(int) sourceCodeTest.getLAA());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getIs_long_method()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setIs_long_method(org.apache.poi.ss.usermodel.Cell)}.
	 */
	@Test
	void testGetSetIs_long_method() {
		sourceCodeTest.setIs_long_method(cellBoolean);
		boolean f = false;
		assertEquals(f, sourceCodeTest.getIs_long_method());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getiPlasma()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setiPlasma(org.apache.poi.ss.usermodel.Cell)}.
	 */
	@Test
	void testGetSetiPlasma() {
		sourceCodeTest.setiPlasma(cellBoolean);
		boolean f = false;
		assertEquals(f, sourceCodeTest.getiPlasma());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getPMD()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setPMD(org.apache.poi.ss.usermodel.Cell)}.
	 */
	@Test
	void testGetSetPMD() {
		sourceCodeTest.setPMD(cellBoolean);
		boolean f = false;
		assertEquals(f, sourceCodeTest.getPMD());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getIs_featue_envy()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setIs_featue_envy(org.apache.poi.ss.usermodel.Cell)}.
	 */
	@Test
	void testGetSetIs_featue_envy() {
		sourceCodeTest.setIs_featue_envy(cellBoolean);
		boolean f = false;
		assertEquals(f, sourceCodeTest.getIs_featue_envy());
	}
	
	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getIs_feature_envy_th()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setIs_feature_envy_th(boolean)}.
	 */
	@Test
	void testGetSetIs_feature_envy_th() {
		sourceCodeTest.setIs_feature_envy_th(true);
		boolean f = true;
		assertEquals(f, sourceCodeTest.getIs_feature_envy_th());
	}
	
	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#getIs_long_method_th()}.
	 * Test method for {@link data_service.CodeSmells.SourceCode#setIs_long_method_th(boolean)}.
	 */
	@Test
	void testGetSetIs_long_method_th() {
		sourceCodeTest.setIs_long_method_th(true);
		boolean f = true;
		assertEquals(f, sourceCodeTest.getIs_long_method_th());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.SourceCode#toString()}.
	 */
	@Test
	void testToString() {
		System.out.println(sourceCodeTest.toString());
		assertEquals("0 null Test null 0 0 0 0.0 null null null null false true", sourceCodeTest.toString());
	}

}
