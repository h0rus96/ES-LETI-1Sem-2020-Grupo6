package data_service.Rules;

public class Rules {
	
	public boolean logMethod(int loc, int cyclo, int thresholds){
		if(loc + cyclo > thresholds) {
			return true;
		}
		return false;
		
	}
	
	
	
	
	

}


//para o log-method é criar um metodo que recebe como argumentos (o int LOC, 
//o int CYCLO e os treshholds para ser considerado codesmell) e se os 
//valores das metricas for maior que os treshholds retornar true.

//o metodo tem de conseguir lidar com o facto que a regra pode ser 
//'LOC AND CYCLO', 'LOC OR CYCLO' ou pode só ter um dos valores dados, 
//logo provavelmente precisas de mais um argumento para saber se é para 
//aplicar o operador 'AND' ou 'OR'.