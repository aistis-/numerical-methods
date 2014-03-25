import java.util.Scanner;

import cubicSpline.CubicSplineComputing;
import tools.Reader;

public class CubicSpline {

	public static void main(String[] args) {
		
		System.out.println("Enter file name which contains a table of values");
		System.out.print("File name: ");
		
		Scanner s = new Scanner(System.in);

		Reader fileReader = new Reader();
		if (fileReader.read(s.next())) {
			System.out.println();
			
			CubicSplineComputing computing = new CubicSplineComputing(
					fileReader.getLine(1),
					fileReader.getLine(2),
					fileReader.getLine(3)
			);
			
			computing.compute(true);
			
			computing = new CubicSplineComputing(
					fileReader.getLine(1),
					fileReader.getLine(2),
					fileReader.getLine(3)
			);
			computing.compute(false);
		}
	}
}
