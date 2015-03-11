package eightqueens;

import gps.GPSEngine;
import gps.SearchStrategy;
import gps.api.GPSProblem;

public class Start {
	public static void main(String[] args) {
		GPSProblem problem = new EightQueensProblem();
		GPSEngine engine = new EightQueensEngine(SearchStrategy.BFS);
		engine.engine(problem, SearchStrategy.BFS);
	}
}
