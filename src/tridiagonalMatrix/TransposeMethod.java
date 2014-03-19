package tridiagonalMatrix;

import java.util.Arrays;

public class TransposeMethod {

	private Matrix matrix;
	private float[] result;
	private float[] unknows ;
	
	public TransposeMethod(Matrix matrix, String result) {
		this.matrix = matrix;
		
		this.result = new float[matrix.getSize()];
		this.unknows = new float[matrix.getSize()];
		
		String[] numbers = result.split(" ");

		for (int index = 0; index < numbers.length; index++) {
			this.result[index] = Float.parseFloat(numbers[index]);
		}
	}
	
	public void calculate() {
		float C = - (matrix.get("top", 1) / matrix.get("middle", 1));
		float D = (this.result[0] / matrix.get("middle", 1));
		
		this.unknows[0] = this.calculateUnknown(2, C, D);
		
		System.out.println("Unknown variables solutions: " + Arrays.toString(this.unknows));
	}
	
	private float calculateUnknown(int level, float C, float D) {
		
		float newD = ((this.result[level - 1] - matrix.get("bottom", level) * D) / (matrix.get("bottom", level) * C + matrix.get("middle", level)));
		
		if (level < this.matrix.getSize()) {
			
			float newC = - (matrix.get("top", level) / (matrix.get("bottom", level) * C + matrix.get("middle", level)));

			float result = calculateUnknown(level + 1, newC, newD);
			
			this.unknows[level - 1] = result;

			return result;
		} else {
			this.unknows[level - 1] = newD;
		
			return newD;
		}
	}
}
