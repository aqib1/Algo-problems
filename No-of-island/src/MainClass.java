import java.util.Objects;

public class MainClass {

	public static int getNoOfIsland(int[][] land) {
		if (Objects.isNull(land)) {
			throw new IllegalArgumentException("Land cannot be null");
		}
		if (land.length == 0) {
			throw new IllegalArgumentException("Land cannot be empty");
		}
		int counter = 0;

		for (int c = 0; c < land.length; c++) {
			for (int v = 0; v < land[c].length; v++) {
				if (land[c][v] == 1) {
					counter++;
					placedZeroInNeighbourhood(c, v, land);
				}
			}
		}

		return counter;
	}

	private static void placedZeroInNeighbourhood(int row, int col, int[][] land) {
		/*
		 * 1 1 0 0 
		 * 1 1 0 1 
		 * 0 1 0 1
		 */
		if(row < 0 || row >= land.length || col < 0 || col >= land.length || land[row][col] == 0) return;
		land[row][col] = 0;
		
		//move right
		placedZeroInNeighbourhood(row, col+1, land);
		//move down
		placedZeroInNeighbourhood(row+1, col, land);
		//move left
		placedZeroInNeighbourhood(row, col-1, land);
		//move up
		placedZeroInNeighbourhood(row-1, col, land);
	}

	public static void main(String[] args) {
		System.out.println(getNoOfIsland(new int[][] {{1,1,0,0},{1,1,0,0}, {0,1,0,1}}));
	}

}
