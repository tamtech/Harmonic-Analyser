package HarmonicAnalyser;

// Core class for all calculations for characteristics of a given harmonic

public abstract class Calc {

	// Declare fields
	public static boolean text;
	public static boolean harmonic;
	public static int sampleRate;
	public static double[] data;
	public static boolean phase;
	public static boolean spectral;

	// Find the real component
	protected static double realComponent(double[] data, double k) {
		// Declare and initialise the sum variable
		double sum = 0;

		// For loop, discrete integration by summing each sampled point with
		// corresponding cosine value
		for (int i = 0; i < data.length; i++) {
			double cos = Math.cos((2 * Math.PI * k * (i + 1))
					/ (data.length + 1));
			sum += cos * data[i] * 2;
		}

		// Find average of of area under the curve
		sum = sum / (data.length + 1);

		// Return normalised sum
		return sum;
	}

	// Find the imaginary component
	protected static double imaginaryComponent(double[] data, double k) {
		// Declare and initialise the sum variable
		double sum = 0;

		// For loop, discrete integration by summing each sampled point with
		// corresponding cosine value
		for (int i = 0; i < data.length; i++) {
			double sin = Math.sin((2 * Math.PI * k * (i + 1))
					/ (data.length + 1));
			sum += sin * data[i] * 2;
		}

		// Find average of of area under the curve
		sum = sum / (data.length + 1);

		return sum;
	}

	// Take the modulus of of the real and imaginary components at a given
	// harmonic/frequency
	protected static double modulus(double a, double b) {
		// Take the square root or the sum of the squared terms
		double squared = (a * a) + (b * b);
		double modulus = Math.sqrt(squared);

		// Return the modulus value
		return modulus;
	}

	// Find the phase angle of a given harmonic/frequency
	protected static double phaseAngle(double realComponent,
			double imaginaryComponent) {
		// Declare phaseAngle array
		double phaseAngle;

		// Calculate the phase angle for each harmonic/frequency in the data
		// array
		double realSquared = realComponent * realComponent;
		double imaginarySquared = imaginaryComponent * imaginaryComponent;
		double ratio = imaginarySquared / realSquared;
		phaseAngle = Math.atan(ratio);
		phaseAngle = Math.toDegrees(phaseAngle);

		// Return phase angle array
		return phaseAngle;

	}

}
