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
	private int[][] resultsList;
	private DefaultTableModel model = new DefaultTableModel(columns, 4);;
	
	public ResultsTable(int[] resultsList) {
		this.resultsList = convertTo2DMatrix(resultsList);
		
	}
	
	
	private int[][] convertTo2DMatrix(int[] resultsList2) {
		int[][] matrix = new int[3][4];
		int counter=0;
		
        for(int i=0;i<3;i++) {
        	
            for(int j=0;j<4;j++) {
            	
                if(counter==resultsList2.length) break;

                matrix[i][j]=resultsList2[counter];

            System.out.printf("matrix[%d][%d]= %d\n",i,j,matrix[i][j]);

            counter++;

            }

        }
		
		return matrix;
	}

	
	private void showTable() {
		panel.setLayout(new BorderLayout());
		JFrame frame = new JFrame("Results Table");
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
				
				model.setValueAt(resultsList[column-1][row], row, column);
				
			}
		}
		
	}
	
	public void buildTable() {
		addResults();
		table = new JTable(model);		
		showTable();
	}
	
	
	public static void main(String[] args)  {
		ResultsTable resultstable = new ResultsTable(new int[]{0,1,2,3,10,11,21,31,20,12,22,32,30,13,23,33});
		resultstable.buildTable();
	}
}
