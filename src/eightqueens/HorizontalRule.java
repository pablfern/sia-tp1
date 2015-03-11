package eightqueens;

import exception.NotAppliableException;
import gps.api.GPSRule;
import gps.api.GPSState;

public class HorizontalRule implements GPSRule {

	@Override
	public Integer getCost() {
		return 0;
	}

	@Override
	public String getName() {
		return "Horizontal collision Rule";
	}

	@Override
	public GPSState evalRule(GPSState state) throws NotAppliableException {
		GPSState ans = null;
		boolean[][] board = ((BoardState) state).getBoard();
		int i = ((BoardState) state).getI();

		for (int j = 0; j < 8; j++) {
			if (board[i][j]) {
				throw new NotAppliableException();
			}
		}
		
		ans = ((BoardState) state).move();

		return ans;
	}
}
