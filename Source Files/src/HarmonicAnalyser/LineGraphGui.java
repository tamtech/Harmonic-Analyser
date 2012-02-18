package HarmonicAnalyser;

// Class for launching the spectral graph

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineGraphGui {

	@SuppressWarnings("deprecation")
	public static void LineGraph(double[][] array) {
		XYSeries series = new XYSeries("Spectral Graph Response");

		for (int i = 1; i < array.length; i++) {
			//Frequency regulaion
			double frequency = Math.abs(array[i][1]);
			if (frequency == 0){
				frequency = 0.01;
			}
			//Check for unwanted data
			if ((array[i][0] + array[i+1][0] + array[i+2][0]) == 0) {
				break;
			}
			// Add each data point in the array to the data series
			series.add(frequency, (20 * Math.log10(array[i][0] + 1)));
		}

		XYDataset xyDataset = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart(
				"Frequency Response of Selected File", "Frequency / Hz",
				"Magnitude", xyDataset, PlotOrientation.VERTICAL, true, true,
				false);

		final XYPlot plot = chart.getXYPlot();
		XYSplineRenderer spline = new XYSplineRenderer(15);
		final NumberAxis rangeAxis = new NumberAxis("Magnitude / dB");
		// Set logarithmic frequency scale
		final NumberAxis domainAxis = new LogarithmicAxis("Frequency / Hz");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(rangeAxis);

		// Set smooth curves
		spline.setShapesVisible(false);
		chart.getXYPlot().setRenderer(spline);

		ChartFrame frame1 = new ChartFrame("Spectrum Analysis", chart);
		frame1.setVisible(true);
		frame1.setSize(1000, 800);

	}
}