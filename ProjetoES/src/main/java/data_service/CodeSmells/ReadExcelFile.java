package data_service.CodeSmells;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class ReadExcelFile 
{  

	/**
	 * File of the excel file.
	 */
	
	private File file;
	
	/**
	 * Input for the workbook.
	 */
	
	private FileInputStream fis;
	
	/**
	 * Workbook of the excel.
	 */
	
	private XSSFWorkbook wb;
	
	/**
	 * Sheet of the excel file.
	 */
	
	private XSSFSheet sheet;
	
	/**
	 * Row of the excel file.
	 */
	
	private Row row;
	
	/**
	 * Number of rows.
	 */
	
	private int rowCount;
	
	/**
	 * Array of Source Codes.
	 */
	
	private SourceCode[] sc;
	
	/**
	 * Table that have the information of the excel file.
	 */
	
	JTable table;

	public ReadExcelFile() {

		try {
			this.file = new File("testFiles/Defeitos.xlsx");
			this.fis = new FileInputStream(file);
			this.wb = new XSSFWorkbook(fis);
			this.sheet = wb.getSheetAt(0);
			//this.row=sheet.getRow(0);
		} catch (IOException e) {

			e.printStackTrace();
		}
		this.rowCount=sheet.getLastRowNum()+1;

	}

	/**
	 * <p>Put values from the excel file to the array of Source Codes and returns it .
	 * </p>
	 * @return array of Source Codes.
	 *
	 */

	public void setExcelValuesToAnArray() {
		this.rowCount=sheet.getLastRowNum()+1;
		sc=new SourceCode[rowCount-1];
		for(int i=1;i<rowCount;i++) {
			row=sheet.getRow(i);
			SourceCode srcCd=new SourceCode();
			srcCd.setMethodID((int)row.getCell(0).getNumericCellValue());
			srcCd.setPkg(row.getCell(1).getStringCellValue());
			srcCd.setClss(row.getCell(2).getStringCellValue());
			srcCd.setMethod(row.getCell(3).getStringCellValue());
			srcCd.setLOC((int)row.getCell(4).getNumericCellValue());
			srcCd.setCYCLO((int)row.getCell(5).getNumericCellValue());
			srcCd.setATFD((int)row.getCell(6).getNumericCellValue());
			srcCd.setLAA(row.getCell(7));//nao corre o getNumericCellValue() nem getStringCellValue()
			srcCd.setIs_long_method(row.getCell(8));
			srcCd.setiPlasma(row.getCell(9));
			srcCd.setPMD(row.getCell(10));
			srcCd.setIs_featue_envy(row.getCell(11));
			sc[i-1]=srcCd;


		}
	}

	/**
	 * <p>Put values from the array of Source Codes to the table.
	 * </p>
	 * @return The table.
	 *
	 */
	public JTable getTable(JTable jt) {
		String[] cols = {"MethodID", "package", "class", "method", "LOC", "CYCLO", "ATFD", "LAA","is_long_method","iPlasma","PMD","is_feature_envy","is_long_method_TH","is_feature_envy_TH"};
		DefaultTableModel model = new DefaultTableModel(cols, 0);
		jt=new JTable(model);
		for(SourceCode c:sc) {
			int data1 = c.getMethodID();
			String data2 = c.getPkg();
			String data3 = c.getClss();
			String data4 = c.getMethod();
			int data5 = c.getLOC();
			int data6 = c.getCYCLO();
			int data7 = c.getATFD();
			double data8 = c.getLAA();
			boolean data9=c.getIs_long_method();
			boolean data10=c.getiPlasma();
			boolean data11=c.getPMD();
			boolean data12=c.getIs_featue_envy();
			boolean data13=c.getIs_long_method_th();
			boolean data14=c.getIs_feature_envy_th();
			
			Object[] row = {data1, data2, data3, data4, data5, data6, data7, data8,data9,data10,data11,data12,data13,data14};
			model.addRow(row);
		}

		return jt;

	}
	
	/**
	 * <p>Creates the table with the excel values and our thresholds rules.
	 * </p>
	 * 
	 *
	 */
	
	public void createTable(){
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		JFrame frame = new JFrame();
		table = getTable(table);
		panel.add(table);

		JScrollPane js=new JScrollPane(table);
		js.setVisible(true);
		panel.add(js);
		
		frame.add(panel);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	/**
	 * <p>Gets the incomplete array of Source Codes.
	 * </p>
	 * 
	 *@return array of Source Codes without excel values
	 */
	
	public SourceCode[] getSourceCode() {
		return sc;
	}
	
	/**
	 * <p>Updates the array of Source Codes.
	 * </p>
	 * 
	 *@return array of Source Codes without excel values
	 */
	
	public void setSourceCode(SourceCode[] sc) {
		this.sc=sc;
	}
	
	/**
	 * <p>Gets the number of Rows in the excel file.
	 * </p>
	 * 
	 *@return number of rows
	 */
	
	public int getRownCount() {
		return rowCount;
	}

	/**
	 * <p>Gets the excel sheet.
	 * </p>
	 * 
	 *@return Excel sheet
	 */
	
	public XSSFSheet getSheet() {
		return sheet;
	}

	/**
	 * <p>Sets the excel Sheet.
	 * </p>
	 * 
	 *@param excel sheet
	 */
	
	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}


}  
