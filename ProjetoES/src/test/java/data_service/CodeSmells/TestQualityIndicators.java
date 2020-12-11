/**
 * 
 */
package data_service.CodeSmells;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author ES-LETI-1Sem-2020-Grupo6
 *
 */
class TestQualityIndicators {
	
	private static SourceCode[] sctest;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		try {
			ReadExcelFile ref = new ReadExcelFile();
			File file = new File("testFiles/testQualityIndicators.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook testWorkBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = testWorkBook.getSheetAt(0);		
			ref.setSheet(sheet);		
			ref.setExcelValuesToAnArray();
			sctest = ref.getSourceCode();
			sctest[0].setIs_feature_envy_th(true);
			sctest[0].setIs_long_method_th(true);
			sctest[3].setIs_feature_envy_th(true);
			sctest[3].setIs_long_method_th(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link data_service.CodeSmells.QualityIndicators#analyseQI(data_service.CodeSmells.SourceCode[])}.
	 */
	@Test
	void testAnalyseQI() {
		int[] expectedresults = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		QualityIndicators qi = new QualityIndicators();
		int[] actualresults = qi.analyseQI(sctest);
		assertArrayEquals(expectedresults, actualresults);
	}

}
