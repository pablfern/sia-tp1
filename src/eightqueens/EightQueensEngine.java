package eightqueens;

import gps.GPSEngine;
import gps.GPSNode;

import javax.management.RuntimeErrorException;

public class EightQueensEngine extends GPSEngine {

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
