package eightqueens;

import exception.NotAppliableException;
import gps.api.GPSState;

public class BoardState implements GPSState {

	private boolean board[][];

	// private int i;
	// private int j;

	public BoardState() {
		this.board = new boolean[8][8];
	}

	public BoardState(boolean board[][]) {
		this.board = board;
	}

	@Override
	public boolean compare(GPSState state) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] != ((BoardState) state).getPosition(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean getPosition(int i, int j) {
		return board[i][j];
	}

	public GPSState move(int i, int j) throws NotAppliableException {
		boolean[][] newBoard = this.board;
		if (newBoard[i][j]) {
			throw new NotAppliableException();
		}
		newBoard[i][j] = true;

		return new BoardState(newBoard);
	}

	public boolean[][] getBoard() {
		return board;
	}

	// public int getI(){
	// return i;
	// }
	//
	// public int getJ(){
	// return j;
	// }
}
