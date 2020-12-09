package GraphResults;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.BorderFactory;
import java.awt.Color;


import data_service.CodeSmells.*;

public class GraphResults  {

	private int dci_iP;
	private int dii_iP;
	private int adci_iP;
	private int adii_iP;
	private int dci_PMD;
	private int dii_PMD;
	private int adci_PMD;
	private int adii_PMD;
	private int dci_TH_LM;
	private int dii_TH_LM;
	private int adci_TH_LM;
	private int adii_TH_LM;
	private int dci_TH_FE;
	private int dii_TH_FE;
	private int adci_TH_FE;
	private int adii_TH_FE;

	public GraphResults(int arr[]) {
		this.dci_iP=arr[0];
		this.dii_iP=arr[1];
		this.adci_iP=arr[2];
		this.adii_iP=arr[3];
		this.dci_PMD=arr[4];
		this.dii_PMD=arr[5];
		this.adci_PMD=arr[6];
		this.adii_PMD=arr[7];
		this.dci_TH_LM=arr[8];
		this.dii_TH_LM=arr[9];
		this.adci_TH_LM=arr[10];
		this.adii_TH_LM=arr[11];
		this.dci_TH_FE=arr[12];
		this.dii_TH_FE=arr[13];
		this.adci_TH_FE=arr[14];
		this.adii_TH_FE=arr[15];
	}
	public void createGraph() {

		JFrame graph=new JFrame();
		CategoryDataset dataset = createDataset();

		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		graph.add(chartPanel);

		graph.pack();
		graph.setTitle("Bar chart");
		graph.setLocationRelativeTo(null);
		graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		graph.setSize(500, 500);
		graph.setVisible(true);
	}

	private CategoryDataset createDataset() {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.setValue(dci_iP, "Number of Methods", "DCI(iPlasma)");
		dataset.setValue(dii_iP, "Number of Methods", "DII(iPlasma)");
		dataset.setValue(adci_iP, "Number of Methods", "ADCI(iPlasma)");
		dataset.setValue(adii_iP, "Number of Methods", "ADII(iPlasma)");

		dataset.setValue(dci_PMD, "Number of Methods", "DCI(PMD)");
		dataset.setValue(dii_PMD, "Number of Methods", "DII(PMD)");
		dataset.setValue(adci_PMD, "Number of Methods", "ADCI(PMD)");
		dataset.setValue(adii_PMD, "Number of Methods", "ADII(PMD)");

		dataset.setValue(dci_TH_LM, "Number of Methods", "DCI(TH Long Method)");
		dataset.setValue(dii_TH_LM, "Number of Methods", "DII(TH Long Method)");
		dataset.setValue(adci_TH_LM, "Number of Methods", "ADCI(TH Long Method)");
		dataset.setValue(adii_TH_LM, "Number of Methods", "ADII(TH Long Method)");

		dataset.setValue(dci_TH_FE, "Number of Methods", "DCI(TH feature envy)");
		dataset.setValue(dii_TH_FE, "Number of Methods", "DII(TH feature envy)");
		dataset.setValue(adci_TH_FE, "Number of Methods", "ADCI(TH feature envy)");
		dataset.setValue(adii_TH_FE, "Number of Methods", "ADII(TH feature envy)");

		return dataset;
	}
	
	
	 /**
     * Creates a chart.
     *
     * @param dataset  the dataset.
     *
     * @return The barChart.
     */
	private JFreeChart createChart(CategoryDataset dataset) {

		JFreeChart barChart = ChartFactory.createBarChart(
				"Code Smells",
				"",
				"Number of Methods",
				dataset,
				PlotOrientation.VERTICAL,
				true, true, true);
		
		CategoryPlot plot = (CategoryPlot) barChart.getPlot();
		plot.setRangePannable(true);

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);

		return barChart;
	}
	public static void main(String[] args) {
		QualityIndicators qi=new QualityIndicators();
		ReadExcelFile ref=new ReadExcelFile();
		GraphResults ex=new GraphResults(qi.analyseQI(ref.getExcelValuesToAnArray()));
		ex.createGraph();
	}

}
