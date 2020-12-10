package data_service.Rules;

import data_service.CodeSmells.SourceCode;

public class Rules {

	private SourceCode sc;

	/**
	 * @author ES-LETI-1Sem-2020-Grupo6
	 *
	 */

	/**
	 * 
	 * @param sc
	 */

	public Rules(SourceCode sc) {
		this.sc = sc;
	}

	/**
	 * Regra longMethod
	 * 
	 * @param LOC
	 * @param CYCLO
	 * @param thresholds1
	 * @param thresholds2
	 * @param operador
	 * @return boolean
	 */

	public boolean longMethod(int LOC, int CYCLO, int thresholds1, int thresholds2, boolean operador) {
		// true=AND
		// false=OR
		if (operador == true) {
			if (LOC > thresholds1 && CYCLO > thresholds2) {
				return true;
			}
			return false;
		}
		if (operador == false) {
			if (LOC > thresholds1 || CYCLO > thresholds2) {
				return true;
			}
			return false;
		}
		sc.setIs_long_method_th(longMethod(LOC, CYCLO, thresholds1, thresholds2, operador));
		return false;
	}

	/**
	 * Regra featureEnvy
	 * 
	 * @param ATFD
	 * @param LAA
	 * @param thresholds3
	 * @param thresholds4
	 * @param operador
	 * @return boolean
	 */

	public boolean featureEnvy(int ATFD, double LAA, int thresholds3, double thresholds4, boolean operador) {
		// true=AND
		// false=OR
		if (operador == true) {
			if (ATFD > thresholds3 && LAA > thresholds4) {
				return true;
			}
			return false;
		}
		if (operador == false) {
			if (ATFD > thresholds3 || LAA > thresholds4) {
				return true;
			}
			return false;
		}
		sc.setIs_feature_envy_th(featureEnvy(ATFD, LAA, thresholds3, thresholds4, operador));
		return false;
	}

}

//		if(LOC>80 && CYCLO>10) {
//			return true;
//		}
//			return false;

//	public boolean featureEnvy(int ATFD, int LAA, int NOFA) {
//		if((ATFD>4 && LAA<0.428571) || (ATFD>4 && LAA>0.428571 && NOFA>6)) {
//			return true;
//		}
//		return false;
//	}

//Feature Envy
//( ACCESS TO FOREIGN DATA (ATFD) > 4
//AND
//LOCALITY OF ATTRIBUTE ACCESSES (LAA) < 0.428571 )
//OR
//( ACCESS TO FOREIGN DATA (ATFD) > 4
//AND
//LOCALITY OF ATTRIBUTE ACCESSES (LAA) > 0.428571
//AND
//NUMBER OF FINAL ATTRIBUTES (NOFA) > 6 )

//para o log-method é criar um metodo que recebe como argumentos (o int LOC, 
//o int CYCLO e os treshholds para ser considerado codesmell) e se os 
//valores das metricas for maior que os treshholds retornar true.

//o metodo tem de conseguir lidar com o facto que a regra pode ser 
//'LOC AND CYCLO', 'LOC OR CYCLO' ou pode só ter um dos valores dados, 
//logo provavelmente precisas de mais um argumento para saber se é para 
//aplicar o operador 'AND' ou 'OR'.