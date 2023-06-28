class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend < divisor) {
            return 0;
        }
        int val = divisor;
        int powerOfTwo = 1;
        while (val + val < dividend) {
            powerOfTwo += 1;
            val += val;
        }


        return powerOfTwo + divide(dividend - val, divisor);
    }
}