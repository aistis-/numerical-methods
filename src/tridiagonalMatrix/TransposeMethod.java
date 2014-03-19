package tridiagonalMatrix;

public class TransposeMethod {

	private Matrix matrix;
	private float[] result;
	
	public TransposeMethod(Matrix matrix, String result) {
		this.matrix = matrix;
		
		String[] numbers = result.split(" ");

		for (int index = 0; index < numbers.length; index++) {
			this.result = matrix.addNumber(this.result, Float.parseFloat(numbers[index]));
		}
	}
	
	public void calculate() {
		
	}
	
}
