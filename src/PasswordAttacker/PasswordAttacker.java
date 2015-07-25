package PasswordAttacker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PasswordAttacker {
	public static String path = System.getProperty("user.dir");
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		practice("A-small-practice");
		practice("A-large-practice");
       
	}
	
	public static void practice(String fileName){
		String fileNameInput = path + "//RoundB//" + fileName + ".in";
		String fileNameOutput = path + "//RoundB//" + fileName + ".out";
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
	    		 String[] temp = line.split(" ");
	    		 int m = Integer.parseInt(temp[0]);
	    		 int n = Integer.parseInt(temp[1]);
	    		 bufferedWriter.write("Case #" + i + ": ");
	    		 int result = passwordAttacker(m, n);
	    		 if(result != 0){
	    			 bufferedWriter.write("" + result);
	    		 }
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
	
	public static int passwordAttacker(int m, int n){
		if (m == 1 || m == n) return 1;
		else return 0;
		
	}
}
