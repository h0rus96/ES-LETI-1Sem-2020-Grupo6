/**
 * 
 */
package gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author pedro
 *
 */
class TestGUI {
	
	private static GUI guitest;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		guitest = new GUI();
	}

	/**
	 * Test method for {@link gui.GUI#main(java.lang.String[])}.
	 */
	@Test
	void testMain() {
		guitest.main(null);
		assertNotNull(guitest);
	}

	/**
	 * Test method for {@link gui.GUI#GUI()}.
	 */
	@Test
	void testGUI() {
		guitest = new GUI();
		assertNotNull(guitest);
	}

}
