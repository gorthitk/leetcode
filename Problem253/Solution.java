class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        PriorityQueue<Integer> queue = new PriorityQueue();
        queue.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if (queue.peek() <= curr[0]) {
                queue.poll();
            }

            queue.add(curr[1]);
        }


        return queue.size();
    }
}