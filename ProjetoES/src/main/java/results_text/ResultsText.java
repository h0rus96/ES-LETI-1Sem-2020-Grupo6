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

	private int[] resultsList;
	private String[] booltype = {"DCI", "DII", "ADCI", "ADII"};
	private String[] program = {"iPlasma", "PMD", "Custom_Rules"};
	private JTextArea textarea = new JTextArea();
	
	
	public ResultsText(int[] resultsList) {
		this.resultsList = resultsList;
		textarea.setEditable(false);
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
				
				textarea.append(" - " + booltype[type] + ": " + 0 + "\n");	
				
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
