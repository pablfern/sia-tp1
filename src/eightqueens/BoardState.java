package eightqueens;

import exception.NotAppliableException;
import gps.api.GPSState;

public class BoardState implements GPSState {

	private boolean board[][];
	private int queenCount = 0;

	public BoardState() {
		this.board = new boolean[8][8];
	}

	public BoardState(boolean board[][], int queenCount) {
		this.board = board;
		this.queenCount = queenCount;
	}

	public int getQueenCount() {
		return queenCount;
	}

	@Override
	public boolean compare(GPSState state) {
		if (queenCount != ((BoardState) state).getQueenCount()) {
			return false;
		}

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

	private boolean[][] copyBoard() {
		boolean[][] newBoard = new boolean[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				newBoard[i][j] = board[i][j];
			}
		}

		return newBoard;
	}

	public GPSState placeQueen(int i, int j) throws NotAppliableException {
		boolean[][] newBoard = copyBoard();
		if (newBoard[i][j] || queenCount == 8) {
			throw new NotAppliableException();
		}
		checkHorizontalAndVertical(i, j);
		checkDiagonal(i, j);
		newBoard[i][j] = true;

		return new BoardState(newBoard, queenCount + 1);
	}

	public boolean[][] getBoard() {
		return board;
	}
	
	private void checkHorizontalAndVertical(int row, int column) throws NotAppliableException{
		for(int i = 0; i <8; i++){
			if(board[row][i] || board[i][column]){
				throw new NotAppliableException();
			}
		}
	}

	private void checkDiagonal(int i, int j) throws NotAppliableException {
		step(board, i, j, 1, 1);
		step(board, i, j, -1, 1);
		step(board, i, j, 1, -1);
		step(board, i, j, -1, -1);
	}

	private void step(boolean[][] board, int i, int j, int stepi, int stepj)
			throws NotAppliableException {
		for (int x = i, y = j; x < 8 && x >= 0 && y < 8 && y >= 0; x += stepi, y += stepj) {
			if (board[x][y]) {
				throw new NotAppliableException();
			}
		}
	}

}
