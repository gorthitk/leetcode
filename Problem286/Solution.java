import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) {
        int n = rooms.length, m = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int idx = curr[0], idy = curr[1], dist = curr[2];

            rooms[idx][idy] = Math.min(dist, rooms[idx][idy]);

            for (int[] dir : directions) {
                int a = dir[0] + idx, b = dir[1] + idy;
                if (canVisit(a, b, rooms)) {
                    queue.add(new int[]{a, b, dist + 1});
                }
            }
        }
    }


    private boolean canVisit(int i, int j, int[][] rooms) {
        int n = rooms.length, m = rooms[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }

        if (rooms[i][j] == -1 || rooms[i][j] == 0) {
            return false;
        }

        return rooms[i][j] == Integer.MAX_VALUE;
    }
}