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
	// Since the board checks for duplicate queens in rows, columns and diagonals
	// This method is only required to check the total count of queens.
	public boolean isGoalState(GPSState state) {
		BoardState boardState = (BoardState) state;
		return boardState.getQueenCount() == 8;
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
