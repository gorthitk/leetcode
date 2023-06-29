class Solution {
    public double myPow(double x, int n) {
        if (x < 0) {
            return binaryExp(x * -1, (long) n) * (n % 2 != 0 ? -1 : 1);
        }

        if (n < 0) {
            return 1 / binaryExp(x, ((long) n) * -1);
        }

        return binaryExp(x, (long) n);
    }

    private double binaryExp(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n % 2 == 1) {
            return x * binaryExp(x * x, (n - 1) / 2);
        }

        return binaryExp(x * x, n / 2);
    }
}