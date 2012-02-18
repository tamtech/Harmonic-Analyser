package HarmonicAnalyser;

public class Harmonic extends Calc{

	/**
	 * @param args
	 * @return 
	 */
	public static void main(String[] args) {

		double[][] harmonicArray = createHarmonicArray(data, sampleRate); 
		
		
			BarGraphGui.BarGraph(harmonicArray);
		
		
	}
	
	private static double[][] createHarmonicArray (double[] data, int sampleRate) {
		//Create 2-dimensional array.  [power] [frequency]
		double[] [] array = new double[(data.length / 2) + 1] [(data.length / 2) + 1];
		double[] realComponent = new double[(data.length / 2) + 1];
		double[] imaginaryComponent = new double[(data.length / 2) + 1];
		
		//Calculate the fundamental frequency
		double fundFrequency = 1 / ((Calc.sampleRate / 1) * (data.length));
		
		//Assign a value to each point in the array
		for (int i = 0; i < array.length; i++) {
			realComponent[i] = realComponent(data, i);
			imaginaryComponent[i] = imaginaryComponent(data, i);
			array[i][0] = modulus(realComponent[i], imaginaryComponent[i]);
			array[0][i] = fundFrequency * (i + 1);
		}
		
		return array;
		}
}