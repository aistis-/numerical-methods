package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

	private ArrayList<String> fileData = new ArrayList<String>();
	
	public boolean read(String filePath) {
		File file = new File(filePath);
		
		if (file.exists()) {
			FileInputStream stream;
		
			try {
				stream = new FileInputStream(filePath);
			} catch (FileNotFoundException e) {
				return false;
			}
		
			Scanner scanner = new Scanner(stream);
		      
	        System.out.println("Reading from file " + filePath);
	      
	        while(scanner.hasNextLine()){
	        	String line = scanner.nextLine();
	        	
	        	if (0 < line.length()) {
	            	this.fileData.add(line);
	        	}
	        }
	        
	        System.out.println("File read was successful");
	      
	        scanner.close();
	        
	        return true;
		} else {
			System.out.println("File not found");
			
			return false;
		}
	}
	
	public String getLine(int line) {
		return this.fileData.get(line - 1);
	}
}
