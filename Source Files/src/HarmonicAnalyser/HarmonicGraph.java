package HarmonicAnalyser;

// Class for creating and launching the harmonic graph

import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

public class HarmonicGraph extends Calc {

	// Create array for harmonic results
	double[][] harmonicArray;

	// Launch in different thread
	SwingWorker<double[][], Void> worker = new SwingWorker<double[][], Void>() {

		public double[][] doInBackground() {

			harmonicArray = createHarmonicArray(data, sampleRate);

			return harmonicArray;
		}

		// Once calculations are complete launch in Event Dispatch thread
		public void done() {
			try {
				// Set progress bar complete
				setProgress(100);
				// Launch graph
				BarGraphGui.BarGraph(get());
				// Catch errors and launch error window
			} catch (InterruptedException e) {
				ErrorGui.main("Calculation error.  Please retry.");
			} catch (ExecutionException e) {
				ErrorGui.main("Calculation error.  Please retry.");
			}
		}

		private double[][] createHarmonicArray(double[] data, int sampleRate) {

			// Create 2-dimensional array. [certain data point] [(0 = power) (1
			// = frequency)]
			double[][] array = new double[11][2];
			double[] realComponent = new double[array.length];
			double[] imaginaryComponent = new double[array.length];

			// Calculate the fundamental frequency
			double fundFrequency = 1 / ((1 / (double) Calc.sampleRate) * data.length);

			// Assign a value to each point in the array
			for (int i = 0; i < 11; i++) {
				realComponent[i] = realComponent(data, i);
				imaginaryComponent[i] = imaginaryComponent(data, i);
				array[i][0] = modulus(realComponent[i], imaginaryComponent[i]);
				array[i][1] = fundFrequency * i;
				// Update progress bar if array length is more than 100, any less will cause error
				if (array.length > 100) {
					setProgress((int) (i / MainGui.progressCoEff));
				}
			}

			// Return completed array to be placed in the harmonicArray field.
			return array;
		}

	};
}