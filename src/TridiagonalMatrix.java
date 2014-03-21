import tools.Reader;
import tridiagonalMatrix.Matrix;
import tridiagonalMatrix.TransposeMethod;

public class TridiagonalMatrix {

	public static void main(String[] args) {

		Reader fileReader = new Reader("test_data_2.txt");
		
		Matrix matrix = new Matrix();
		matrix.fillData(fileReader.getLine(1), fileReader.getLine(2), fileReader.getLine(3));
		
		if (matrix.validate()) {
			System.out.println("Matrix readed:");
			matrix.print();
			
			TransposeMethod method = new TransposeMethod(matrix, fileReader.getLine(4));
			
			if (method.isSolvable()) {
				method.calculate();
			} else {
				System.out.println("The matrix is not solvable with transpose method");
			}
		} else {
			System.out.println("Matrix was not filled corectly");
		}
	}
}
