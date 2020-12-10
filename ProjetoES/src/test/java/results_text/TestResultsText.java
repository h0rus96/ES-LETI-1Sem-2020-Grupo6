/**
 * 
 */
package results_text;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import results_table.ResultsTable;

/**
 * @author pedro
 *
 */
class TestResultsText {
	
	private static int[] array = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	private static ResultsText rt;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		rt = new ResultsText(array);
	}

	/**
	 * Test method for {@link results_text.ResultsText#ResultsText(int[])}.
	 */
	@Test
	void testResultsText() {
		rt = new ResultsText(array);
		assertNotNull(rt);
	}

	/**
	 * Test method for {@link results_text.ResultsText#buildTable()}.
	 */
	@Test
	void testBuildTable() {
		rt.buildTable();
		assertNotNull(rt);
	}

}
