package data_service.CodeSmells;

import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;
/**
* SourceCode is an object to identify and specify the parameters of the piece of code were studying.
* 
* 
* @author jffss-iscte
* 
*/
public class SourceCode {
	
	/**
	 * The ID of the method that represents the Source Code.
	 */
	
	private int MethodID;
	
	/**
	 * The name of the package that includes the Source Code.
	 */
	
	private String pkg;//package
	
	/**
	 * The name of the class that includes the Source Code.
	 */
	
	private String clss;//class
	
	/**
	 * The name of the method that represents the Source Code.
	 */
	
	private String method;
	
	/**
	 * The number of lines in the Source Code.
	 */
	
	private int LOC;
	
	/**
	 * The cyclomatic complexity in the Source Code.
	 */
	
	private int CYClO;
	
	/**
	 * The Access To Foreign Data in the Source Code.
	 */
	
	private int ATFD;
	
	/**
	 * The Locality of Attribute Accesses in the Source Code.
	 */
	
	private Cell LAA;
	
	/**
	 * The relative number of local attributes versus foreign attributes in the Source Code.
	 */

	private Cell is_long_method;
	
	/**
	 * A tool to analyze the metrics of the Source Code.
	 */
	private Cell iPlasma;
	
	/**
	 * A tool to analyze the metrics of the Source Code.
	 */
	
	private Cell PMD;
	
	/**
	 * The results to see if the Source Code is a feature envy or not.
	 */

	private Cell is_feature_envy;
	
	/**
	 * The results to see if the Source Code is a long method or not by our thresholds.
	 */
	
	private boolean is_long_method_th;
	
	/**
	 * The results to see if the Source Code is a feature envy or not by our thresholds.
	 */
	
	private boolean is_feature_envy_th;
	
	public SourceCode() {
		this.is_long_method_th=false;
		this.is_feature_envy_th=false;
	}
	
	
	/**
	 * <p>Gets the id number of the Source Code.
	 * </p>
	 * @return the id number of the method.
	 *
	 */
	public int getMethodID() {
		return MethodID;
	}
	
	/**
	 * <p>Changes/sets the value of the id number of the Source Code.
	 * </p>
	 * @param id number of the method.
	 *
	 */
	
	public void setMethodID(int methodId) {
		MethodID = methodId;
	}
	
	/**
	 * <p>Gets the name of the package in the Source Code.
	 * </p>
	 * @return the name of the package in the Source Code.
	 *
	 */
	
	public String getPkg() {
		return pkg;
	}
	
