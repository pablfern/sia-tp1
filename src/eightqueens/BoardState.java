package eightqueens;

import exception.NotAppliableException;
import gps.api.GPSState;

import java.util.HashSet;
import java.util.Set;

public class BoardState implements GPSState {

	private Set<Queen> queens;

	public BoardState() {
		queens = new HashSet<Queen>();
	}

	public BoardState(Set<Queen> queens) {
		this.queens = queens;
	}

	public int getQueenCount() {
		return queens.size();
	}

	public Set<Queen> getQueens() {
		return this.queens;
	}
	
	public boolean maxQueensReached(){
		if(queens.size()==8)
			return true;
		return false;
	}

	@Override
	public boolean compare(GPSState state) {
		if (queens.size() != ((BoardState) state).getQueenCount()) {
			return false;
		}
		return queens.containsAll(((BoardState) state).getQueens());

	}

	private boolean addQueen(Queen queen) {
		return queens.add(queen);
	}

	public void printBoard() {
		int[][] board = new int[8][8];
		for (Queen queen : queens) {
			board[queen.getI()][queen.getJ()] = 1;
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public GPSState placeQueen(int i, int j) throws NotAppliableException {
		// If there are 8 queens you can't add any more.
		if (maxQueensReached()) {
			throw new NotAppliableException();
		}

		// Create new board
		BoardState newBoard = new BoardState();
		Queen newQueen = new Queen(i, j);

		// Iterates over the previous board
		// Before adding it to the new board it checks if
		// it belongs to the same diagonal
		for (Queen queen : queens) {
			if (newQueen.isAttacking(queen)) {
				throw new NotAppliableException();
			}
			newBoard.addQueen(new Queen(queen.getI(), queen.getJ()));
		}

		// Add the new queen to the new board
		if (!newBoard.addQueen(newQueen)) {
			throw new NotAppliableException();
		}
		return newBoard;
	}

}
