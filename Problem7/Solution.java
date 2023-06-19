class Solution {
    public int reverse(int x) {

        boolean isNeg = x < 0;
        int cutOff = Integer.MAX_VALUE / 10;
        x = Math.abs(x);
        int a = 0;
        while (x > 0) {
            int d = x % 10;

            // Validate
            if (a > cutOff) {
                return 0;
            }
            if (a == cutOff) {
                if (isNeg && d > 8) {
                    return 0;
                }

                if (!isNeg && d > 7) {
                    return 0;
                }
            }

            a = a * 10 + x % 10;
            x = x / 10;
        }


        return isNeg ? -1 * a : a;
    }
}