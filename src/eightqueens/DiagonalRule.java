package eightqueens;

import exception.NotAppliableException;
import gps.api.GPSRule;
import gps.api.GPSState;

public class DiagonalRule implements GPSRule {

	@Override
	public Integer getCost() {
		return 0;
	}

	@Override
	public String getName() {
		return "Diagonal collision Rule";
	}

	@Override
	public GPSState evalRule(GPSState state) throws NotAppliableException {
		GPSState ans = null;
		boolean[][] board = ((BoardState) state).getBoard();
		int j = ((BoardState) state).getJ();
		int i = ((BoardState) state).getI();
		step(board, i, j, 1, 1);
		step(board, i, j, -1, 1);
		step(board, i, j, 1, -1);
		step(board, i, j, -1, -1);

		ans = ((BoardState) state).move();

		return ans;
	}

	private void step(boolean[][] board, int i, int j, int stepi, int stepj)
			throws NotAppliableException {
		for (int x = i; x < 8 && x >= 0; x = +stepi) {
			for (int y = j; y < 8 && y >= 0; y = +stepj) {
				if (board[x][y]) {
					throw new NotAppliableException();
				}
			}
		}
	}
}
