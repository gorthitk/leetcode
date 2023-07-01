class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a,b) -> b[0] - a[0]
        );

        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            queue.add(new int[] {nums[i], i});
        }

        result[0] = queue.peek()[0];

        int r = 1;
        for (int i = k ; i < n; i++) {
            while (!queue.isEmpty() && queue.peek()[1] <= i - k) {
                queue.poll();
            }

            queue.add(new int[] {nums[i], i});
            result[r++] = queue.peek()[0];
        }

        return result;
    }
}