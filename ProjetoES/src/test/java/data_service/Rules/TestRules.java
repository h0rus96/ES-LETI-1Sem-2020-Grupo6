/**
 * 
 */
package data_service.Rules;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author ES-LETI-1Sem-2020-Grupo6
 *
 */
class TestRules {
	
	private static Rules r;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		r = new Rules();
	}

	/**
	 * Test method for {@link data_service.Rules.Rules#longMethodLOC(int, int)}.
	 */
	@Test
	void testlongMethodLOCFirstArgumentHigh() {
		boolean result = r.longMethodLOC(10, 5);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#longMethodLOC(int, int)}.
	 */
	@Test
	void testlongMethodLOCFirstArgumentLow() {
		boolean result = r.longMethodLOC(5, 10);
		assertEquals(false, result);
	}
	
	
	/**
	 * Test method for {@link data_service.Rules.Rules#longMethodCYCLO(int, int)}.
	 */
	@Test
	void testlongMethodCYCLOFirstArgumentHigh() {
		boolean result = r.longMethodCYCLO(10, 5);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#longMethodCYCLO(int, int)}.
	 */
	@Test
	void testlongMethodCYCLOFirstArgumentLow() {
		boolean result = r.longMethodCYCLO(5, 10);
		assertEquals(false, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#featureEnvyATFD(int, int)}.
	 */
	@Test
	void testfeatureEnvyATFDFirstArgumentHigh() {
		boolean result = r.featureEnvyATFD(10, 5);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#featureEnvyATFD(int, int)}.
	 */
	@Test
	void testfeatureEnvyATFDFirstArgumentLow() {
		boolean result = r.featureEnvyATFD(5, 10);
		assertEquals(false, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#featureEnvyLAA(double, double)}.
	 */
	@Test
	void testfeatureEnvyLAAFirstArgumentHigh() {
		boolean result = r.featureEnvyLAA(10, 5);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#featureEnvyLAA(double, double)}.
	 */
	@Test
	void testfeatureEnvyLAAFirstArgumentLow() {
		boolean result = r.featureEnvyLAA(5, 10);
		assertEquals(false, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#ruleAND(boolean, boolean)}.
	 */
	@Test
	void testruleANDTT() {
		boolean result = r.ruleAND(true, true);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#ruleAND(boolean, boolean)}.
	 */
	@Test
	void testruleANDTF() {
		boolean result = r.ruleAND(true, false);
		assertEquals(false, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#ruleAND(boolean, boolean)}.
	 */
	@Test
	void testruleANDFT() {
		boolean result = r.ruleAND(false, true);
		assertEquals(false, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#ruleAND(boolean, boolean)}.
	 */
	@Test
	void testruleANDFF() {
		boolean result = r.ruleAND(false, false);
		assertEquals(false, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#ruleOR(boolean, boolean)}.
	 */
	@Test
	void testruleORTT() {
		boolean result = r.ruleOR(true, true);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#ruleOR(boolean, boolean)}.
	 */
	@Test
	void testruleORTF() {
		boolean result = r.ruleOR(true, false);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#ruleOR(boolean, boolean)}.
	 */
	@Test
	void testruleORFT() {
		boolean result = r.ruleOR(false, true);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#ruleOR(boolean, boolean)}.
	 */
	@Test
	void testruleORFF() {
		boolean result = r.ruleOR(false, false);
		assertEquals(false, result);
	}

}
