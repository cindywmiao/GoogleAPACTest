package Minesweeper;

import java.util.*;

public class GraphNode {
	int p;
	int value;
	boolean flag;
	Map<Integer, GraphNode> neighbors = new HashMap<Integer, GraphNode>();
	GraphNode(int p, int value) { 
		this.p = p; 
		this.value = value;
	}
}
