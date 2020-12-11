/**
 * 
 */
package results_text;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author ES-LETI-1Sem-2020-Grupo6
 *
 */
public class ResultsText {

	private int[][] resultsList;
	private String[] booltype = {"DCI", "DII", "ADCI", "ADII"};
	private String[] program = {"iPlasma", "PMD", "Th-Long Method", "Th-Feature Envy"};
	private JTextArea textarea = new JTextArea();
	
	
	/**
	 * Construtor ResultsText com o Array de resultados a apresentar.
	 *  
	 * @param resultsList Array de inteiros a apresentar num Jpanel
	 */
	public ResultsText(int[] resultsList) {
		this.resultsList = convertTo2DMatrix(resultsList);
		textarea.setEditable(false);
	}
	
	
	/**
	 * Transforma o Array de int numa Matriz 4x4.
	 *  
	 * @param resultsList Array de inteiros com length = 12
	 * @return matrix Matriz 4x4 a ser apresentada em texto
	 */
	private int[][] convertTo2DMatrix(int[] resultsList2) {
		int[][] matrix = new int[4][4];
		int counter=0;	
        for(int i=0;i<4;i++) {     	
            for(int j=0;j<4;j++) {         	
                if(counter==resultsList2.length) break;
                matrix[i][j]=resultsList2[counter];
            counter++;
            }
        }		
		return matrix;
	}
	
	/**
	 * Cria a JFrame com os dados fornecidos no construtor.
	 */
	private void showTable() {
		JFrame frame = new JFrame("Results Text");		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(textarea);		
		frame.add(panel);
		frame.setSize(200, 450);
		frame.setVisible(true);
	}

	/**
	 * Transforma a Matriz de resultados no formato de texto para apresentar na JTextArea.
	 */
	private void addResults() {
		for(int prog = 0; prog != program.length; prog++) {
			textarea.append(program[prog] + ":\n");
			for(int type = 0; type != booltype.length; type++) {
				textarea.append(" - " + booltype[type] + ": " + resultsList[prog][type] + "\n");	
			}
			textarea.append("\n");
		}
	}
	
	/**
	 * Ponto de entrada para a criação do JFrame com JTextArea e o array de resultados fornecidos no construtor.
	 */
	public void buildTable() {
		addResults();	
		showTable();
	}
}

