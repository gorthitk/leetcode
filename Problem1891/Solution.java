class Solution {
    public int maxLength(int[] ribbons, int k) {
        int l = 1;

        int r = ribbons[0];
        for (int ribbon : ribbons) {
            r = Math.max(r, ribbon);
        }

        int result = 0;
        while (l <= r) {
            int mid = (r + l) / 2;
            int count = calculateSegments(ribbons, mid);

            if (count >= k) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }


    private int calculateSegments(int[] ribbons, int len) {
        int count = 0;
        for (int i = 0; i < ribbons.length; i++) {
            count += ribbons[i] / len;
        }

        return count;
    }
}