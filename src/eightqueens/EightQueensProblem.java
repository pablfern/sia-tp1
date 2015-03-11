package eightqueens;

import java.util.ArrayList;
import java.util.List;

import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;

public class EightQueensProblem implements GPSProblem {

	@Override
	public GPSState getInitState() {
		return new BoardState();
	}

	@Override
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
		return new BoardState(board);
	}

	@Override
	public List<GPSRule> getRules() {
		List<GPSRule> list = new ArrayList<GPSRule>();
		list.add(new DiagonalRule());
		list.add(new VerticalRule());
		list.add(new HorizontalRule());
		return list;
	}

	@Override
	public Integer getHValue(GPSState state) {
		// IS CURRENTLY NOT USED
		return 0;
	}

}
