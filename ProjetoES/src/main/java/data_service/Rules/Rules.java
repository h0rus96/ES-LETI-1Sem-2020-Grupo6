package data_service.Rules;

/**
 * @author ES-LETI-1Sem-2020-Grupo6
 *
 */

public class Rules {

	public Rules() {
	}

	public boolean longMethodLOC(int LOC, int th1) {
		if (LOC > th1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean longMethodCYCLO(int CYCLO, int th1) {
		if (CYCLO > th1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean featureEnvyATFD(int ATFD, int th1) {
		if (ATFD > th1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean featureEnvyLAA(double LAA, double th1) {
		if (LAA > th1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ruleAND(boolean br1, boolean br2) {
		return (br1 && br2);
	}

	public boolean ruleOR(boolean br1, boolean br2) {
		return (br1 || br2);
	}
}
//	public boolean longMethod(int LOC, int CYCLO, int thresholds1, int thresholds2, boolean operador) {
//		// true=AND
//		// false=OR
//		if (operador == true) {
//			if (LOC > thresholds1 && CYCLO > thresholds2) {
//				return true;
//			}
//			return false;
//		}
//		if (operador == false) {
//			if (LOC > thresholds1 || CYCLO > thresholds2) {
//				return true;
//			}
//			return false;
//		}
//		return false;
//	}

//	/**
//	 * Regra featureEnvy
//	 * 
//	 * @param ATFD
//	 * @param LAA
//	 * @param thresholds3
//	 * @param thresholds4
//	 * @param operador
//	 * @return
//	 */

//	public boolean featureEnvy(int ATFD, double LAA, int thresholds3, double thresholds4, boolean operador) {
//		// true=AND
//		// false=OR
//		if (operador == true) {
//			if (ATFD > thresholds3 && LAA > thresholds4) {
//				return true;
//			}
//			return false;
//		}
//		if (operador == false) {
//			if (ATFD > thresholds3 || LAA > thresholds4) {
//				return true;
//			}
//			return false;
//		}
//		return false;
//	}
//
//}

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
