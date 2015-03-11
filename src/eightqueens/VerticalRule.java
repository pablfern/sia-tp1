package eightqueens;

import exception.NotAppliableException;
import gps.api.GPSRule;
import gps.api.GPSState;

public class VerticalRule implements GPSRule {

	@Override
	public Integer getCost() {
		return 0;
	}

	@Override
	public String getName() {
		return "Vertical collision Rule";
	}

	@Override
	public GPSState evalRule(GPSState state) throws NotAppliableException {
		GPSState ans = null;
		boolean[][] board = ((BoardState) state).getBoard();
		int j = ((BoardState) state).getJ();

		for (int i = 0; i < 8; i++) {
			if (board[i][j]) {
				throw new NotAppliableException();
			}
		}

		ans = ((BoardState) state).move();

		return ans;
	}
}
