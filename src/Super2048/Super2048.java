package Super2048;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Super2048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = System.getProperty("user.dir");
        String fileNameInput = path + "//B-large-practice.in";
        String fileNameOutput = path + "//B-large-practice.out";

        // This will reference one line at a time
        String line = null;
        int count = 1;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileNameInput);
            FileWriter fileWriter = new FileWriter(fileNameOutput);
        
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            line = bufferedReader.readLine();
            int caseNum = Integer.parseInt(line);
            
            for(int i = 0; i < caseNum; i++){
            	line = bufferedReader.readLine();
            	String[] tmp = line.split(" ");
         
            	int num = Integer.parseInt(tmp[0]);
            	String direction = tmp[1];
            	
            	int[][] matrix = new int[num][num];
            	String[] number = new String[num];
            	for(int j = 0; j < num; j++){
            		line = bufferedReader.readLine();
            		number = line.split(" ");
            		
            		for(int k = 0; k < num; k++){
            			matrix[j][k] = Integer.parseInt(number[k]);
            		}
            	}
            	
            	bufferedWriter.write("Case #" + count + ":");
            	bufferedWriter.newLine();
            	
            	super2048(num, matrix, direction);
            	
            	for(int j = 0; j < num; j++){
            		for(int k = 0; k < num; k++){
            			bufferedWriter.write(matrix[j][k] + " ");
            		}
            		bufferedWriter.newLine();
            	}
            	count++;
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
	
	public static void super2048(int num, int[][] matrix, String direction){
		int[] numbers = new int[num];
		if(direction.equals("up")){
			for(int col = 0; col < num; col++){
				for(int row = 0; row < num; row++){
					numbers[row] = matrix[row][col];
				}
				
				move(num, numbers);
				add(num, numbers);
				move(num, numbers);
				for(int row = 0; row < num; row++){
					matrix[row][col] = numbers[row];
				}
			}
		}
		else if(direction.equals("down")){
			for(int col = 0; col < num; col++){
				for(int row = num - 1; row >= 0; row--){
					numbers[num - 1 - row] = matrix[row][col];
				}
				
				move(num, numbers);
				add(num,numbers);
				move(num, numbers);
				for(int row = num - 1; row >= 0; row--){
					matrix[row][col] = numbers[num - 1 - row];
				}
			}
		}
		else if(direction.equals("left")){
			for(int row = 0; row < num; row++){
				for(int col = 0; col < num; col++){
					numbers[col] = matrix[row][col];
				}
				
				move(num, numbers);
				add(num, numbers);
				move(num, numbers);
				for(int col = 0; col < num; col++){
					matrix[row][col] = numbers[col];
				}
			}
		}
		else if(direction.equals("right")){
			for(int row = 0; row < num; row++){
				for(int col = num - 1; col >= 0; col--){
					numbers[num - 1- col] = matrix[row][col];
				}
				
				move(num, numbers);
				add(num, numbers);
				move(num, numbers);
				
				for(int col = num - 1; col >= 0; col--){
					matrix[row][col] = numbers[num - col - 1];
				}
			}
		}
		else{
			System.out.println("Wrong direction");//throw exception;
		}
	}

	public static void move(int num, int[] numbers){
		int start = 0;
		for(int i = 0; i < num; i++){
			if(numbers[i] != 0 && i == start) start++;
			else if(numbers[i] != 0){
				numbers[start] = numbers[i];
				numbers[i] = 0;
				start++;
			}
		}
	}
	
	public static void add(int num, int[] numbers){
		for(int i = 1; i < num; i++){
			if(numbers[i] == numbers[i - 1]){
				numbers[i - 1] = numbers[i] * 2;
				numbers[i] = 0;
			}
		}
	}
}
