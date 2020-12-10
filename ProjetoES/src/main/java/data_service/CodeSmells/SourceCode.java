package data_service.CodeSmells;

import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;

public class SourceCode {
	private int MethodID;
	private String pkg;//package
	private String clss;//class
	private String method;
	private int LOC;
	private int CYClO;
	private int ATFD;
	
	private Cell LAA;
	private Cell is_long_method;
	private Cell iPlasma;
	private Cell PMD;
	private Cell is_feature_envy;
	
	private boolean is_long_method_th;
	private boolean is_feature_envy_th;
	
	public SourceCode() {
		this.is_long_method_th=false;
		this.is_feature_envy_th=false;
	}
	public int getMethodID() {
		return MethodID;
	}
	public void setMethodID(int methodId) {
		MethodID = methodId;
	}
	
	
	public String getPkg() {
		return pkg;
	}
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	public String getClss() {
		return clss;
	}
	public void setClss(String clss) {
		this.clss = clss;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getLOC() {
		return LOC;
	}
	public void setLOC(int lOC) {
		LOC = lOC;
	}
	public int getCYCLO() {
		return CYClO;
	}
	public void setCYCLO(int cYClO) {
		CYClO = cYClO;
	}
	public int getATFD() {
		return ATFD;
	}
	public void setATFD(int aTFD) {
		ATFD = aTFD;
	}
	public double getLAA() {
		double laa=0;	
		if(LAA.getCellType()==0) {
				laa=LAA.getNumericCellValue();
			}else {
				laa=Double.parseDouble(LAA.getStringCellValue());
			}
		return laa;
	}
	public void setLAA(Cell cell) {
		LAA = cell;
	}
	
	public boolean getIs_long_method() {
		return is_long_method.getBooleanCellValue();
	}
	public void setIs_long_method(Cell is_long_method) {
		this.is_long_method = is_long_method;
	}
	public boolean getiPlasma() {
		return iPlasma.getBooleanCellValue();
	}
	public void setiPlasma(Cell iPlasma) {
		this.iPlasma = iPlasma;
	}
	public boolean getPMD() {
		return PMD.getBooleanCellValue();
	}
	public void setPMD(Cell pMD) {
		PMD = pMD;
	}
	public boolean getIs_featue_envy() {
		return is_feature_envy.getBooleanCellValue();
	}
	public void setIs_featue_envy(Cell is_featue_envy) {
		this.is_feature_envy = is_featue_envy;
	}
	
	public boolean getIs_long_method_th() {
		return is_long_method_th;
	}
	public void setIs_long_method_th(boolean th) {
		this.is_long_method_th = th;
	}
	public boolean getIs_feature_envy_th() {
		return is_feature_envy_th;
	}
	public void setIs_feature_envy_th(boolean th) {
		this.is_feature_envy_th = th;
	}
	public String toString() {
		return MethodID+" "+pkg+" "+clss+" "+method+" "+LOC+" "+CYClO+" "+ATFD+" "+LAA+" "+is_long_method+" "+iPlasma+" "+PMD+" "+is_feature_envy;
	}
	
}
