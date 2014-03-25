package cubicSpline;

import java.util.Arrays;
import java.util.Scanner;

import tools.Reader;

public class CubicSplineComputing {
	
	private float[] x = new float[0];
	private float[] y = new float[0];
	private float a;
	private float b;
	private float i;
	
	public CubicSplineComputing(String intervals, String xLine, String yLine) {
		String[] numbers = xLine.split(" ");
		
		this.a = Float.parseFloat(numbers[0]);
		this.b = Float.parseFloat(numbers[1]);
		this.i = Float.parseFloat(numbers[2]);

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
