package Addition;

import java.util.*;

public class UndirectedGraphNode {
	double value;
	boolean known;
	Map<UndirectedGraphNode, Integer> positiveNeighbors;
	Map<UndirectedGraphNode, Integer> negativeNeighbors;
	UndirectedGraphNode(String l, double x) { 
		value = x; 
		known = false;
		positiveNeighbors = new HashMap<UndirectedGraphNode, Integer>(); 
		negativeNeighbors = new HashMap<UndirectedGraphNode, Integer>();
	}
}
