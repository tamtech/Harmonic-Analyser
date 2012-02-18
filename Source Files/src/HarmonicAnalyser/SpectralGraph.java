package HarmonicAnalyser;

//Class for creating and launching the spectral graph

import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import HarmonicAnalyser.MainGui;

public class SpectralGraph extends Calc {

	// Launch in different thread
	SwingWorker<double[][], Void> worker = new SwingWorker<double[][], Void>() {

		public double[][] doInBackground() {

			double[][] spectralArray = createSpectralArray(data, sampleRate);

			return spectralArray;
		}

		// Once calculations are complete launch in Event Dispatch thread
		public void done() {
			try {
				// Set progress bar complete
				setProgress(100);
				// Launch graph
				LineGraphGui.LineGraph(get());
				// Catch errors and launch error window
			} catch (InterruptedException e) {
				ErrorGui.main("Calculation error.  Please retry.");
			} catch (ExecutionException e) {
				ErrorGui.main("Calculation error.  Please retry.");
			}
		}

		private double[][] createSpectralArray(double[] data, int sampleRate) {

			// Lower processing points for large files
			int accuracyCoEff = 1;
			if (data.length > 1000) {
				accuracyCoEff = 50;
			}
			if (data.length > 50000) {
				accuracyCoEff = 80;
			}
			if (data.length > 100000) {
				accuracyCoEff = 100;
			}
			if (data.length > 500000) {
				accuracyCoEff = 1000;
			}
			
			// Create 2-dimensional array. [certain data point] [(0 = power) (1
			// = frequency)]
			double[][] array = new double[((data.length / 2) + 1)][2];
			double[] realComponent = new double[array.length / accuracyCoEff];
			double[] imaginaryComponent = new double[array.length / accuracyCoEff];
			
			// Calculate the fundamental frequency
			double fundFrequency = 1 / ((1 / (double) Calc.sampleRate) * data.length);

			// Assign a value to each point in the array
			for (int i = 0; i < (array.length / accuracyCoEff); i++) {
				realComponent[i] = realComponent(data, (accuracyCoEff * i));
				imaginaryComponent[i] = imaginaryComponent(data,
						(accuracyCoEff * i));
				array[i][0] = modulus(realComponent[i], imaginaryComponent[i]);
				array[i][1] = fundFrequency * (accuracyCoEff * i);
				// Update progress bar if array length is more than 100, any less will cause error
				if (array.length > 100) {
					setProgress((int) (i / (MainGui.progressCoEff / accuracyCoEff)));
				}
			}

			// Return completed array to be placed in the spectralArray field.
			return array;
		}

	};
}
