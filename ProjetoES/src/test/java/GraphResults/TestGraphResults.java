/**
 * 
 */
package GraphResults;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author pedro
 *
 */
class TestGraphResults {
	
	private static GraphResults gr;
	private static int[] array = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		gr = new GraphResults(array);
	}

	/**
	 * Test method for {@link GraphResults.GraphResults#GraphResults(int[])}.
	 */
	@Test
	void testGraphResults() {
		gr = new GraphResults(array);
		assertNotNull(gr);
	}

	/**
	 * Test method for {@link GraphResults.GraphResults#createGraph()}.
	 */
	@Test
	void testCreateGraph() {
		gr.createGraph();
		assertNotNull(gr);
	}

}
