package SevenSegmentDisplay;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class SevenSegmentDisplay {
	
	public static String[] stans = {"1111011", "1111111", "1110000", "1011111", "1011011", "0110011", "1111001", "1101101", "0110000"};

	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
        String fileNameInput = path + "//A-small-practice.in";
        //String fileNameOutput = path + "//A-small-practice.out";

        // This will reference one line at a time
        String line = null;
        int count = 0;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileNameInput);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	if(count != 0){
            		String[] argv = line.split(" ");
            		System.out.println("Case #" + count + ": " + sevenSegmentDisplay(argv));
            	}
            	count++;
            }    
            bufferedReader.close();            
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileNameInput + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"  + fileNameInput + "'");                   
        }
        
        testCases();
     
	}
	
	public static void testCases(){
		
	}
	
	public static String sevenSegmentDisplay(String[] args){
		int num = Integer.parseInt(args[0]);
		if(args.length != num + 1)
			return "ERROR";

		if(num == 1){
			if(args[1].equals(stans[1])) return stans[2];
		}
		else{
			for(int i = 1; i < args.length; i++){
			}	
		}
		
		return "ERROR";
	}	

}
