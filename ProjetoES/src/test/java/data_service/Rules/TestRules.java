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
	 * Test method for {@link data_service.Rules.Rules#longMethod(int, int, int, int, boolean)}.
	 */
	@Test
	void testLongMethodANDTwoArgumentsHigh() {
		boolean result = r.longMethod(10, 10, 5, 5, true);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#longMethod(int, int, int, int, boolean)}.
	 */
	@Test
	void testLongMethodANDArgumentOneHigh() {
		boolean result = r.longMethod(10, 10, 15, 5, true);
		assertEquals(false, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#longMethod(int, int, int, int, boolean)}.
	 */
	@Test
	void testLongMethodANDArgumentTwoHigh() {
		boolean result = r.longMethod(10, 10, 5, 15, true);
		assertEquals(false, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#longMethod(int, int, int, int, boolean)}.
	 */
	@Test
	void testLongMethodORTwoArgumentsHigh() {
		boolean result = r.longMethod(10, 10, 5, 5, false);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#longMethod(int, int, int, int, boolean)}.
	 */
	@Test
	void testLongMethodORArgumentTwoHigh() {
		boolean result = r.longMethod(10, 10, 15, 5, false);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#longMethod(int, int, int, int, boolean)}.
	 */
	@Test
	void testLongMethodORArgumentOneHigh() {
		boolean result = r.longMethod(10, 10, 5, 15, false);
		assertEquals(true, result);
	}	
	
	/**
	 * Test method for {@link data_service.Rules.Rules#longMethod(int, int, int, int, boolean)}.
	 */
	@Test
	void testLongMethodORTwoArgumentsLow() {
		boolean result = r.longMethod(10, 10, 15, 15, false);
		assertEquals(false, result);
	}
	
	
	/**
	 * Test method for {@link data_service.Rules.Rules#featureEnvy(int, double, int, double, boolean)}.
	 */
	@Test
	void testFeatureEnvyANDTwoArgumentsHigh() {
		boolean result = r.featureEnvy(10, 10, 5, 5, true);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#featureEnvy(int, double, int, double, boolean)}.
	 */
	@Test
	void testFeatureEnvyANDArgumentOneHigh() {
		boolean result = r.featureEnvy(10, 10, 15, 5, true);
		assertEquals(false, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#featureEnvy(int, double, int, double, boolean)}.
	 */
	@Test
	void testFeatureEnvyANDArgumentTwoHigh() {
		boolean result = r.featureEnvy(10, 10, 5, 15, true);
		assertEquals(false, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#featureEnvy(int, double, int, double, boolean)}.
	 */
	@Test
	void testFeatureEnvyORTwoArgumentsHigh() {
		boolean result = r.featureEnvy(10, 10, 5, 5, false);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#featureEnvy(int, double, int, double, boolean)}.
	 */
	@Test
	void testFeatureEnvyORArgumentTwoHigh() {
		boolean result = r.featureEnvy(10, 10, 15, 5, false);
		assertEquals(true, result);
	}
	
	/**
	 * Test method for {@link data_service.Rules.Rules#featureEnvy(int, double, int, double, boolean)}.
	 */
	@Test
	void testFeatureEnvyORArgumentOneHigh() {
		boolean result = r.featureEnvy(10, 10, 5, 15, false);
		assertEquals(true, result);
	}	
	
	/**
	 * Test method for {@link data_service.Rules.Rules#featureEnvy(int, double, int, double, boolean)}.
	 */
	@Test
	void testFeatureEnvyORTwoArgumentsLow() {
		boolean result = r.featureEnvy(10, 10, 15, 15, false);
		assertEquals(false, result);
	}
	
	
	
	
	
	

}
