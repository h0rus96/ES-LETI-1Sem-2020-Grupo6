package results_table;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ResultsTable {

	private JTable table;
	private JPanel panel = new JPanel();
	private String[] columns = {"Indicador", "iPlasma", "PMD", "Custom_Rules"};
	private String[] lines = {"DCI", "DII", "ADCI", "ADII"};
	private DefaultTableModel model;
	
	public ResultsTable() {
		
	}
	
	private void showTable() {
		panel.setLayout(new BorderLayout());
		JFrame frame = new JFrame();
		panel.add(table);
		JScrollPane js=new JScrollPane(table);
		js.setVisible(true);
		panel.add(js);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 130);
		frame.setVisible(true);
	}
	
	
	//Falta Indicadores
	private void addResults() {
		for(int row = 0; row != model.getRowCount(); row++) {
			System.out.println(lines[row]);
			model.setValueAt(lines[row], row, 0);
			for(int column = 1; column != model.getRowCount(); column++) {
				model.setValueAt(row*10, row, column);
			}
		}
	}
	
	public void buildTable() {
		model = new DefaultTableModel(columns, 4);
		addResults();
		table = new JTable(model);
		showTable();
	}
	
	
	public static void main(String[] args)  {
		ResultsTable resultstable = new ResultsTable();
		resultstable.buildTable();
	}
}
