public class Solution {

	//Brute force solution
	public int longestLine(int[][] M) {
		int len = 0;
		if (M == null || M.length == 0 || M[0].length == 0) {
			return len;
		}
		int rows = M.length;
		int cols = M[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(M[i][j] !=0) {
					len = Math.max(dfs(M, i, j, rows, cols), len);
				}
			}
		}
		return len;
	}

	private int dfs(int[][] matrix, int rowIdx, int colIdx, int rows, int cols) {

		int len = 0;
		//vertical
		int i = rowIdx;
		int curr = 0;
		while (i < rows && matrix[i][colIdx] == 1) {
			i++;
			curr++;
		}
		len = Math.max(curr, len);
		
		
		//Horizontal
		int j = colIdx;
		curr = 0;
		while (j < cols && matrix[rowIdx][j] == 1) {
			j++;
			curr++;
		}
		len = Math.max(curr, len);
		
		//diagonal
		i = rowIdx;
		j = colIdx;
		curr = 0;
		while (i < rows && j < cols && matrix[i][j] == 1) {
			curr++;
			i++;
			j++;
		}
		len = Math.max(curr, len);
		
		//anti diagonal
		i = rowIdx;
		j = colIdx;
		curr = 0;
		while (j>=0 && i < rows && matrix[i][j] == 1) {
			curr++;
			i++;
			j--;
		}
		len = Math.max(curr, len);
		
		return len;
	}
}