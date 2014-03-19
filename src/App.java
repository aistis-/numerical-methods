import tools.Reader;
import tridiagonalMatrix.Matrix;

public class App {

	public static void main(String[] args) {

		Reader fileReader = new Reader("test_data_1.txt");
		
		Matrix matrix = new Matrix();
		matrix.fillData(fileReader.getLine(1), fileReader.getLine(2), fileReader.getLine(3));
		
		System.out.println("Matrix readed:");
		matrix.print();
		
	}

}
