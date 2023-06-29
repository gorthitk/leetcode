class Solution {
    private static int[][] directions = new int[][] {
            {-1, 2},
            {-2, 1},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1}
    };

    public int minKnightMoves(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int steps = 0;

        boolean[][] visited = new boolean[607][607];
        visited[302][302] = true;

        while(!queue.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                int[] pop = queue.poll();
                if (pop[0] == x && pop[1] == y) {
                    return steps;
                }


                for (int[] dir : directions) {
                    int a = pop[0] + dir[0];
                    int b = pop[1] + dir[1];
                    if (visited[a + 302][b + 302]) {
                        continue;
                    }
                    queue.add(new int[]{a, b});
                    visited[a + 302][b + 302] = true;
                }
            }

            steps++;
        }


        return -1;
    }
}