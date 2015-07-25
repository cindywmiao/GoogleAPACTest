package Minesweeper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Minesweeper {
	public static String path = System.getProperty("user.dir");
    

	public static void main(String[] args) {
		practice("A-my-practice");
		//practice("A-small-practice");
		//practice("A-large-practice");
       
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
	    		 line = bufferedReader.readLine();
	    		 int n = Integer.parseInt(line);
	    		 int[][] matrix = new int[n][n];
	    		 
	    		 for(int j = 0; j < n; j++){
	    			 line = bufferedReader.readLine();
	    			 for(int k = 0; k < n; k++){
	    				 if(line.charAt(k) == '.') matrix[j][k] = 0;
	    				 else if(line.charAt(k) == '*') matrix[j][k] = -1;
	    			 }
	    		 }
	    		 minesweeper(n, matrix);
	    		 
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
	
	public static int minesweeper(int n, int[][] matrix){
		printMatrix(n, matrix);
		return 0;
	}
	
	public static void printMatrix(int n, int[][] matrix){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
