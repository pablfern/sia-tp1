package eightqueens;

import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;

import java.util.ArrayList;
import java.util.List;

public class EightQueensProblem implements GPSProblem {

	@Override
	public GPSState getInitState() {
		return new BoardState();
	}

	@Override
	// DO NOT USE. It was used in an older version
	public GPSState getGoalState() {
		boolean board[][] = new boolean[8][8];
		board[0][3] = true;
		board[1][6] = true;
		board[2][2] = true;
		board[3][7] = true;
		board[4][1] = true;
		board[5][4] = true;
		board[6][0] = true;
		board[7][5] = true;
		return new BoardState(board, 8);
	}

	@Override
	public boolean isGoalState(GPSState state) {
		BoardState boardState = (BoardState) state;
		boolean[][] board = boardState.getBoard();

		if (boardState.getQueenCount() != 8) {
			return false;
		}

		for (int i = 0; i < 8; i++) {
			boolean queen = false;
			for (int j = 0; j < 8; j++) {
				if (board[i][j] && queen) {
					return false;
				} else if (board[i][j] && !queen) {
					queen = true;
					if (!checkDiagonal(board, i, j))
						;
				}
			}
			queen = false;
		}
		return true;
	}

	private boolean checkDiagonal(boolean[][] board, int i, int j) {
		return step(board, i, j, 1, 1) && step(board, i, j, -1, 1)
				&& step(board, i, j, 1, -1) && step(board, i, j, -1, -1);
	}

	private boolean step(boolean[][] board, int i, int j, int stepi, int stepj) {
		for (int x = i, y = j; x < 8 && x >= 0 && y < 8 && y >= 0; x += stepi, y += stepj) {
			if (board[x][y]) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<GPSRule> getRules() {
		List<GPSRule> list = new ArrayList<GPSRule>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				list.add(new PlaceQueenRule(i, j));
			}
		}
		return list;
	}

	@Override
	public Integer getHValue(GPSState state) {
		// IS CURRENTLY NOT USED
		return 0;
	}

}
