class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int total = 0, max = 0;
        for (int weight : weights) {
            total += weight;
            max = Math.max(max, weight);
        }

        int l = max, r = total;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            int daysRequired = calculate(weights, mid);

            if (daysRequired > days) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private int calculate(int[] weights, int capacity) {
        int days = 1;
        int curr = 0;
        for (int w : weights) {
            curr += w;
            if (curr > capacity) {
                days++;
                curr = w;
            }
        }

        return days;
    }
}