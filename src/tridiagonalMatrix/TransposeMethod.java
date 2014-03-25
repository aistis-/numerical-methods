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
	
	public TransposeMethod(Matrix matrix, float[] result) {
		this.matrix = matrix;
		this.result = result;
		this.unknows = new float[matrix.getSize()];
	}
	
	public void calculate() {
		float C = - (matrix.get("top", 1) / matrix.get("middle", 1));
		float D = (this.result[0] / matrix.get("middle", 1));
		
		this.unknows[0] = C * this.calculateUnknown(2, C, D) + D;
		
		System.out.println("\nUnknown variables solutions:\n" + Arrays.toString(this.unknows));
	}
	
	private float calculateUnknown(int level, float C, float D) {
		
		float newD = ((this.result[level - 1] - matrix.get("bottom", level) * D) / (matrix.get("bottom", level) * C + matrix.get("middle", level)));
		
		if (level < this.matrix.getSize()) {
			
			float newC = - (matrix.get("top", level) / (matrix.get("bottom", level) * C + matrix.get("middle", level)));
			
			this.unknows[level - 1] = newC * calculateUnknown(level + 1, newC, newD) + newD;

			return this.unknows[level - 1];
		} else {
			this.unknows[level - 1] = newD;

			return newD;
		}
	}
	
	public boolean isSolvable() {
		boolean foundStrictInequality = false;
		
		for (int i = 1; i <= this.matrix.getSize(); i++) {
			if (Math.abs(this.matrix.get("middle", i)) < Math.abs(this.matrix.get("top", i)) + Math.abs(this.matrix.get("bottom", i))) {
				
				System.out.println("\nMiddle diagonal is less than same row diagonals numbers sum");
				
				return false;
			} else if (this.matrix.get("middle", i) != this.matrix.get("top", i) + this.matrix.get("bottom", i)) {
				foundStrictInequality = true;
			}
			
			if (!foundStrictInequality) {
				System.out.println("\nThere is no middle diagonal number which has strict inequality with his row neighbors");
				return false;
			}
		}
		
		return true;
	}
	
	public float[] getUnknows() {
		return this.unknows;
	}
}
