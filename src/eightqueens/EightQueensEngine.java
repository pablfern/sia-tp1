package eightqueens;

import javax.management.RuntimeErrorException;

import gps.GPSEngine;
import gps.GPSNode;
import gps.SearchStrategy;

public class EightQueensEngine extends GPSEngine {

	public EightQueensEngine(SearchStrategy myStrategy) {
		strategy = myStrategy;
	}

	@Override
	public void addNode(GPSNode node) {
		switch (strategy) {
		case BFS:
			open.add(node);
			break;
		case DFS:
			open.add(0, node);
			break;
		default:
			throw new RuntimeErrorException(null);
		}
	}
}
