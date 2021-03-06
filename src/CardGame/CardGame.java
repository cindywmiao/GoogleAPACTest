package CardGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CardGame {
	public static String path = System.getProperty("user.dir");
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		practice("C-my-practice");
		practice("C-small-practice");
		practice("C-large-practice");
       
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
	    		 String[] temp1 = line.split(" ");
	    		 int cardsNum = Integer.parseInt(temp1[0]);
	    		 int K = Integer.parseInt(temp1[1]);
	    		 int[] cards = new int[cardsNum];
	    		 line = bufferedReader.readLine();
	    		 String[] temp2 = line.split(" ");
	    		 for(int j = 0; j < temp2.length; j++){
	    			 cards[j] = Integer.parseInt(temp2[j]);
	    		 }
	    		 
	    		 int result = cardGame(cardsNum, cards, K);
	    		 bufferedWriter.write("Case #" + i + ": " + result);
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
	
	public static int cardGame(int num, int[] cards, int K){
		List<Integer> mylist = new ArrayList<Integer>();
		for(int n : cards) mylist.add(n);
		
		
		for(int i = 2; i < mylist.size();){
			if(mylist.size() < 3) return mylist.size();
			else if(i >= 2 && mylist.get(i) - mylist.get(i - 1) == K && mylist.get(i - 1) - mylist.get(i - 2) == K){
				mylist.remove(i);
				mylist.remove(i - 1);
				mylist.remove(i - 2);
				i = i - 2;
			}
			else{
				i++;
			}
		}
		return mylist.size();
	}
}
