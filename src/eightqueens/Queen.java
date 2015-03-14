package eightqueens;

public class Queen implements Comparable<Queen> {
	private int i;
	private int j;

	public Queen(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Queen other = (Queen) obj;

		if (i == other.i && j == other.j)
			return true;

		return false;
	}

	public boolean isAttacking(Queen queen) {
//		Check vertical and horizontal
		if (i == queen.i || j == queen.j)
			return true;
		float diff1 = i - queen.i;
		float diff2 = j - queen.j;
//		Check Diagonal
		if (Math.abs(diff1 / diff2) == 1)
			return true;
		return false;
	}

	@Override
	public int compareTo(Queen o) {
		if (i > o.i) {
			return 1;
		} else if (i < o.i) {
			return -1;
		} else if (j > o.j) {
			return 1;
		} else if (j < o.j) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Queen [i=" + i + ", j=" + j + "]";
	}

}
