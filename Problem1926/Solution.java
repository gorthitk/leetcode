class Solution {
    private static final int[][] directions = new int[][] {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length, m = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            while(sz-- > 0) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];

                for (int[] dir : directions) {
                    int a = x + dir[0], b = y + dir[1];
                    boolean isValid = a >= 0 && a < n
                            && b >= 0 && b < m
                            && maze[a][b] == '.';
                    if (isValid) {
                        if (a == 0 || a == n - 1 || b == 0 || b == m - 1) {
                            return steps + 1;
                        }
                        maze[a][b] = '+';
                        queue.add(new int[]{a, b});
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}