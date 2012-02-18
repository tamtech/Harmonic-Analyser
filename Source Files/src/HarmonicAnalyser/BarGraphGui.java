package HarmonicAnalyser;

import java.awt.Color;
import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarGraphGui {

	public static void BarGraph(double[][] array) {

		// Choose format for decimal output
		DecimalFormat format = new DecimalFormat("#.##");

		// Create dataset, add each harmonic as a seperate data point
		DefaultCategoryDataset power = new DefaultCategoryDataset();
		power.setValue(array[0][0], "Magnitude", "DC offset");
		power.setValue(array[1][0], "Magnitude", "Fundamental Frequency - "
				+ format.format(array[1][1]) + " Hz");
		power.setValue(array[2][0], "Magnitude", "2nd HarmonicGraph - "
				+ format.format(array[2][1]) + " Hz");
		power.setValue(array[3][0], "Magnitude", "3rd HarmonicGraph - "
				+ format.format(array[3][1]) + " Hz");
		power.setValue(array[4][0], "Magnitude", "4th HarmonicGraph - "
				+ format.format(array[4][1]) + " Hz");
		power.setValue(array[5][0], "Magnitude", "5th HarmonicGraph - "
				+ format.format(array[5][1]) + " Hz");
		power.setValue(array[6][0], "Magnitude", "6th HarmonicGraph - "
				+ format.format(array[6][1]) + " Hz");
		power.setValue(array[7][0], "Magnitude", "7th HarmonicGraph - "
				+ format.format(array[7][1]) + " Hz");
		power.setValue(array[8][0], "Magnitude", "8th HarmonicGraph - "
				+ format.format(array[8][1]) + " Hz");
		power.setValue(array[9][0], "Magnitude", "9th HarmonicGraph - "
				+ format.format(array[9][1]) + " Hz");
		power.setValue(array[10][0], "Magnitude", "10th HarmonicGraph - "
				+ format.format(array[10][1]) + " Hz");

		// Create and set graph
		JFreeChart chart = ChartFactory.createBarChart(
				"Magnitude of Harmonics", "HarmonicGraph", "Magnitude", power,
				PlotOrientation.VERTICAL, false, true, false);
		chart.setBackgroundPaint(Color.white);
		chart.getTitle().setPaint(Color.black);
		CategoryPlot p = chart.getCategoryPlot();
		final CategoryAxis axis = p.getDomainAxis();
		// Select text rotation
		axis.setCategoryLabelPositions(CategoryLabelPositions
				.createUpRotationLabelPositions(Math.PI / 4.0));
		p.setRangeGridlinePaint(Color.blue);
		ChartFrame frame1 = new ChartFrame("Bar Chart", chart);
		frame1.setVisible(true);
		frame1.setSize(800, 800);

	}

}