	/**
	 * <p>Changes/sets the name of the package of the Source Code.
	 * </p>
	 * @param id number of the method.
	 *
	 */
	
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}

	/**
	 * <p>Gets the name of the class in the Source Code.
	 * </p>
	 * @return name of the class in the Source Code.
	 *
	 */
	public String getClss() {
		return clss;
	}
	
	/**
	 * <p>Changes/sets the name of the class of the Source Code.
	 * </p>
	 * @param name of the class.
	 *
	 */
	
	public void setClss(String clss) {
		this.clss = clss;
	}
	
	/**
	 * <p>Gets the name of the method in the Source Code.
	 * </p>
	 * @return name of the method in the Source Code.
	 *
	 */
	
	public String getMethod() {
		return method;
	}
	
	/**
	 * <p>Changes/sets the name of the method of the Source Code.
	 * </p>
	 * @param name of the method.
	 *
	 */
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	/**
	 * <p>Gets the number of lines of code in the Source Code.
	 * </p>
	 * @return the number of lines in the Source Code.
	 *
	 */
	
	public int getLOC() {
		return LOC;
	}
	
	/**
	 * <p>Changes/sets the number of lines of code in the Source Code.
	 * </p>
	 * @param line of code.
	 *
	 */
	
	public void setLOC(int lOC) {
		LOC = lOC;
	}
	
	/**
	 * <p>Gets the number of the cyclomatic complexity in the Source Code.
	 * </p>
	 * @return the number of the cyclomatic complexity in the Source Code.
	 *
	 */
	
	public int getCYCLO() {
		return CYClO;
	}
	
	/**
	 * <p>Changes/sets the number of the cyclomatic complexity of code in the Source Code.
	 * </p>
	 * @param cyclomatic complexity.
	 *
	 */
	
	public void setCYCLO(int cYClO) {
		CYClO = cYClO;
	}
	
	/**
	 * <p>Gets the number of attributes from unrelated classes that are accessed directly or through accessor methods in the Source Code.
	 * </p>
	 * @return the number of attributes from unrelated classes that are accessed directly or through accessor methods in the Source Code.
	 *
	 */
	
	public int getATFD() {
		return ATFD;
	}
	
	/**
	 * <p>Changes/sets the number of attributes from unrelated classes that are accessed directly or through accessor methods in the Source Code.
	 * </p>
	 * @param the number of attributes from unrelated classes that are accessed directly or through accessor methods.
	 *
	 */
	
	public void setATFD(int aTFD) {
		ATFD = aTFD;
	}
	
	/**
	 * <p>Gets the relative number of local attributes versus foreign attributes in the Source Code.
	 * </p>
	 * @return the relative number of local attributes versus foreign attributes in the Source Code.
	 *
	 */
	
	public double getLAA() {
		double laa=0;	
		if(LAA.getCellType()==0) {
				laa=LAA.getNumericCellValue();
			}else {
				laa=Double.parseDouble(LAA.getStringCellValue());
			}
		return laa;
	}
	
	/**
	 * <p>Changes/sets the relative number of local attributes versus foreign attributes in the Source Code.
	 * </p>
	 * @param the relative number of local attributes versus foreign attributes.
	 *
	 */
	
	
	public void setLAA(Cell cell) {
		LAA = cell;
	}
	
	/**
     * Determine whether this Source Code is a long method or not.
     * @return <CODE>true</CODE> if the container is a long method
     * , <CODE>false</CODE> 
     * otherwise
     */
	
	public boolean getIs_long_method() {
		return is_long_method.getBooleanCellValue();
	}
	
	/**
	 * <p>Changes/sets whether this Source Code is a long method or not.
	 * </p>
	 * @param  <CODE>true</CODE> if the container is a long method
     * , <CODE>false</CODE> 
     * otherwise
	 */
	
	public void setIs_long_method(Cell is_long_method) {
		this.is_long_method = is_long_method;
	}
	
	/**
     * Determine whether this Source Code is a long method or not by iPlasma parameters.
     * @return <CODE>true</CODE> if the container is a long method
     * , <CODE>false</CODE> 
     * otherwise
     */
	
	public boolean getiPlasma() {
		return iPlasma.getBooleanCellValue();
	}
	
	/**
	 * <p>Changes/sets whether this Source Code is a long method or not by iPlasma standards.
	 * </p>
	 * @param  <CODE>true</CODE> if the container is a long method
     * , <CODE>false</CODE> 
     * otherwise
	 */
	
	public void setiPlasma(Cell iPlasma) {
		this.iPlasma = iPlasma;
	}
	
	/**
     * Determine whether this Source Code is a long method or not by PMD parameters.
     * @return <CODE>true</CODE> if the container is a long method
     * , <CODE>false</CODE> 
     * otherwise
     */
	
	public boolean getPMD() {
		return PMD.getBooleanCellValue();
	}
	
	/**
	 * <p>Changes/sets whether this Source Code is a long method or not by PMD standards.
	 * </p>
	 * @param  <CODE>true</CODE> if the container is a long method
     * , <CODE>false</CODE> 
     * otherwise
	 */
	
	public void setPMD(Cell pMD) {
		PMD = pMD;
	}
	
	/**
     * Determine whether this Source Code is a feature envy or not.
     * @return <CODE>true</CODE> if the container is a feature envy
     * , <CODE>false</CODE> 
     * otherwise
     */
	
	public boolean getIs_featue_envy() {
		return is_feature_envy.getBooleanCellValue();
	}
	
	/**
	 * <p>Changes/sets whether this Source Code is a feature envy or not .
	 * </p>
	 * @param  <CODE>true</CODE> if the container is a long method
     * , <CODE>false</CODE> 
     * otherwise
	 */
	
	public void setIs_featue_envy(Cell is_featue_envy) {
		this.is_feature_envy = is_featue_envy;
	}
	
	/**
     * Determine whether this Source Code is a long method or not by our thresholds parameters.
     * @return <CODE>true</CODE> if the container is a long method
     * , <CODE>false</CODE> 
     * otherwise
     */
	
	public boolean getIs_long_method_th() {
		return is_long_method_th;
	}
	
	/**
	 * <p>Changes/sets whether this Source Code is a long method or not by our thresholds parameters.
	 * </p>
	 * @param  <CODE>true</CODE> if the container is a long method
     * , <CODE>false</CODE> 
     * otherwise
	 */
	
	public void setIs_long_method_th(boolean is_long_method_th) {
		this.is_long_method_th = is_long_method_th;
	}
	
	/**
     * Determine whether this Source Code is a long method or not.
     * @return <CODE>true</CODE> if the container is a long method
     * , <CODE>false</CODE> 
     * otherwise
     */
	
	public boolean getIs_feature_envy_th() {
		return is_feature_envy_th;
	}
	
	/**
	 * <p>Changes/sets whether this Source Code is a feature envy or not by our thresholds parameters.
	 * </p>
	 * @param  <CODE>true</CODE> if the container is a feature envy
     * , <CODE>false</CODE> 
     * otherwise
	 */
	
	public void setIs_feature_envy_th(boolean is_feature_envy_th) {
		this.is_feature_envy_th = is_feature_envy_th;
	}
	
	/**
	 * <p>Gets a String with all class parameters.
	 * </p>
	 * @return the Source Code in a String format.
	 *
	 */
	
	
	public String toString() {
		return MethodID+" "+pkg+" "+clss+" "+method+" "+LOC+" "+CYClO+" "+ATFD+" "+LAA+" "+is_long_method+" "+iPlasma+" "+PMD+" "+is_feature_envy+" "+is_long_method_th+" "+is_feature_envy_th;
	}
	
}
