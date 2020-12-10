/**
 * 
 */
package data_service.CodeSmells;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author ES-LETI-1Sem-2020-Grupo6
 *
 */
class TestReadExcelFile {
	
	
	private static File file;
	private static XSSFWorkbook testWorkBook;
	private static XSSFSheet sheet;
	private static ReadExcelFile ref;
	private static SourceCode[] sctest;
	private static int rowcount;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ref = new ReadExcelFile();
		try {		
			file = new File("testFiles/Defeitos.xlsx");
			FileInputStream fis = new FileInputStream(file);
			testWorkBook = new XSSFWorkbook(fis);
			sheet = testWorkBook.getSheetAt(0);
			rowcount = sheet.getLastRowNum()+1;			
			ref.setSheet(sheet);		
			sctest = ref.getExcelValuesToAnArray();
			
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
	 * Test method for {@link data_service.CodeSmells.ReadExcelFile#ReadExcelFile()}.
	 */
	@Test
	void testReadExcelFile() {
		assertNotNull(ref.getRownCount());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.ReadExcelFile#getRownCount()}.
	 */
	@Test
	void testGetRownCount() {	
		assertEquals(rowcount, ref.getRownCount());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.ReadExcelFile#getSheet()}.
	 * Test method for {@link data_service.CodeSmells.ReadExcelFile#setSheet(org.apache.poi.xssf.usermodel.XSSFSheet)}.
	 */
	@Test
	void testGetSetSheet() {
		ref.setSheet(sheet);
		assertEquals(sheet, ref.getSheet());
	}

	/**
	 * Test method for {@link data_service.CodeSmells.ReadExcelFile#createTable()}.
	 */
	@Test
	void testCreateTable() {
		ref.createTable();
		assertNotNull(ref.table);
	}
	
	/**
	 * Test method for {@link data_service.CodeSmells.ReadExcelFile#getSourceCode()}.
	 */
	@Test
	void testGetSourceCode() {
		SourceCode[] result = ref.getSourceCode();
		assertEquals(sctest.length, result.length);
	}

}
