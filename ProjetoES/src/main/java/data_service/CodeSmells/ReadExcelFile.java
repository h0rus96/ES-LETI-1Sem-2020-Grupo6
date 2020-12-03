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

	private File file;
	private FileInputStream fis;
	private XSSFWorkbook wb;
	private XSSFSheet sheet;
	private Row row;
	private int rowCount;
	private SourceCode[] sc;
	JTable table;

	public ReadExcelFile() {

		try {
			this.file = new FindFile("Defeitos.xlsx", new File("C:/"), 6).find();
			this.fis = new FileInputStream(file);
			this.wb = new XSSFWorkbook(fis);
			this.sheet = wb.getSheetAt(0);
			//this.row=sheet.getRow(0);
		} catch (IOException e) {

			e.printStackTrace();
		}
		this.rowCount=sheet.getLastRowNum()+1;

	}

	public int getRownCount() {
		return rowCount;
	}
	
	public SourceCode[] getSourceCode() {
		return sc;
	}

	public SourceCode[] getExcelValuesToAnArray() {
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
		return sc;
	}

	public XSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}  

	public JTable getTable(JTable jt) {
		String[] cols = {"MethodID", "package", "class", "method", "LOC", "CYCLO", "ATFD", "LAA","is_long_method","iPlasma","PMD","is_feature_envy"};
		DefaultTableModel model = new DefaultTableModel(cols, 0);
		jt=new JTable(model);
		for(SourceCode c:getExcelValuesToAnArray()) {
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

			Object[] row = {data1, data2, data3, data4, data5, data6, data7, data8,data9,data10,data11,data12};
			model.addRow(row);
		}

		return jt;

	}
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	public static void main(String[] args)   
	{  

		ReadExcelFile ref=new ReadExcelFile();
		//SourceCode[] sca=ref.getExcelValuesToAnArray();
		//		for(int i=0;i<ref.getRownCount()-1;i++) {
		//			System.out.println(sca[i].toString());
		//		}
		//		System.out.println(sca[16].getIs_featue_envy());
		ref.createTable();
	}



}  
