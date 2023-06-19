import java.util.PriorityQueue;

class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));

        k = Math.min(k, points.length);
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];

            queue.add(new int[] {
                    point[0],
                    point[1],
                    calculateDistance(point[0], point[1])
            });

            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (!queue.isEmpty()) {
            int[] pt = queue.poll();
            result[i++] = new int[]{pt[0], pt[1]};
        }

        return result;
    }


    private static int calculateDistance(int i, int j) {
        return i * i + j * j;
    }
}