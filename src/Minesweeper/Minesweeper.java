package Minesweeper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Minesweeper {
	public static String path = System.getProperty("user.dir");
    

	public static void main(String[] args) {
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
	    		 line = bufferedReader.readLine();
	    		 int n = Integer.parseInt(line);
	    		 int[][] matrix = new int[n][n];
	    		 
	    		 for(int j = 0; j < n; j++){
	    			 line = bufferedReader.readLine();
	    			 for(int k = 0; k < n; k++){
	    				 if(line.charAt(k) == '.'){
	    					 matrix[j][k] = 0;
	    				 }
	    				 else if(line.charAt(k) == '*'){
	    					 matrix[j][k] = -1;
	    				 }
	    			 }
	    		 }
	    		 int result = minesweeper(n, matrix);
	    		 
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
	
	
	public static int minesweeper(int n, int[][] matrix){
		int result = 0;
		Map<Integer, GraphNode> mines = new HashMap<Integer, GraphNode>();
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				GraphNode node = new GraphNode(i * n + j, matrix[i][j]);
				mines.put(i * n + j, node);
			}
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				int pos = i * n + j;
				int count = 0;
				GraphNode node = mines.get(pos);
				if(j > 0){
					if(matrix[i][j - 1] == -1) count++;
					node.neighbors.put(pos - 1, mines.get(pos - 1));
				}
				if(j < n - 1){
					if(matrix[i][j + 1] == -1) count++;
					node.neighbors.put(pos + 1, mines.get(pos + 1));
				}
				if(i > 0){
					if(matrix[i - 1][j] == -1) count++;
					node.neighbors.put(pos - n, mines.get(pos - n));
				}
				if(i < n - 1){
					if(matrix[i + 1][j] == -1) count++;
					node.neighbors.put(pos + n,mines.get(pos + n));
				}
				if(i > 0 && j > 0){
					if(matrix[i - 1][j - 1] == -1) count++;
					node.neighbors.put(pos - n - 1, mines.get(pos - n - 1));
				}
				if(i < n - 1 && j > 0){
					if(matrix[i + 1][j - 1] == -1) count++;
					node.neighbors.put(pos + n - 1, mines.get(pos + n - 1));
				}
				if(i > 0 && j < n - 1){
					if(matrix[i - 1][j + 1] == -1) count++;
					node.neighbors.put(pos - n + 1, mines.get(pos - n + 1));
				}
				if(i < n - 1 && j < n - 1){
					if(matrix[i + 1][j + 1] == -1) count++;
					node.neighbors.put(pos + n + 1, mines.get(pos + n + 1));
				}
				
				node.value = node.value == -1 ? -1 : count;
			}
		}
		
		for(Map.Entry<Integer, GraphNode> entry : mines.entrySet()){
			GraphNode node = entry.getValue();
			if(!node.flag){
				node.flag = true;
				if(node.value == 0){
					result++;
					List<GraphNode> l = new ArrayList<GraphNode>();
					l.add(node);
					
					while(l.size() != 0){
						GraphNode curr = l.get(0);
						for(Map.Entry<Integer, GraphNode> newEntry : curr.neighbors.entrySet()){
							if(newEntry.getValue().value == 0 && !newEntry.getValue().flag) l.add(newEntry.getValue());
							newEntry.getValue().flag = true;
						}
						l.remove(0);
					}
				}
				else if(node.value != -1){
					Map<Integer, GraphNode> neighbors = node.neighbors;
					boolean sum = false;
					for(Map.Entry<Integer, GraphNode> newEntry : neighbors.entrySet()){
						if(newEntry.getValue().value == 0){
							sum = true;
							break;
						}
					}
					if(!sum) result++;
				}
			}
		}
		
		/*for(Map.Entry<Integer, GraphNode> entry : mines.entrySet()){
			System.out.print(entry.getKey() + " : " + entry.getValue().value + " : " + entry.getValue().flag + " ");
			Map<Integer, GraphNode> neighbors = entry.getValue().neighbors;
			for(Map.Entry<Integer, GraphNode> newEntry : neighbors.entrySet()){
				System.out.print(newEntry.getKey() + " ");
			}
			
			System.out.println("");
		}
		
		System.out.println();*/
		return result;
	}
	
}
