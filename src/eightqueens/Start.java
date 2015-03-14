package eightqueens;

import gps.GPSEngine;
import gps.SearchStrategy;
import gps.api.GPSProblem;

public class Start {
	public static void main(String[] args) {
		System.out.println("Calculando...");
		long start = System.currentTimeMillis();
		GPSProblem problem = new EightQueensProblem();
		GPSEngine engine = new EightQueensEngine();
		engine.engine(problem, SearchStrategy.DFS);
		long end = System.currentTimeMillis();
		System.out.println("Fin. Tiempo estimado: " + (end-start)/1000 + " segundos");
	}
}
