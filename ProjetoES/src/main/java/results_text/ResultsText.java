/**
 * 
 */
package results_text;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author pedro
 *
 */
public class ResultsText {

	private int[][] resultsList;
	private String[] booltype = {"DCI", "DII", "ADCI", "ADII"};
	private String[] program = {"iPlasma", "PMD", "Custom_Rules"};
	private JTextArea textarea = new JTextArea();
	
	
	public ResultsText(int[] resultsList) {
		this.resultsList = convertTo2DMatrix(resultsList);
		textarea.setEditable(false);
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
		JFrame frame = new JFrame("Results Text");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(textarea);
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	
	private void addResults() {
		
		for(int prog = 0; prog != program.length; prog++) {
			
			textarea.append(program[prog] + ":\n");
			
			for(int type = 0; type != booltype.length; type++) {
				
				textarea.append(" - " + booltype[type] + ": " + resultsList[prog][type] + "\n");
				
			}
			
			textarea.append("\n");
		}
	}
	
	
	public void buildTable() {
		addResults();	
		showTable();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ResultsText text = new ResultsText(new int[]{0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3});
		text.buildTable();
	}

}

