package Addition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Addition {
	public static String path = System.getProperty("user.dir");
    public static String fileNameInput = path + "//C-small-practice.in";
    public static String fileNameOutput = path + "//C-small-practice.out";
    
	public static Map<String, UndirectedGraphNode> graph = new HashMap<String, UndirectedGraphNode>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String line = null;
        int count = 1;

        try {
        	
        	FileReader fileReader = new FileReader(fileNameInput);
            FileWriter fileWriter = new FileWriter(fileNameOutput);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            line = bufferedReader.readLine();
            int caseNum = Integer.parseInt(line);
            
            for(int i = 0; i < caseNum; i++){
            	line = bufferedReader.readLine();
            	int knownCaseNumber = Integer.parseInt(line);
            	for(int j = 0; j < knownCaseNumber; j++){
            		line = bufferedReader.readLine();
            		
            		//build the graph
            		String[] tmp1 = line.split("=");
            		String[] tmp2 = tmp1[0].split("\\+");
            		
            		addNodeInGraph(tmp2[0], tmp2[1], Integer.parseInt(tmp1[1]));
            	}
            	
            	bufferedWriter.write("Case #" + count + ":");
            	bufferedWriter.newLine();
            	
            	line = bufferedReader.readLine();
            	int unknownCaseNumber = Integer.parseInt(line);
            	for(int j = 0; j < unknownCaseNumber; j++){
            		line = bufferedReader.readLine();
            		
            		String[] tmp1 = line.split("=");
            		String[] tmp2 = tmp1[0].split("\\+");
            		
            		calculAddition(bufferedWriter, tmp2[0], tmp2[1]);
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
	
	public static void addNodeInGraph(String elem1, String elem2, int value){
		if(elem1.equals(elem2)){
			if(graph.containsKey(elem1)){
				List<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
				UndirectedGraphNode node = graph.get(elem1);
				list.add(node);
				if(!node.known){
					node.value = value/2;	
				}
				
				while(list.size() != 0){
					for(int i = 0; i < list.size(); i++){
						node = list.get(i);
						list.remove(i);
						Map<UndirectedGraphNode, Integer> neighbors = node.positiveNeighbors;
						for(Map.Entry<UndirectedGraphNode, Integer> entry:neighbors.entrySet()){  
							UndirectedGraphNode tmpNode = entry.getKey();
							if(!tmpNode.known){
								tmpNode.value = entry.getValue() - node.value;
								tmpNode.known = true;
								list.add(tmpNode);
							}
						}
						neighbors = node.negativeNeighbors;
						for(Map.Entry<UndirectedGraphNode, Integer> entry:neighbors.entrySet()){
							UndirectedGraphNode tmpNode = entry.getKey();
							if(!tmpNode.known){
								tmpNode.value = entry.getValue() + node.value;
								tmpNode.known = true;
								list.add(tmpNode);
							}
						}
						
					}
				}
			}
			else{
				UndirectedGraphNode newNode = new UndirectedGraphNode(elem1,  value/2);
				newNode.known = true;
				graph.put(elem1, newNode);
	
			}	
		}
		else{
			if(!graph.containsKey(elem1)){
				UndirectedGraphNode newNode = new UndirectedGraphNode(elem1, 0);
				graph.put(elem1, newNode);
			}
			if(!graph.containsKey(elem2)){
				UndirectedGraphNode newNode = new UndirectedGraphNode(elem2, 0);
				graph.put(elem2, newNode);
			}
			
			UndirectedGraphNode node1 = graph.get(elem1);
			UndirectedGraphNode node2 = graph.get(elem2);
			if(!node1.positiveNeighbors.containsKey(node2)) node1.positiveNeighbors.put(node2, value);
			if(!node2.positiveNeighbors.containsKey(node1)) node2.positiveNeighbors.put(node1, value);
			
			for(Map.Entry<UndirectedGraphNode, Integer> entry : node2.positiveNeighbors.entrySet()){
				node1.negativeNeighbors.put(entry.getKey(), value - entry.getValue());
				entry.getKey().negativeNeighbors.put(node1, value - entry.getValue());
			}
			
			for(Map.Entry<UndirectedGraphNode, Integer> entry : node1.positiveNeighbors.entrySet()){
				node2.negativeNeighbors.put(entry.getKey(), value - entry.getValue());
				entry.getKey().negativeNeighbors.put(node2, value - entry.getValue());
			}
			
			for(Map.Entry<UndirectedGraphNode, Integer> entry : node2.negativeNeighbors.entrySet()){
				node1.positiveNeighbors.put(entry.getKey(), value - entry.getValue());
				entry.getKey().positiveNeighbors.put(node1, value - entry.getValue());
			}
			
			for(Map.Entry<UndirectedGraphNode, Integer> entry : node1.negativeNeighbors.entrySet()){
				node2.positiveNeighbors.put(entry.getKey(), value - entry.getValue());
				entry.getKey().positiveNeighbors.put(node2, value - entry.getValue());
			}
		}
	}
	
	public static void calculAddition(BufferedWriter bufferedwriter, String elem1, String elem2) throws IOException{
		if(graph.containsKey(elem1) && graph.containsKey(elem2)){
			UndirectedGraphNode node1 = graph.get(elem1);
			UndirectedGraphNode node2 = graph.get(elem2);
			
			
			if(node1.known && node2.known){
				bufferedwriter.write(elem1 + "+" + elem2 + "=" + node1.value + node2.value);
				bufferedwriter.newLine();
			}
			
			else if(node1.positiveNeighbors.containsKey(node2)){
				bufferedwriter.write(elem1 + "+" + elem2 + "=" + node1.positiveNeighbors.get(node2));
				bufferedwriter.newLine();
			}
		}
		
	}

}
