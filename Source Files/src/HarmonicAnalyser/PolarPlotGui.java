package HarmonicAnalyser;

//Class for launching the spectral graph

import java.text.DecimalFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PolarPlotGui {

	public static void PolarPlot(double array[][]) {

		//Set output format
		DecimalFormat format = new DecimalFormat("#.##");

		// Add each data point to the data series
		XYSeries s1 = new XYSeries("1st HarmonicGraph - "
				+ format.format(array[1][2]) + "Hz");
		s1.add(0, 0);
		s1.add(array[1][1], array[1][0]);

		XYSeries s2 = new XYSeries("2nd HarmonicGraph - "
				+ format.format(array[2][2]) + "Hz");
		s2.add(0, 0);
		s2.add(array[2][1], array[2][0]);

		XYSeries s3 = new XYSeries("3rd HarmonicGraph - "
				+ format.format(array[3][2]) + "Hz");
		s3.add(0, 0);
		s3.add(array[3][1], array[3][0]);

		XYSeries s4 = new XYSeries("4th HarmonicGraph - "
				+ format.format(array[4][2]) + "Hz");
		s4.add(0, 0);
		s4.add(array[4][1], array[4][0]);

		XYSeries s5 = new XYSeries("5th HarmonicGraph - "
				+ format.format(array[5][2]) + "Hz");
		s5.add(0, 0);
		s5.add(array[5][1], array[5][0]);

		XYSeries s6 = new XYSeries("6th HarmonicGraph - "
				+ format.format(array[6][2]) + "Hz");
		s6.add(0, 0);
		s6.add(array[6][1], array[6][0]);

		XYSeries s7 = new XYSeries("7th HarmonicGraph - "
				+ format.format(array[7][2]) + "Hz");
		s7.add(0, 0);
		s7.add(array[7][1], array[7][0]);

		XYSeries s8 = new XYSeries("8th HarmonicGraph - "
				+ format.format(array[8][2]) + "Hz");
		s8.add(0, 0);
		s8.add(array[8][1], array[8][0]);

		XYSeries s9 = new XYSeries("9th HarmonicGraph - "
				+ format.format(array[9][2]) + "Hz");
		s9.add(0, 0);
		s9.add(array[9][1], array[9][0]);

		XYSeries s10 = new XYSeries("10th HarmonicGraph - "
				+ format.format(array[10][2]) + "Hz");
		s10.add(0, 0);
		s10.add(array[10][1], array[10][0]);

		XYSeriesCollection data = new XYSeriesCollection();
		data.addSeries(s1);
		data.addSeries(s2);
		data.addSeries(s3);
		data.addSeries(s4);
		data.addSeries(s5);
		data.addSeries(s6);
		data.addSeries(s7);
		data.addSeries(s8);
		data.addSeries(s9);
		data.addSeries(s10);

		XYDataset dataset = data;

		JFreeChart chart = ChartFactory.createPolarChart("Phase Plot",
				dataset, true, true, false);
		ChartFrame frame1 = new ChartFrame("Phase Plot", chart);
		frame1.setVisible(true);
		frame1.setSize(800, 800);
	}
}
