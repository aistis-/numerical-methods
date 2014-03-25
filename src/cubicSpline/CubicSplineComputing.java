package cubicSpline;

import java.util.Arrays;

public class CubicSplineComputing {
	
	private float[] x = new float[0];
	private float[] y = new float[0];
	
	public CubicSplineComputing(String xLine, String yLine) {
		String[] numbers = xLine.split(" ");

		for (int index = 0; index < numbers.length; index++) {
			this.x = this.addNumber(this.x, Float.parseFloat(numbers[index]));
		}
		
		numbers = yLine.split(" ");

		for (int index = 0; index < numbers.length; index++) {
			this.y = this.addNumber(this.y, Float.parseFloat(numbers[index]));
		}
	}
	
	public void compute() {
		
	}

	private double aproximatingFunction(double x) {
		return Math.sqrt(x) * Math.cos(2 * x);
	}
	
	private float[] addNumber(float[] diagonal, float number) {
		float[] result = Arrays.copyOf(diagonal, diagonal.length + 1);
	    result[diagonal.length] = number;
	    return result;
	}
}
