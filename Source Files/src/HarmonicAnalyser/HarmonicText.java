package HarmonicAnalyser;

//Class for creating and launching the harmonic text output

import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

public class HarmonicText extends Calc {

	SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {

		// Create array for harmonic results
		public String doInBackground() {

			String output = createHarmonicString(data, sampleRate);

			return output;
		}

		// Once calculations are complete launch in Event Dispatch thread
		public void done() {
			try {
				// Set progress bar complete
				setProgress(100);
				// Launch text output
				TextOutput.main(get(), "Harmonic");
				// Catch errors and launch error window
			} catch (InterruptedException e) {
				ErrorGui.main("Calculation error.  Please retry.");
			} catch (ExecutionException e) {
				ErrorGui.main("Calculation error.  Please retry.");
			}
		}

		private String createHarmonicString(double[] data, int sampleRate) {
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
				// Update progress bar if array length is more than 100, any
				// less will cause error
				if (array.length > 100) {
					setProgress((int) (i / MainGui.progressCoEff));
				}
			}

			// Process data and prepare as string buffer
			StringBuffer string = new StringBuffer();
			DecimalFormat format = new DecimalFormat("#.#");

			// Add each harmonic to the string buffer
			for (int i = 0; i < array.length; i++) {
				string.append(" The magnitude of the " + i + "st harmonic at  "
						+ format.format(array[i][1]) + " Hz  is  "
						+ format.format(array[i][0]) + "\n");
			}

			// Convert to string and return
			String output = string.toString();
			return output;
		}

	};

}
