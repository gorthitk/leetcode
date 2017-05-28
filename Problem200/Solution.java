public class Solution {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int row = grid.length;
		int col = grid[0].length;
		int count = 0;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					count++;
					mapTheIsland(grid, visited, row, col, i, j);
				}
			}
		}
		return count;
	}

	private void mapTheIsland(char[][] grid, boolean[][] visited, int row, int col, int i, int j) {
		if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || grid[i][j] == '0')
			return;
		visited[i][j] = true;
		mapTheIsland(grid, visited, row, col, i+1, j);
		mapTheIsland(grid, visited, row, col, i-1, j);
		mapTheIsland(grid, visited, row, col, i, j+1);
		mapTheIsland(grid, visited, row, col, i, j-1);
	}
}