package data_service.CodeSmells;

public class QualityIndicators {

	public static void main(String[] args) {
		
		QualityIndicators ins = new QualityIndicators();
		//System.out.println(ins.analyseQI(sc));
	}
	
	public int[] analyseQI(SourceCode[] sc){
		int[] qi = new int[12];
		for(int i=0; i<sc.length; i++){
			if(sc[i].getiPlasma() == true && sc[i].getIs_long_method() == true){
				qi[0]++;
			}
			if(sc[i].getiPlasma() == true && sc[i].getIs_long_method() == false){
				qi[1]++;
			}
			if(sc[i].getiPlasma() == false && sc[i].getIs_long_method() == false){
				qi[2]++;
			}
			if(sc[i].getiPlasma() == false && sc[i].getIs_long_method() == true){
				qi[3]++;
			}
			if(sc[i].getPMD() == true && sc[i].getIs_long_method() == true){
				qi[4]++;
			}
			if(sc[i].getPMD() == true && sc[i].getIs_long_method() == false){
				qi[5]++;
			}
			if(sc[i].getPMD() == false && sc[i].getIs_long_method() == false){
				qi[6]++;
			}
			if(sc[i].getPMD() == false && sc[i].getIs_long_method() == true){
				qi[7]++;
			}
		
		}
		return qi;
	}
	
}