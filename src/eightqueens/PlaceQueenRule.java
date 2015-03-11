package eightqueens;

import exception.NotAppliableException;
import gps.api.GPSRule;
import gps.api.GPSState;

public class PlaceQueenRule implements GPSRule {

	private int i;
	private int j;

	public PlaceQueenRule(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public Integer getCost() {
		return 0;
	}

	@Override
	public String getName() {
		return "Place queen Rule";
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
