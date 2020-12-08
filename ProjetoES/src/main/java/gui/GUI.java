package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import data_service.CodeSmells.QualityIndicators;
import data_service.CodeSmells.ReadExcelFile;
import data_service.CodeSmells.SourceCode;
import results_table.ResultsTable;
import results_text.ResultsText;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;

public class GUI {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private SourceCode[] sc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 903, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnImportExcell = new JButton("Import Excell");
		btnImportExcell.setBounds(760, 328, 119, 23);
		btnImportExcell.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ReadExcelFile instance = new ReadExcelFile();
				instance.createTable();
				sc = instance.getSourceCode();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnImportExcell);

		JCheckBox chckbxLongMethod = new JCheckBox("Long Method");
		chckbxLongMethod.setBounds(150, 37, 97, 23);
		frame.getContentPane().add(chckbxLongMethod);

		JCheckBox chckbxFeatureEnvy = new JCheckBox("Feature Envy");
		chckbxFeatureEnvy.setBounds(566, 37, 97, 23);
		frame.getContentPane().add(chckbxFeatureEnvy);

		JCheckBox chckbxLOC = new JCheckBox("Lines of Code");
		chckbxLOC.setBounds(71, 78, 128, 23);
		frame.getContentPane().add(chckbxLOC);

		JCheckBox chckbxCYCLO = new JCheckBox("Cyclomatic Complexity");
		chckbxCYCLO.setBounds(71, 164, 133, 23);
		frame.getContentPane().add(chckbxCYCLO);

		JCheckBox chckbxATFD = new JCheckBox("Access to Foreign Data");
		chckbxATFD.setBounds(466, 78, 151, 23);
		frame.getContentPane().add(chckbxATFD);

		JCheckBox chckbxLAA = new JCheckBox("Locality of Attribute Accesses");
		chckbxLAA.setBounds(466, 164, 167, 23);
		frame.getContentPane().add(chckbxLAA);

		JRadioButton rdbtnAnd1 = new JRadioButton("And");
		buttonGroup_1.add(rdbtnAnd1);
		rdbtnAnd1.setBounds(71, 122, 51, 23);
		frame.getContentPane().add(rdbtnAnd1);

		JRadioButton rdbtnOr1 = new JRadioButton("Or");
		buttonGroup_1.add(rdbtnOr1);
		rdbtnOr1.setBounds(128, 122, 71, 23);
		frame.getContentPane().add(rdbtnOr1);

		JRadioButton rdbtnAnd2 = new JRadioButton("And");
		buttonGroup.add(rdbtnAnd2);
		rdbtnAnd2.setBounds(466, 122, 51, 23);
		frame.getContentPane().add(rdbtnAnd2);

		JRadioButton rdbtnOr2 = new JRadioButton("Or");
		buttonGroup.add(rdbtnOr2);
		rdbtnOr2.setBounds(519, 122, 71, 23);
		frame.getContentPane().add(rdbtnOr2);

		// LOC1
		textField = new JTextField();
		textField.setBounds(210, 79, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// CYCLO1
		textField_1 = new JTextField();
		textField_1.setBounds(210, 165, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		// LAA1
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(639, 165, 86, 20);
		frame.getContentPane().add(textField_2);

		// ATFD1
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(639, 79, 86, 20);
		frame.getContentPane().add(textField_3);

		JButton btnScanCode = new JButton("Scan Code");
		btnScanCode.setBounds(303, 222, 159, 38);
		btnScanCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean LM;
				boolean FE;
				boolean LOC;
				boolean CYCLO;
				boolean ATFD;
				boolean LAA;
				int LOCTH;
				int CYCLOTH;
				int ATFDTH;
				int LAATH;

				LM = chckbxLongMethod.isSelected();
				FE = chckbxFeatureEnvy.isSelected();
				LOC = chckbxFeatureEnvy.isSelected();
				LOCTH = Integer.parseInt(textField.getText());
				CYCLO = chckbxCYCLO.isSelected();
				CYCLOTH = Integer.parseInt(textField_1.getText());
				ATFD = chckbxATFD.isSelected();
				ATFDTH = Integer.parseInt(textField_3.getText());
				LAA = chckbxLAA.isSelected();
				LAATH = Integer.parseInt(textField_2.getText());

//				if (chckbxLongMethod.isSelected() == true) {
//					LM = true;
//				}
//				if (chckbxFeatureEnvy.isSelected() == true) {
//					FE = true;
//				}
//				if (chckbxLOC.isSelected() == true) {
//					LOC = true;
//					LOC1 = textField.getText();
//				}
//				if (chckbxCYCLO.isSelected() == true) {
//					CYCLO = true;
//					CYCLO1 = textField_1.getText();
//				}
//				if (chckbxATFD.isSelected() == true) {
//					ATFD = true;
//					ATFD1 = textField_3.getText();
//				}
//				if (chckbxLAA.isSelected() == true) {
//					LAA = true;
//					LAA1 = textField_2.getText();
//				}

//No GUI, tens de ir buscar se o botao que queres tá ligado ou não e meter isso num boolean
//E ir buscar os thresholds dos botoes que tao ligados e meter isso em variaveis int
//E dps com isso chamar os metodos das regras
//Isso tem de estar dentro do botao scan code, antes do que eu lá pus para os indicadores de qualidade

//btnScanCode tem lá um método que tudo o q tá lá dentro acontece qnd é premido, o action listener ou algo do genero
//Aí dentro, por cima do que já lá está, vais mexer tu
//Primeiro vais meter em variaveis boolean os botoes (true se tiverem o certinho, false se não tiverem)
//E depois vais buscar os numeros que estarias inseridos nos sitios onde estariam os thresholds e metes esses valores em ints

//Sim, pq cada vez que vamos scannar o code temos de atualizar isso tudo
//E depois de ter isso tudo em variaveis, usas os booleans em if's e usa-los para chamar os metodos das regras

				QualityIndicators ins = new QualityIndicators();
				int[] qi = ins.analyseQI(sc);
				ResultsTable rtbl = new ResultsTable(qi);
				rtbl.buildTable();
				ResultsText rtxt = new ResultsText(qi);
				rtxt.buildTable();
			}
		});
		frame.getContentPane().add(btnScanCode);

	}

}
