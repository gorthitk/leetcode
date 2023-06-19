
class Solution {
    private int[] prefix;
    private int total;

    public Solution(int[] weights) {
        int n = weights.length;
        this.prefix = new int[n];

        int total = 0;
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];
            prefix[i] = total;
        }

        this.total = total;
    }

    public int pickIndex() {
        double random = total * Math.random();

        int i = 0, j = prefix.length - 1;
        while (i < j) {
            int mid = (j + i) / 2;
            if (prefix[mid] >= random && prefix[mid] <= random) {
                return mid;
            } else {
                if (prefix[mid] > random) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
            }
        }

        return i;
    }
}
