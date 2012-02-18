package HarmonicAnalyser;

//Class for creating and launching the spectral text output

import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

public class SpectralText extends Calc {

	SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {

		// Launch in different thread
		public String doInBackground() {

			String output = createSpectralString(data, sampleRate);

			return output;
		}

		// Once calculations are complete launch in Event Dispatch thread
		public void done() {
			try {
				// Set progress bar complete
				setProgress(100);
				// Launch text output
				TextOutput.main(get(), "Spectral");
				// Catch errors and launch error window
			} catch (InterruptedException e) {
				ErrorGui.main("Calculation error.  Please retry.");
			} catch (ExecutionException e) {
				ErrorGui.main("Calculation error.  Please retry.");
			}
		}

		private String createSpectralString(double[] data, int sampleRate) {
			// Create 2-dimensional array. [certain data point] [(0 = power) (1
			// = frequency)]
			double[][] array = new double[(data.length / 2) + 1][2];
			double[] realComponent = new double[array.length];
			double[] imaginaryComponent = new double[array.length];
			int accuracyCoEff = 1;

			// Lower processing points for large files
			if (array.length > 10000) {
				accuracyCoEff = 2;
			}
			if (array.length > 50000) {
				accuracyCoEff = 3;
			}
			if (array.length > 100000) {
				accuracyCoEff = 4;
			}
			if (array.length > 500000) {
				accuracyCoEff = 5;
			}

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

			// Process data and prepare as string buffer
			StringBuffer string = new StringBuffer();
			DecimalFormat format = new DecimalFormat("####");

			// Add each harmonic to the string buffer
			string.append(" The DC offset is " + array[0][0]);

			for (int i = 1; i < array.length; i++) {
				string.append(" The magnitude at  "
						+ format.format(array[i][1]) + " Hz  is  "
						+ array[i][0] + "\n");
			}

			// Convert to string and return
			String output = string.toString();
			return output;

		}

	};

}
