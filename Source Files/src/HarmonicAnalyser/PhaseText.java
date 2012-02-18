package HarmonicAnalyser;

//Class for creating and launching the phase text output

import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

public class PhaseText extends Calc {

	// Launch in different thread
	SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {

		public String doInBackground() {

			String output = createPolarArray(data, sampleRate);

			return output;
		}

		// Once calculations are complete launch in Event Dispatch thread
		public void done() {
			try {
				// Set progress bar complete
				setProgress(100);
				// Launch graph
				TextOutput.main(get(), "Phase");
				// Catch errors and launch error window
			} catch (InterruptedException e) {
				ErrorGui.main("Calculation error.  Please retry.");
			} catch (ExecutionException e) {
				ErrorGui.main("Calculation error.  Please retry.");
			}
		}

		private String createPolarArray(double[] data, int sampleRate) {

			// Create 2-dimensional array. [value] [(0 = phase) (1 = frequency)]
			double[][] array = new double[11][3];
			double[] realComponent = new double[array.length];
			double[] imaginaryComponent = new double[array.length];

			// Calculate the fundamental frequency
			double fundFrequency = 1 / ((1 / (double) Calc.sampleRate) * data.length);
			System.out.println("The fund freq is " + fundFrequency);

			// Assign a value to each point in the array
			for (int i = 0; i < 11; i++) {
				realComponent[i] = realComponent(data, i);
				imaginaryComponent[i] = imaginaryComponent(data, i);
				array[i][1] = fundFrequency * i;
				array[i][0] = phaseAngle(realComponent[i],
						imaginaryComponent[i]);
				// Update progress bar if array length is more than 100, any less will cause error
				if (array.length > 100) {
					setProgress((int) (i / MainGui.progressCoEff));
				}
			}

			StringBuffer string = new StringBuffer();
			DecimalFormat format = new DecimalFormat("#.#");

			for (int i = 1; i < array.length; i++) {
				string.append(" The phase angle of the " + i
						+ "st harmonic at  " + format.format(array[i][1])
						+ " Hz  is  " + format.format(array[i][0])
						+ " degrees \n");
			}

			// Convert to string and return
			String output = string.toString();
			return output;
		}
	};

}
