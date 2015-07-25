package NewYearEve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NewYearEve {
	public static String path = System.getProperty("user.dir");
    public static double bottleCapacity = 750;
    public static double glassCapacity = 250;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		practice("B-my-practice");
		practice("B-small-practice");
		practice("B-large-practice");
       
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
	    		 double result = newYearEve(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
	    		 bufferedWriter.write("Case #" + (i + 1) + ": " + result);
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
	
	public static double newYearEve(int B, int L, int N){
		double result = 0;
		
		int[] level = new int[L];
		level[0] = 1;
		for(int i = 1; i < L; i++){
			level[i] = level[i - 1] + i + 1;
		}
		
		
		double sum = B * bottleCapacity;
		
		int count = 0;
		while(count < L - 1){
			if(sum < 0) return 0;
			sum -= (count == 0 ? level[count] : level[count - 1] * 3) * glassCapacity;
			count++;
		}
		
		if(sum > level[count] * glassCapacity) return 250;
		else if(sum < 0) return 0;
		else{
			result = sum / (level[count - 1]  * 3);
			return result;
		}
	}

}
