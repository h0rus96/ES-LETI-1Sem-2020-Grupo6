package GraphResults;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;

public class GraphResults  {
	
private int dci;
private int dii;
private int adci;
private int adii;

public GraphResults(int a,int b,int c, int d) {
	this.dci=a;
	this.dii=b;
	this.adci=c;
	this.adii=d;
}
	 private void createGraph() {
		 	
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
	        dataset.setValue(dci, "Number of Methods", "DCI");
	        dataset.setValue(dii, "Number of Methods", "DII");
	        dataset.setValue(adci, "Number of Methods", "ADCI");
	        dataset.setValue(adii, "Number of Methods", "ADII");
	        return dataset;
	    }
	 private JFreeChart createChart(CategoryDataset dataset) {

	        JFreeChart barChart = ChartFactory.createBarChart(
	                "Code Smells",
	                "",
	                "Number of Methods",
	                dataset,
	                PlotOrientation.VERTICAL,
	                false, true, false);

	        return barChart;
	    }
	 public static void main(String[] args) {
		 GraphResults ex = new GraphResults(20,20,20,20);
		 ex.createGraph();
	}
	
}
