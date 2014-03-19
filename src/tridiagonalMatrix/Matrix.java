package tridiagonalMatrix;

import java.util.Arrays;

public class Matrix {

	private float[] diagonalTop;
	private float[] diagonalMiddle;
	private float[] diagonalBottom;
	
	public Matrix() {
		this.diagonalTop = new float[0];
		this.diagonalMiddle = new float[0];
		this.diagonalBottom = new float[0];
	}
	
	public void fillData(String diagonalTop, String diagonalMiddle, String diagonalBottom) {
		String[] numbers = diagonalTop.split(" ");

		for (int index = 0; index < numbers.length; index++) {
			this.diagonalTop = this.addNumber(this.diagonalTop, Float.parseFloat(numbers[index]));
		}
		
		numbers = diagonalMiddle.split(" ");

		for (int index = 0; index < numbers.length; index++) {
			this.diagonalMiddle = this.addNumber(this.diagonalMiddle, Float.parseFloat(numbers[index]));
		}
		
		numbers = diagonalBottom.split(" ");

		for (int index = 0; index < numbers.length; index++) {
			this.diagonalBottom = this.addNumber(this.diagonalBottom, Float.parseFloat(numbers[index]));
		}
	}
	
	private float[] addNumber(float[] diagonal, float number) {
		float[] result = Arrays.copyOf(diagonal, diagonal.length + 1);
	    result[diagonal.length] = number;
	    return result;
	}
	
	public void print() {
		this.print(true);
	}
	
	public void print(boolean formatted) {
		if (this.validate()) {
			if (formatted) {
				int n = diagonalMiddle.length;
				
				for (int i = 0; i < n; i++) {
				    for (int j = 0; j < n; j++) {
				        if (i == j) {
				        	this.printFloat(this.diagonalMiddle[i]);
				        } else if (i + 1 == j) {
				        	this.printFloat(this.diagonalTop[i]);
				        } else if (j + 1 == i) {
				        	this.printFloat(this.diagonalBottom[j]);
				        } else {
				        	this.printFloat(0);
				        }
				        
				        System.out.print(" ");
				    }
				    
				    System.out.print("\n");
				}
			} else {
				System.out.println("Top diagonal: " + Arrays.toString(this.diagonalTop));
				System.out.println("Middle diagonal: " + Arrays.toString(this.diagonalMiddle));
				System.out.println("Bottom diagonal: " + Arrays.toString(this.diagonalBottom));
			}
		} else {
			System.out.println("Matrix is empty or filled incorrectly");
		}
	}
	
	private boolean validate() {
		if(0 < this.diagonalTop.length && 0 < this.diagonalMiddle.length && 0 < this.diagonalBottom.length) {
			if (this.diagonalTop.length == this.diagonalMiddle.length - 1 && this.diagonalBottom.length == this.diagonalMiddle.length - 1) {
				return true;
			}
		}
		
		return false;
	}
	
	private void printFloat(float number) {
		System.out.printf("%5.2f", number);
	}
	
	public int getSize() {
		return this.diagonalMiddle.length;
	}
	
	public float get(String diagonal, int row) {
		float result;
		
		switch (diagonal) {
			case "top": 
				result = this.diagonalTop[row - 1];
				break;
			case "middle": 
				result = this.diagonalMiddle[row - 1];
				break;
			case "bottom": 
				result = this.diagonalBottom[row - 2];
				break;
			default:
				result = 0;
		}
		
		return result;
	}
}
