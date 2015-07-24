package Addition;

import java.util.*;

public class UndirectedGraphNode {
	int value;
	boolean known;
	Map<UndirectedGraphNode, Integer> positiveNeighbors;
	Map<UndirectedGraphNode, Integer> negativeNeighbors;
	UndirectedGraphNode(String l, int x) { 
		value = x; 
		known = false;
		positiveNeighbors = new HashMap<UndirectedGraphNode, Integer>(); 
		negativeNeighbors = new HashMap<UndirectedGraphNode, Integer>();
	}
}
