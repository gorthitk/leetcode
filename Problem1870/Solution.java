class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = 100_00_000;
        int result = -1;
        while (l <= r) {
            int mid = (r + l) / 2;
            double timeReq = calculate(dist, mid);

            if (timeReq <= hour) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    private double calculate(int[] dist, double speed) {
        double time = 0;
        for (int i = 0; i < dist.length; i++) {
            double t = (double) dist[i] / (double) speed;
            time += i == dist.length - 1 ? t : Math.ceil(t);
        }

        return time;
    }
}