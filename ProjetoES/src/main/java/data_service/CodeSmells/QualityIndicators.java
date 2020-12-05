package data_service.CodeSmells;

public class QualityIndicators {

	
	
	public int[] analyseQI(SourceCode[] scarray){
		int[] qiarray = new int[12];
		for(int i = 0; i<scarray.length; i++){
			qiarray = qiiPlasma(qiarray, scarray[i]);
			qiarray = qiPMD(qiarray, scarray[i]);
		}
		return qiarray;
	}
	
	private int[] qiiPlasma(int[] qi, SourceCode sc){
		if(sc.getiPlasma() == true && sc.getIs_long_method() == true){
			qi[0]++;
		}
		if(sc.getiPlasma() == true && sc.getIs_long_method() == false){
			qi[1]++;
		}
		if(sc.getiPlasma() == false && sc.getIs_long_method() == false){
			qi[2]++;
		}
		if(sc.getiPlasma() == false && sc.getIs_long_method() == true){
			qi[3]++;
		}
		return qi;
	}
	
	private int[] qiPMD(int[] qi, SourceCode sc){
		if(sc.getPMD() == true && sc.getIs_long_method() == true){
			qi[4]++;
		}
		if(sc.getPMD() == true && sc.getIs_long_method() == false){
			qi[5]++;
		}
		if(sc.getPMD() == false && sc.getIs_long_method() == false){
			qi[6]++;
		}
		if(sc.getPMD() == false && sc.getIs_long_method() == true){
			qi[7]++;
		}
		return qi;
	}
	
}