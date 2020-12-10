/**
 * 
 */
package results_table;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author pedro
 *
 */
class TestResultsTable {
	
	private static int[] array = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	private static ResultsTable rt;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		rt = new ResultsTable(array);
	}

	/**
	 * Test method for {@link results_table.ResultsTable#ResultsTable(int[])}.
	 */
	@Test
	void testResultsTable() {
		rt = new ResultsTable(array);
		assertNotNull(rt);
	}

	/**
	 * Test method for {@link results_table.ResultsTable#buildTable()}.
	 */
	@Test
	void testBuildTable() {
		rt.buildTable();
		assertNotNull(rt);
	}

}
