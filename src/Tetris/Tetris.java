package Tetris;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tetris {
public static String path = System.getProperty("user.dir");
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		practice("A-my-practice");
		practice("A-small-practice");
		practice("A-large-practice");
       
	}
	public static void practice(String fileName){
		String fileNameInput = path + "//RoundC//" + fileName + ".in";
		String fileNameOutput = path + "//RoundC//" + fileName + ".out";
		String line = null;

	    try {
	        	
	    	 FileReader fileReader = new FileReader(fileNameInput);
	    	 FileWriter fileWriter = new FileWriter(fileNameOutput);

	    	 BufferedReader bufferedReader = new BufferedReader(fileReader);
	    	 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	            
	    	 line = bufferedReader.readLine();
	    	 int caseNum = Integer.parseInt(line);
	            
	    	 for(int i = 0; i < caseNum; i++){

	    		 bufferedWriter.write("Case #" + i + ": ");
	    		 bufferedWriter.newLine();
	    	 }
	    	 bufferedReader.close();    
	    	 bufferedWriter.close();
	     }
	     catch(FileNotFoundException ex) {
	    	 System.out.println("Unable to open file '" + fileNameInput + "'");                
	     }
	     catch(IOException ex) {
	    	 System.out.println("Error reading file '"  + fileNameInput + "'");                   
	     }
	}
}
