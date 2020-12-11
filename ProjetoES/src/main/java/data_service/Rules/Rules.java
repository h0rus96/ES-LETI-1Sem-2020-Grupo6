package data_service.Rules;

/**
 * @author ES-LETI-1Sem-2020-Grupo6
 *
 */

public class Rules {

	/**
	 * Para a regra LongMethod, avalia o LOC em relação ao threshold, se o LOC for
	 * maior que o th então devolve verdadeiro, se não, devolve falso.
	 * 
	 * @param LOC
	 * @param th1
	 * @return boolean Devolve se é considerado CodeSmell LOC ou não.
	 */
	public boolean longMethodLOC(int LOC, int th1) {
		if (LOC > th1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Para a regra LongMethod, avalia o CYCLO em relação ao threshold, se o CYCLO
	 * for maior que o th então devolve verdadeiro, se não, devolve falso.
	 * 
	 * @param CYCLO
	 * @param th1
	 * @return boolean Devolve se é considerado CodeSmell CYCLO ou não.
	 */
	public boolean longMethodCYCLO(int CYCLO, int th1) {
		if (CYCLO > th1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Para a regra FeatureEnvy, avalia o ATFD em relação ao threshold, se o ATFD
	 * for maior que o th então devolve verdadeiro, se não, devolve falso.
	 * 
	 * @param ATFD
	 * @param th1
	 * @return boolean Devolve se é considerado CodeSmell ATFDs ou não.
	 */
	public boolean featureEnvyATFD(int ATFD, int th1) {
		if (ATFD > th1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Para a regra FeatureEnvy, avalia o LAA em relação ao threshold, se o LAA for
	 * maior que o th então devolve verdadeiro, se não, devolve falso.
	 * 
	 * 
	 * @param LAA
	 * @param th1
	 * @return boolean Devolve se é considerado CodeSmell LAA ou não.
	 */
	public boolean featureEnvyLAA(double LAA, double th1) {
		if (LAA > th1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método utilizado para realizar o operador OR entre dois booleans.
	 * 
	 * @param br1
	 * @param br2
	 * @return boolean AND dos dois parâmetros de entrada.
	 */
	public boolean ruleAND(boolean br1, boolean br2) {
		return (br1 && br2);
	}

	/**
	 * Método utilizado para realizar o operador OR entre dois booleans.
	 * 
	 * @param br1
	 * @param br2
	 * @return boolean OR dos dois parâmetros de entrada.
	 */
	public boolean ruleOR(boolean br1, boolean br2) {
		return (br1 || br2);
	}
}

