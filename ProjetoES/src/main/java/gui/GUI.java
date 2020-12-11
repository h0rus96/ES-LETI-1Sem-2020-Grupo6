package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

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

import GraphResults.GraphResults;
import data_service.CodeSmells.QualityIndicators;
import data_service.CodeSmells.ReadExcelFile;
import data_service.CodeSmells.SourceCode;
import data_service.Rules.Rules;
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
	private ReadExcelFile ref = new ReadExcelFile();

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
		ref.setExcelValuesToAnArray();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 903, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);
		
		JButton btnQIgraph = new JButton("Graph");
		btnQIgraph.setBounds(100, 328, 75, 20);
		btnQIgraph.setEnabled(false);
		btnQIgraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QualityIndicators ins = new QualityIndicators();
				int[] qi = ins.analyseQI(sc);
				GraphResults rgrph = new GraphResults(qi);
				rgrph.createGraph();
			}
		});
		frame.getContentPane().add(btnQIgraph);
		
		JButton btnQItable = new JButton("Table");
		btnQItable.setBounds(200, 328, 75, 20);
		btnQItable.setEnabled(false);
		btnQItable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QualityIndicators ins = new QualityIndicators();
				int[] qi = ins.analyseQI(sc);
				ResultsTable rtbl = new ResultsTable(qi);
				rtbl.buildTable();
			}
		});
		frame.getContentPane().add(btnQItable);
		
		JButton btnQItext = new JButton("Text");
		btnQItext.setBounds(300, 328, 75, 20);
		btnQItext.setEnabled(false);
		btnQItext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QualityIndicators ins = new QualityIndicators();
				int[] qi = ins.analyseQI(sc);
				ResultsText rtxt = new ResultsText(qi);
				rtxt.buildTable();
			}
		});
		frame.getContentPane().add(btnQItext);
		
		JLabel lblQualityIndicators = new JLabel("Display Quality Indicators");
		lblQualityIndicators.setBounds(165, 285, 300, 40);
		frame.getContentPane().add(lblQualityIndicators);
		
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
		rdbtnAnd1.setSelected(true);
		buttonGroup_1.add(rdbtnAnd1);
		rdbtnAnd1.setBounds(71, 122, 51, 23);
		frame.getContentPane().add(rdbtnAnd1);

		JRadioButton rdbtnOr1 = new JRadioButton("Or");
		buttonGroup_1.add(rdbtnOr1);
		rdbtnOr1.setBounds(128, 122, 71, 23);
		frame.getContentPane().add(rdbtnOr1);

		JRadioButton rdbtnAnd2 = new JRadioButton("And");
		rdbtnAnd2.setSelected(true);
		buttonGroup.add(rdbtnAnd2);
		rdbtnAnd2.setBounds(466, 122, 51, 23);
		frame.getContentPane().add(rdbtnAnd2);

		JRadioButton rdbtnOr2 = new JRadioButton("Or");
		buttonGroup.add(rdbtnOr2);
		rdbtnOr2.setBounds(519, 122, 71, 23);
		frame.getContentPane().add(rdbtnOr2);

		// LOC1
		textField = new JTextField();
		textField.setText("0");
		textField.setBounds(210, 79, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// CYCLO1
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setBounds(210, 165, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		// LAA1
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setColumns(10);
		textField_2.setBounds(639, 165, 86, 20);
		frame.getContentPane().add(textField_2);

		// ATFD1
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setColumns(10);
		textField_3.setBounds(639, 79, 86, 20);
		frame.getContentPane().add(textField_3);

		JButton btnScanCode = new JButton("Scan Code");
		btnScanCode.setBounds(303, 222, 159, 38);
		btnScanCode.setEnabled(false);
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
				double LAATH;
				boolean ANDLM;
				boolean ORLM;
				boolean ANDFE;
				boolean ORFE;

				LM = chckbxLongMethod.isSelected();
				FE = chckbxFeatureEnvy.isSelected();
				LOC = chckbxLOC.isSelected();
				LOCTH = Integer.parseInt(textField.getText());
				CYCLO = chckbxCYCLO.isSelected();
				CYCLOTH = Integer.parseInt(textField_1.getText());
				ATFD = chckbxATFD.isSelected();
				ATFDTH = Integer.parseInt(textField_3.getText());
				LAA = chckbxLAA.isSelected();
				LAATH = Double.parseDouble(textField_2.getText());
				ANDLM = rdbtnAnd1.isSelected();
				ORLM = rdbtnOr1.isSelected();
				ANDFE = rdbtnAnd2.isSelected();
				ORFE = rdbtnOr2.isSelected();

				Rules regras = new Rules();

				// LongMethod
				if (LM == true) {
					if (LOC && !CYCLO) {
						for (SourceCode sourcecode : sc) {
							sourcecode.setIs_long_method_th(regras.longMethodLOC(sourcecode.getLOC(), LOCTH));
						}
					}
					if (!LOC && CYCLO) {
						for (SourceCode sourcecode : sc) {
							sourcecode.setIs_long_method_th(regras.longMethodCYCLO(sourcecode.getCYCLO(), CYCLOTH));
						}
					}
					if (LOC && CYCLO) {
						if (ANDLM) {
							for (SourceCode sourcecode : sc) {
								sourcecode.setIs_long_method_th(
										regras.ruleAND(regras.longMethodLOC(sourcecode.getLOC(), LOCTH),
												regras.longMethodCYCLO(sourcecode.getCYCLO(), CYCLOTH)));
							}
						}
						if (ORLM) {
							for (SourceCode sourcecode : sc) {
								sourcecode.setIs_long_method_th(
										regras.ruleOR(regras.longMethodLOC(sourcecode.getLOC(), LOCTH),
												regras.longMethodCYCLO(sourcecode.getCYCLO(), CYCLOTH)));
							}
						}
					}
				}

				// FeatureEnvy
				if (FE == true) {
					if (ATFD && !LAA) {
						for (SourceCode sourcecode : sc) {
							sourcecode.setIs_feature_envy_th(regras.featureEnvyATFD(sourcecode.getATFD(), ATFDTH));
						}
					}
					if (!ATFD && LAA) {
						for (SourceCode sourcecode : sc) {
							sourcecode.setIs_feature_envy_th(regras.featureEnvyLAA(sourcecode.getLAA(), LAATH));
						}
					}
					if (ATFD && LAA) {
						if (ANDFE) {
							for (SourceCode sourcecode : sc) {
								sourcecode.setIs_feature_envy_th(
										regras.ruleAND(regras.featureEnvyATFD(sourcecode.getATFD(), ATFDTH),
												regras.featureEnvyLAA(sourcecode.getLAA(), LAATH)));
							}
						}
						if (ORFE) {
							for (SourceCode sourcecode : sc) {
								sourcecode.setIs_feature_envy_th(
										regras.ruleOR(regras.featureEnvyATFD(sourcecode.getATFD(), ATFDTH),
												regras.featureEnvyLAA(sourcecode.getLAA(), LAATH)));
							}
						}
					}
				}
				ref.setSourceCode(sc);
				ref.createTable();
				btnQIgraph.setEnabled(true);
				btnQItable.setEnabled(true);
				btnQItext.setEnabled(true);
			}
		});
		frame.getContentPane().add(btnScanCode);
		
		JButton btnImportExcell = new JButton("Import Excell");
		btnImportExcell.setBounds(760, 328, 119, 23);
		btnImportExcell.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (sc == null) {

					// ref.createTable();
					sc = ref.getSourceCode();
				}
				ref.createTable();
				btnScanCode.setEnabled(true);
			}
		});
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnImportExcell);
	}

}
