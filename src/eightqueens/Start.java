package eightqueens;

import gps.GPSEngine;
import gps.SearchStrategy;
import gps.api.GPSProblem;

public class Start {
	public static void main(String[] args) {
		System.out.println("Calculando...");
		GPSProblem problem = new EightQueensProblem();
		GPSEngine engine = new EightQueensEngine();
		engine.engine(problem, SearchStrategy.BFS);
		System.out.println("Fin");
	}
}
