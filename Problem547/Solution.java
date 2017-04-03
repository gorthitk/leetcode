import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int findCircleNum(int[][] M) {
		int n = M.length;
		boolean[] visited = new boolean[n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visit(i, visited, M, n);
				cnt++; 
			}
		}
		return cnt;
	}

	private void visit(int person, boolean[] visited, int[][] m, int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(person);
		while(!queue.isEmpty()) {
			int p = queue.poll();
			if(!visited[p]) {
				visited[p] = true;
				for (int i =0;i < n; i++) {
					if (m[p][i] == 1) queue.add(i);
				}
			}
		}
	}
}