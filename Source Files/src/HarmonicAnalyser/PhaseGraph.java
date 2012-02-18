package HarmonicAnalyser;

//Class for creating and launching the phase graph

import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

public class PhaseGraph extends Calc {

	double[][] polarArray;

	// Launch in different thread
	SwingWorker<double[][], Void> worker = new SwingWorker<double[][], Void>() {

		public double[][] doInBackground() {

			polarArray = createPolarArray(data, sampleRate);

			return polarArray;
		}

		// Once calculations are complete launch in Event Dispatch thread
		public void done() {
			try {
				// Set progress bar complete
				setProgress(100);
				// Launch graph
				PolarPlotGui.PolarPlot(get());
				// Catch errors and launch error window
			} catch (InterruptedException e) {
				ErrorGui.main("Calculation error.  Please retry.");
			} catch (ExecutionException e) {
				ErrorGui.main("Calculation error.  Please retry.");
			}
		}

		private double[][] createPolarArray(double[] data, int sampleRate) {

			// Create 2-dimensional array. [value] [(0 = power) (1 = phase) (2 =
			// frequency)]
			double[][] array = new double[(data.length / 2) + 1][3];
			double[] realComponent = new double[array.length];
			double[] imaginaryComponent = new double[array.length];

			// Calculate the fundamental frequency
			double fundFrequency = 1 / ((1 / (double) Calc.sampleRate) * data.length);

			// Assign a value to each point in the array
			for (int i = 0; i < 11; i++) {
				realComponent[i] = realComponent(data, i);
				imaginaryComponent[i] = imaginaryComponent(data, i);
				array[i][2] = fundFrequency * i;
				array[i][1] = phaseAngle(realComponent[i],
						imaginaryComponent[i]);
				array[i][0] = modulus(realComponent[i], imaginaryComponent[i]);
				// Update progress bar
				setProgress((int) (i * (100 / 11)));
			}

			// Return completed array to be placed in the polarArray field.
			return array;
		}
	};
}
