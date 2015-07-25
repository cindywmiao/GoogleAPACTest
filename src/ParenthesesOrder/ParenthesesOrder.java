package ParenthesesOrder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ParenthesesOrder {
public static String path = System.getProperty("user.dir");
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		practice("D-my-practice");
		practice("D-small-practice");
		practice("D-large-practice");
       
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
	    		 int N = Integer.parseInt(temp[0]);
	    		 long K = Long.parseLong(temp[1]); //Integer.parseInt(temp[1]);
	    		 String result = generateParentheses(N, K);
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
	
	
	public static String generateParentheses(int n, long k) {
		
		long[] num = new long[1];
		num[0] = k;
		String[] result = new String[1];
		result[0] = "";
		
		dfs(0, 0, n, new ArrayList<Character>(), num, result);
		
		if(result[0].equals(""))
			return "Doesn't Exist!";
		else
			return result[0];
		
    }
    
    private static void dfs(int x, int y, int n, List<Character> item, long[] num, String[] result){
    	if(x > n || y > n || y > x || num[0] <= 0) return;
        if(x == n && y == n){
            //output
        	num[0]--;
        	if(num[0] == 0){
        		StringBuilder sb = new StringBuilder();
        		for(Character c : item){
        			sb.append(c);
        		}
        		result[0] = sb.toString();
        	}
        	else if(num[0] < 0){
        		System.out.println("xxx" + num[0]);
        	}
        }
       
        else{
            item.add('(');
            dfs(x + 1, y, n, item, num, result);
            item.remove(item.size() - 1);
            
            item.add(')');
            dfs(x, y + 1, n, item, num, result);
            item.remove(item.size() - 1);
        }
    }
}
